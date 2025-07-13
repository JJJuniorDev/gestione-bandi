import { BandiList } from "./bandi-list/bandi-list";

export const BANDI_ROUTES = [
    {
        path: '',
        component: BandiList,
    },
    {   
        path: 'user/:userId',
        component: BandiList,
    }
] 