import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BandoDTO } from '../models/bandoDTO.model';
import { environment } from '../../../../../src/environments/environment';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BandoService {
  
  createBando(result: BandoDTO): Observable<BandoDTO> {
    return this.http.post<BandoDTO>(`${this.apiURL}/bandi/new`, result);
  }
  
private apiURL= environment.api.project;

  constructor(private http: HttpClient) { }

  getAllBandi(){
return this.http.get<BandoDTO[]>(`${this.apiURL}/bandi`);
  }
}
