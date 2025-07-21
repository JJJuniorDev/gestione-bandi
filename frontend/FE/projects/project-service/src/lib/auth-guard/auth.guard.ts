import { inject } from '@angular/core';
import { CanActivateFn, Router } from '@angular/router';
import { AuthService } from '../auth-service';

export const authGuard: CanActivateFn = (route, state) => {
  const auth = inject(AuthService);
  const router = inject(Router);

  // Ruolo richiesto (se definito nella rotta)
  const expectedRoles = route.data?.['roles'] || (route.data?.['role'] ? [route.data['role']] : null);
 const currentRole = auth.getCurrentRole();
 
  // Se non autenticato → redirect a login
  if (!auth.isAuthenticated()) {
    router.navigate(['/login']);
    return false;
  }

  // Se c'è un ruolo richiesto, controlla che corrisponda
  if (expectedRoles && !expectedRoles.includes(currentRole || '')) {
    router.navigate(['/unauthorized']); // puoi creare una pagina Unauthorized
    return false;
  }

  return true;
};
