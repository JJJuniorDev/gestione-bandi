import { ProjectList } from "./project-list/project-list";

export const PROJECT_ROUTES = [
    {
        path: '',
        component: ProjectList,
    },
    {
        path: 'user/:userId',
        component: ProjectList,
    }
]