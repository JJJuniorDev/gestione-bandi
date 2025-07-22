import { Component, inject } from '@angular/core';
import { FormGroup, FormControl, Validators, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { Router } from '@angular/router';
import { AuthService } from '../auth-service'; 

@Component({
  selector: 'auth-login',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, HttpClientModule],
  templateUrl: './login-component.html',
})
export class LoginComponent {
  private auth = inject(AuthService);
  constructor(private router: Router) {};

  showRegister = false;

  loginForm = new FormGroup({
    username: new FormControl('', { nonNullable: true, validators: [Validators.required] }),
    password: new FormControl('', { nonNullable: true, validators: [Validators.required] })
  });

  registerForm = new FormGroup({
    username: new FormControl('', { nonNullable: true, validators: [Validators.required] }),
    password: new FormControl('', { nonNullable: true, validators: [Validators.required] }),
    confirmPassword: new FormControl('', { nonNullable: true, validators: [Validators.required] })
  });

  toggleForm() {
    this.showRegister = !this.showRegister;
  }

  submitLogin() {
    if (this.loginForm.invalid) return;

    const { username, password } = this.loginForm.getRawValue();

    this.auth.login({ username, password }).subscribe({
      next: res => {
        sessionStorage.setItem('token', res.token); // Assicurati che il BE ritorni { token: string }
        console.log('Login effettuato con successo!');
        this.router.navigate(['/bandi']);
      },
      error: err => {
        console.error('Errore login:', err);
      }
    });
  }

  submitRegister() {
    if (this.registerForm.invalid) return;

    const { username, password, confirmPassword } = this.registerForm.getRawValue();

    if (password !== confirmPassword) {
      alert('Le password non coincidono');
      return;
    }

    this.auth.register({ username, password }).subscribe({
      next: res => {
        alert('Registrazione completata!');
        this.toggleForm();
      },
      error: err => {
        console.error('Errore registrazione:', err);
      }
    });
  }
}
