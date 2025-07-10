import { Routes } from '@angular/router';
import { CANDIDATURE_ROUTES } from '../../projects/project-service/src/lib/candidature/candidature.routes';
import { BANDI_ROUTES } from '../../projects/project-service/src/lib/bando/bandi.routes';
export const routes: Routes = [
    {
        path: 'candidature',
        children: CANDIDATURE_ROUTES
    },
    {
    path: 'bandi',
    children: BANDI_ROUTES
    }
];
