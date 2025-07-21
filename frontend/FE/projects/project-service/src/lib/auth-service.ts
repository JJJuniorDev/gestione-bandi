import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { environment } from '../../../../src/environments/environment';
import { jwtDecode } from 'jwt-decode';
import { Router } from '@angular/router';


/*
Chiama il backend (/login) con username e password.

Riceve un JWT token come risposta.

Salva il token in localStorage.

Decodifica il token per estrarre role e username.

Aggiorna gli Observable (role$ e username$) con i dati dell’utente → così i componenti sanno chi è loggato e con quale ruolo.
*/



interface JwtPayload {
  sub: string;
  role: string;
  exp: number;
}
@Injectable({ providedIn: 'root' })
export class AuthService {
  private apiURL= environment.api.auth;
 private roleSubject = new BehaviorSubject<string | null>(null);
  private usernameSubject = new BehaviorSubject<string | null>(null);
   role$ = this.roleSubject.asObservable();
  username$ = this.usernameSubject.asObservable();

  constructor(private http: HttpClient,
    private router: Router
  ) {
    this.loadFromLocalStorage();
  }

   login(credentials: { username: string; password: string }): Observable<{ token: string }> {
    return new Observable(observer => {
      this.http.post<{ token: string }>(`${this.apiURL}/login`, credentials).subscribe({
        next: res => {
          localStorage.setItem('token', res.token);
        this.decodeToken(res.token);
        
        const role=this.getCurrentRole();
        console.log('RUOLO:', role);
        if (role==='ADMIN' || role==='AMMINISTRATORE') {
          console.log('RUOLO AMMINISTRATIVO, REDIRECT A DASHBOARD ADMIN');
          this.router.navigate(['/dashboard-admin']);
        }
        else {
          console.log('RUOLO NON AMMINISTRATIVO, REDIRECT ALLA HOME');
          this.router.navigate(['/']);
        }
          observer.next(res);
          observer.complete();
        },
        error: err => observer.error(err)
      });
    });
  }

  // login(credentials: { username: string; password: string }): Observable<{ token: string }> {
  //   return this.http.post<{ token: string }>(`${this.apiURL}/login`, credentials);
  // }

   logout() {
    localStorage.removeItem('token');
    this.roleSubject.next(null);
    this.usernameSubject.next(null);
  }

  isAuthenticated(): boolean {
    const token = localStorage.getItem('token');
    return !!token && !this.isTokenExpired(token);
  }

  private decodeToken(token: string) {
    const decoded = jwtDecode<JwtPayload>(token);
    console.log('Decoded token:', decoded);
     console.log('RUOLO:', decoded.role);
    this.roleSubject.next(decoded.role);
    this.usernameSubject.next(decoded.sub);
  }

  private loadFromLocalStorage() {
    const token = localStorage.getItem('token');
    if (token && !this.isTokenExpired(token)) {
      this.decodeToken(token);
    }
  }

  private isTokenExpired(token: string): boolean {
    const decoded = jwtDecode<JwtPayload>(token);
    return decoded.exp * 1000 < Date.now();
  }
  
  register(data: { username: string; password: string }): Observable<any> {
    return this.http.post(`${this.apiURL}/register`, data);
  }

  getCurrentRole(): string | null {
  return this.roleSubject.value; // prende il ruolo attuale
}
}
