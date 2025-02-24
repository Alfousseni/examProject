import { Component, inject, OnInit } from '@angular/core';
import {
  FormControl,
  FormGroup,
  NonNullableFormBuilder,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { NzInputModule } from 'ng-zorro-antd/input';
import { NzGridModule } from 'ng-zorro-antd/grid';
import { NzButtonModule } from 'ng-zorro-antd/button';
import { NzCardModule } from 'ng-zorro-antd/card';
import { NzFlexModule } from 'ng-zorro-antd/flex';
import { NzTypographyModule } from 'ng-zorro-antd/typography';
import { NzFormModule } from 'ng-zorro-antd/form';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth.service';
import { LoginRequest } from '../models/login-request';
import { NzNotificationService } from 'ng-zorro-antd/notification';
@Component({
  selector: 'app-login',
  standalone: true,
  imports: [
    NzInputModule,
    ReactiveFormsModule,
    NzGridModule,
    NzButtonModule,
    NzCardModule,
    NzFlexModule,
    NzTypographyModule,
    NzFormModule,
  ],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css',
})
export class LoginComponent {
  fb = inject(NonNullableFormBuilder);
  router = inject(Router);
  authService = inject(AuthService);
  notification = inject(NzNotificationService);
  loginForm: FormGroup<{
    username: FormControl<string>;
    password: FormControl<string>;
  }> = this.fb.group({
    username: ['', [Validators.required]],
    password: ['', [Validators.required]]
  });

  ngOnInit(): void {}

  submitForm(): void {
    if (this.loginForm.valid) {
      //console.log('submit', this.loginForm.value);
      this.authService._login<any>(this.loginForm.value.username!, this.loginForm.value.password!).subscribe({
        next: (data) => {
          this.authService.setAccessToken(data.access_token);
          this.authService.setAccessToken(data.refresh_token);
          this.authService.setIsAuthenticated(true);
          this.router.navigate(['/dashboard']);
          this.notification.create(
            "success",
            'Connexion réussie',
            'Bienvenue dans votre espace de gestion scolaire.'
          );
          this.authService._getMe().subscribe({
            next: (data) => {
              this.authService.setUserInfos(data);
            },
            error: (error) => {
              console.log(error);
            },
            complete: () => {
              console.log('traitement termine.');
            },
          })
        },
        error: (error) => {
          console.log(error);
        },
        complete: () => {
          console.log('traitement termine.');
        },
      });    
      //this.router.navigateByUrl('/myspace');
    } else {
      Object.values(this.loginForm.controls).forEach((control) => {
        if (control.invalid) {
          control.markAsDirty();
          control.updateValueAndValidity({ onlySelf: true });
        }
      });
    }
  }
}
