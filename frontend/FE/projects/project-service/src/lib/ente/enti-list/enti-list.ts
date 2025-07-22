import { Component, OnInit, signal } from '@angular/core';
import { EnteService } from '../ente-service';
import { EnteDTO } from '../../models/enteDTO.model';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'lib-enti-list',
  imports: [],
  templateUrl: './enti-list.html',
  styleUrl: './enti-list.css'
})
export class EntiList implements OnInit {


  constructor(private enteService: EnteService,
    private http: HttpClient
  ){}

    enti=signal<EnteDTO[]>([]);


  ngOnInit(){
  this.enteService.getAllEnti().subscribe({
    next: (enti: EnteDTO[]) => {
      this.enti.set(enti);
      console.log("ENTI (DOPO FETCH)", this.enti);
    }
  });

  // TEST SPID
  // genera e firma un AuthnRequest in formato corretto (POST binding)
  
}
}
