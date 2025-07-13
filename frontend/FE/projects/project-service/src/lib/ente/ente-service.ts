import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../../../../src/environments/environment';
import { EnteDTO } from '../models/enteDTO.model';

@Injectable({
  providedIn: 'root'
})
export class EnteService {
 

  private apiURL= environment.api.project;
  
  constructor(private http: HttpClient) { }

getAllEnti() {
  console.log("INVIO RICHIESTA A " + this.apiURL + "/enti");
  return this.http.get<EnteDTO[]>(`${this.apiURL}/enti`);
}

 getEnteById(id: string) {
   return this.http.get<EnteDTO>(`${this.apiURL}/enti/${id}`);
  }
  
}
