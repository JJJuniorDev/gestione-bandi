import { Routes } from '@angular/router';
import { CANDIDATURE_ROUTES } from '../../projects/project-service/src/lib/candidature.routes';

export const routes: Routes = [
    {
        path: 'candidature',
        children: CANDIDATURE_ROUTES
    }
];
