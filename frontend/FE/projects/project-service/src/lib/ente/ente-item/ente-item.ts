import { Component, OnInit, signal } from '@angular/core';
import { EnteService } from '../ente-service';
import { EnteDTO } from '../../models/enteDTO.model';
import { ActivatedRoute } from '@angular/router';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'lib-ente-item',
  imports: [DatePipe],
  templateUrl: './ente-item.html',
  styleUrl: './ente-item.css'
})
export class EnteItem implements OnInit{

  ente= signal<EnteDTO | null>(null);
  enteId= signal<string | null>(null);

  constructor(private enteService: EnteService,
    private route: ActivatedRoute
  ){}

  ngOnInit() {
    const id=this.route.snapshot.paramMap.get('enteId');
  this.enteId.set(id);
console.log('ID ente dalla route:', id);
  if (!this.enteId()) {
    console.error('ID dell\'ente non trovato');
    return;
  }
  this.enteService.getEnteById(this.enteId()!).subscribe((data: EnteDTO) => {
    this.ente.set(data);
  })
  }

}
