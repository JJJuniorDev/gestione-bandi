import { Routes } from '@angular/router';
import { PROJECT_ROUTES } from '../../projects/project-service/src/lib/project.routes';

export const routes: Routes = [
    {
        path: 'projects',
        children: PROJECT_ROUTES
    }
];
