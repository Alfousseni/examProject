import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { catchError, Observable, tap, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  isAuthenticated: boolean = false;
  access_token: string = localStorage.getItem('access_token') || '';
  refresh_token: string = localStorage.getItem('refresh_token') || '';
  http = inject(HttpClient);
  router = inject(Router);
  userInfos: any;
  constructor() {}

  _login<T>(username: string, password: string): Observable<T> {
    const body = new HttpParams()
      .set('client_id', 'school-manag-client')
      .set('username', username)
      .set('password', password)
      .set('grant_type', 'password');

    const headers = new HttpHeaders({
      'Content-Type': 'application/x-www-form-urlencoded',
    });
    return this.http.post<T>(
      'http://localhost:8080/realms/school-manag-realm/protocol/openid-connect/token',
      body,
      { headers }
    );
  }

  getIsAuthenticated() {
    if (this.access_token) this.isAuthenticated = true;
    return this.isAuthenticated;
  }

  setIsAuthenticated(isAuthenticated: boolean) {
    this.isAuthenticated = isAuthenticated;
  }

  _getMe() {
    return this.http.get<any>(
      'http://localhost:8080/realms/school-manag-realm/protocol/openid-connect/userinfo'
    );
  }

  getAccessToken() {
    return this.access_token;
  }

  setAccessToken(token: string) {
    this.access_token = token;
    localStorage.setItem('access_token', token);
  }

  getRefreshToken() {
    return this.refresh_token;
  }

  setRefreshToken(token: string) {
    this.refresh_token = token;
    localStorage.setItem('refresh_token', token);
  }

  getUserInfos() {
    return this.userInfos;
  }

  setUserInfos(userInfos: any) {
    this.userInfos = userInfos;
  }

  logout(): void {
    localStorage.removeItem('access_token');
    localStorage.removeItem('refresh_token');
    this.router.navigate(['login']);
  }

  
}
