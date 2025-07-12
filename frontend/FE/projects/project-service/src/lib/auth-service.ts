import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../../../src/environments/environment';

@Injectable({ providedIn: 'root' })
export class AuthService {
  private apiURL= environment.api.auth;

  constructor(private http: HttpClient) {}

  login(credentials: { username: string; password: string }): Observable<{ token: string }> {
    return this.http.post<{ token: string }>(`${this.apiURL}/login`, credentials);
  }

  register(data: { username: string; password: string }): Observable<any> {
    return this.http.post(`${this.apiURL}/register`, data);
  }
}
