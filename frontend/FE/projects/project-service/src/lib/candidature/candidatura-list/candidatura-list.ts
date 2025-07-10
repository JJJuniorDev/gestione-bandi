import { Component, OnInit, signal } from '@angular/core';
import { CandidaturaService } from '../candidatura.service';
import { CandidaturaDTO } from '../../models/candidaturaDTO.model';
import { CommonModule } from '@angular/common';
import { MatDialog } from '@angular/material/dialog';
import { AddEditCandidatura } from '../add-edit-candidatura/add-edit-candidatura';

@Component({
  selector: 'lib-project-list',
  imports: [CommonModule],
  templateUrl: './candidatura-list.html',
  styleUrls: ['./candidatura-list.css']
})
export class CandidaturaList implements OnInit{
  
  constructor(private candidaturaService: CandidaturaService,
    private dialog: MatDialog
  ){}
  
  //SE QUI NON USO SIGNAL NON FUNZIONA L'AGGIORNAMENTO DELLA LISTA
  candidature= signal<CandidaturaDTO[]>([]);
  private role:string="";
  private userId:string="1";

  ngOnInit() {
    // if (this.role === "ADMIN") {
    if(this.role===""){
    console.log("SIAMO QUI");
   this.candidaturaService.getAllCandidature().subscribe({
      next: (projects: CandidaturaDTO[]) => {
        this.candidature.set(projects);
         console.log("PROJECTS (DOPO FETCH)", this.candidature); 
      },
      error: (error) => {
        console.error('Error fetching projects:', error);
      }
   });
  }
  else {
    this.candidaturaService.getCandidatureByUserId(this.userId).subscribe({
      next: (candidature: CandidaturaDTO[]) => {
        this.candidature.set(candidature);
        console.log("PROJECTS BY ID", this.candidature);
      }
    });
  }
}

addProject(){
const dialogRef= this.dialog.open(AddEditCandidatura, {
  width: '400px',
  data: {mode: 'add', project: null } //nullo per nuovo progetto
});
dialogRef.afterClosed().subscribe(result => {
  if (result) {
    this.candidaturaService.createCandidatura(result).subscribe({
     next: (newCandidatura: CandidaturaDTO) => {
        console.log("NUOVA CANDIDATURA CREATA", newCandidatura);
        this.candidature.update(candidature => [...candidature, newCandidatura]);
      }
     });
    }
})
  }
}



