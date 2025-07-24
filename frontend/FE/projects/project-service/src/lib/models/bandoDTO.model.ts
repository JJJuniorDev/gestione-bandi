import { CandidaturaDTO } from "./candidaturaDTO.model";

export class BandoDTO {
  constructor(
    public id: string,
    public titolo: string,
    public descrizione: string,
    public dataInizio: Date,
    public dataFine: Date,
    public categoria: string,
    public aperto: boolean,
    public stato: string,
    public candidature: CandidaturaDTO[]
  ) {}
}
