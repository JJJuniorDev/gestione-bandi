import { BandoDTO } from "./bandoDTO.model";

export class EnteDTO {
    constructor(
        public id: string,
        public nome: string,
        public codiceIstat: string, 
        public email: string,
        public tipoEnte: string, 
        public bandiAppartenenti: BandoDTO[] = []
    ){}
    
}