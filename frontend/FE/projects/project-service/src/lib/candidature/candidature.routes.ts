import { CandidaturaList } from "./candidatura-list/candidatura-list";

export const CANDIDATURE_ROUTES = [
    {
        path: '',
        component: CandidaturaList,
    },
    {
        path: 'bando/:bandoId',
        component: CandidaturaList,
    },
    {
        path: 'user/:userId',
        component: CandidaturaList,
    }
]