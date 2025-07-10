import { BandoDTO } from "./bandoDTO.model";

export class CandidaturaDTO {
  constructor(
    public id: string,
    public title: string,
    public description: string,
    public dataInvio: Date,
    public status: string,
    public userId: string,
    public bandoDTO: BandoDTO
  ) {}
}
