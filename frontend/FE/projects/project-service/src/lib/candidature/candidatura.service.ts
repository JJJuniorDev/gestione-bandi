import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { CandidaturaDTO } from "../models/candidaturaDTO.model";
import { environment } from '../../../../../src/environments/environment'; // Adjust the path as necessary

@Injectable({providedIn: 'root'})
export class CandidaturaService {


private apiURL= environment.api.project;

constructor(private http: HttpClient) {}

getAllCandidature(){
    console.log("INVIO RICHIESTA A "+this.apiURL+"/candidature");
    return this.http.get<CandidaturaDTO[]>(`${this.apiURL}/candidature`);
}

getCandidatureByUserId(userId: string) {
return this.http.get<CandidaturaDTO[]>(`${this.apiURL}/candidature/user/${userId}`);
}

createCandidatura(project: CandidaturaDTO, bandoId?: string) {
return this.http.post<CandidaturaDTO>(`${this.apiURL}/candidature`, project);
}

getCandidatureByBandoId(bandoId: string) {
  return this.http.get<CandidaturaDTO[]>(`${this.apiURL}/candidature/bando/${bandoId}`);
}
}