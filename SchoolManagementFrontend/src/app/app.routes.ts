import { Routes } from '@angular/router';
import { LayoutComponent } from './layout/layout.component';
import { StudentsComponent } from './business/students/students.component';
import { CoursesComponent } from './business/courses/courses.component';
import { LoginComponent } from './auth/login/login.component';
import { authGuard } from './auth/guard/auth.guard';
import { DashboardComponent } from './business/dashboard/dashboard.component';

export const routes: Routes = [
  {
    path : '',
    redirectTo : '/dashboard',
    pathMatch : 'full'
  },
  { 
    path: 'login',
    component : LoginComponent,
  },
  { 
    path: '',
    component : LayoutComponent,
    canActivate : [authGuard],
    children : [
      { path: 'dashboard', component : DashboardComponent },
      { path: 'students', component : StudentsComponent },
      { path: 'courses', component : CoursesComponent },
    ]
  },
];
