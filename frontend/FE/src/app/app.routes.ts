import { Routes } from '@angular/router';
import { CANDIDATURE_ROUTES } from '../../projects/project-service/src/lib/candidature/candidature.routes';
import { BANDI_ROUTES } from '../../projects/project-service/src/lib/bando/bandi.routes';
import { ENTE_ROUTES } from '../../projects/project-service/src/lib/ente/ente.router';
import { Home } from '../../projects/project-service/src/lib/home/home';
export const routes: Routes = [
     {
    path: '', 
    component: Home
  },
    {
        path: 'candidature',
        children: CANDIDATURE_ROUTES
    },
    {
    path: 'bandi',
    children: BANDI_ROUTES
    },
    {
        path: 'enti',
        children: ENTE_ROUTES
    },
    { path: '**', redirectTo: '' } //RITORNA ALLA HOME
];
