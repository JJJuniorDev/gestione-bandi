import { Routes } from '@angular/router';
import { provideRouter } from '@angular/router';
import { LoginComponent } from '../login-component/login-component';

export const LOGIN_ROUTES: Routes = [
  { path: 'login', component: LoginComponent },
  { path: '', redirectTo: 'login', pathMatch: 'full' } // default route
];


