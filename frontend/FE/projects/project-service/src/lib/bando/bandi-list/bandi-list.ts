import { Component, computed, OnInit, Output, signal } from '@angular/core';
import { BandoDTO } from '../../models/bandoDTO.model';
import { BandoService } from '../bandoService';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { MatDialog } from '@angular/material/dialog';
import { AddEditCandidatura } from '../../candidature/add-edit-candidatura/add-edit-candidatura';
import { CandidaturaDTO } from '../../models/candidaturaDTO.model';
import { CandidaturaService } from '../../candidature/candidatura.service';

@Component({
  selector: 'lib-bandi-list',
  imports: [CommonModule],
  templateUrl: './bandi-list.html',
  styleUrl: './bandi-list.css'
})
export class BandiList implements OnInit{
  bandi= signal<BandoDTO[]>([]);
  filterStatus= signal<'tutti' | 'aperto' | 'chiuso'>('tutti');
  constructor(private bandoService: BandoService,
    private router: Router,
    private dialog: MatDialog,
    private candidaturaService: CandidaturaService
  ){}

  ngOnInit() {
    this.bandoService.getAllBandi().subscribe({
      next: (bandi: BandoDTO[]) =>{
        this.bandi.set(bandi);
        console.log("BANDI (DOPO FETCH)", this.bandi);
      }
    })
  }

   filteredBandi = computed(() => {
    const status = this.filterStatus();
    const allBandi = this.bandi();
    
    if (status === 'tutti') return allBandi;
    
    return allBandi.filter(b => 
      status === 'aperto' ? b.aperto : !b.aperto
    );
  });

  applyForBando(bandoId: string){
  const dialogRef= this.dialog.open(AddEditCandidatura, {
    width: '400px',
    data: {mode: 'add', bandoId: bandoId}
  });
  dialogRef.afterClosed().subscribe(result => {
    if (result) {
      this.candidaturaService.createCandidatura(result).subscribe({
        next: (newCandidatura: CandidaturaDTO) => {
          console.log("NUOVA CANDIDATURA CREATA", newCandidatura);
          this.bandi.update(bandi => [...bandi]);
        }
  });
}
  });
}
}
