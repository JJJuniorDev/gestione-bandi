import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BandoDTO } from '../models/bandoDTO.model';
import { environment } from '../../../../../src/environments/environment';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BandoService {
 
 
  
private apiURL= environment.api.project;

  constructor(private http: HttpClient) { }

  getAllBandi(){
    console.log("Fetching all bandi from API");
      return this.http.get<BandoDTO[]>(`${this.apiURL}/bandi`);
  }

  getBandiByEnte(enteId: string): Observable<BandoDTO[]> {
    return this.http.get<BandoDTO[]>(`${this.apiURL}/bandi/ente/${enteId}`);
  }

   
  createBando(result: BandoDTO): Observable<BandoDTO> {
    return this.http.post<BandoDTO>(`${this.apiURL}/bandi/new`, result);
  }

  updateBando(id: string, result: BandoDTO): Observable<BandoDTO> {
    return this.http.put<BandoDTO>(`${this.apiURL}/bandi/${id}`, result);
  }

    publicateBando(bandoId: string): Observable<BandoDTO> {
    return this.http.put<BandoDTO>(`${this.apiURL}/bandi/${bandoId}/pubblica`, {});
  }

   validateBando(bandoId: string): Observable<BandoDTO>  {
    return this.http.put<BandoDTO>(`${this.apiURL}/bandi/${bandoId}/valida`, {});
  }

}
