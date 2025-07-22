import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BandoDTO } from '../models/bandoDTO.model';
import { environment } from '../../../../../src/environments/environment';

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
}
