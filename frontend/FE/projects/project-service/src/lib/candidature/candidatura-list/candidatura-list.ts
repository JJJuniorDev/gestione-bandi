import { AfterViewInit, Component, effect, OnInit, signal, ViewChild } from '@angular/core';
import { CandidaturaService } from '../candidatura.service';
import { CandidaturaDTO } from '../../models/candidaturaDTO.model';
import { CommonModule } from '@angular/common';
import { MatDialog } from '@angular/material/dialog';
import { AddEditCandidatura } from '../add-edit-candidatura/add-edit-candidatura';
import { ActivatedRoute } from '@angular/router';
import { AuthService } from '../../auth-service';
import { RowOutlet } from '@angular/cdk/table';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';
import { CandidaturaItem } from '../candidatura-item/candidatura-item';

@Component({
  selector: 'lib-project-list',
  imports: [CommonModule, MatTableModule, MatPaginatorModule],
  templateUrl: './candidatura-list.html',
  styleUrls: ['./candidatura-list.css']
})
export class CandidaturaList implements AfterViewInit{


  
  constructor(private candidaturaService: CandidaturaService,
    private dialog: MatDialog,
    private route: ActivatedRoute,
    private auth: AuthService
  ){}
  
    displayedColumns?: string[];
  dataSource = new MatTableDataSource<CandidaturaDTO>([]);

  @ViewChild(MatPaginator) paginator!: MatPaginator;

  
  //SE QUI NON USO SIGNAL NON FUNZIONA L'AGGIORNAMENTO DELLA LISTA
  candidature= signal<CandidaturaDTO[]>([]);
   role:string="";
  private userId:string="1";

    effect = effect(() => {
    this.dataSource.data = this.candidature();
  });

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
  }

  ngOnInit() {
  
    this.auth.role$.subscribe(role => { 
       this.role = role!;  // Memorizza il ruolo
      this.displayedColumns = this.role === 'ADMIN'
    ? ['title', 'description', 'dataInvio', 'status', 'actions']
    : ['title', 'description', 'dataInvio', 'status'];
      switch(role) {
        case 'ADMIN':
const bandoId = this.route.snapshot.paramMap.get('bandoId');
     if (bandoId) {
      this.candidaturaService.getCandidatureByBandoId(bandoId).subscribe({
        next: (data) => this.candidature.set(data),
        error: (err) => console.error('Errore caricamento candidature:', err)
      });
    }
    break;
        case 'USER':
          this.auth.userId$.subscribe(userId => {
            if (userId) {
              this.userId = userId;
              this.candidaturaService.getCandidatureByUserId(this.userId).subscribe({
                next: (data) => this.candidature.set(data),
                error: (err) => console.error('Errore caricamento candidature:', err)
              });
            }
          });
          break;        
        default:
          console.error('Ruolo non gestito:', role);
          break;
      }
      
      console.log("Ruolo dell'utente:", this.role);
    });
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

  valutaCandidatura(arg0: string,arg1: string) {
throw new Error('Method not implemented.');
}


visualizzaCandidatura(candidatura: CandidaturaDTO): void {
  this.dialog.open(CandidaturaItem, {
    width: '500px',
    data: { candidatura }
  });
}
}



