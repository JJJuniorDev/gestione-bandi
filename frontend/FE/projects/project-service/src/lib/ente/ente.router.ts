import { EnteItem } from "./ente-item/ente-item";
import { EntiList } from "./enti-list/enti-list";

export const ENTE_ROUTES = [
 {
    path: '', component: EntiList
 },
 {
    path: ':enteId', component: EnteItem
 }
]
