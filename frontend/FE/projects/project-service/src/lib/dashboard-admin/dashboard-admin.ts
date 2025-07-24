import { CommonModule } from '@angular/common';
import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { AuthService } from '../auth-service';
import { MatDialog } from '@angular/material/dialog';
import { AddEditBando } from '../bando/add-edit-bando/add-edit-bando';
import { BandoService } from '../bando/bandoService';
import { ToastrService } from 'ngx-toastr';
import { CATEGORIE_BANDO } from '../shared/categorie';
import { BandoDTO } from '../models/bandoDTO.model';
import { EnteDTO } from '../models/enteDTO.model';
import { EnteService } from '../ente/ente-service';
import { filter, switchMap, take } from 'rxjs';
import { setThrowInvalidWriteToSignalError } from '@angular/core/primitives/signals';

@Component({
  selector: 'lib-dashboard-admin',
  imports: [CommonModule,],
  templateUrl: './dashboard-admin.html',
  styleUrl: './dashboard-admin.css'
})
export class DashboardAdmin implements OnInit{


  constructor(public auth: AuthService,
    private dialog: MatDialog,
    private bandoService: BandoService,
    private toastr: ToastrService,
    private enteService: EnteService,
    private cdr: ChangeDetectorRef
  ){}
  
   bandi: BandoDTO[] = [];
  categorie$= CATEGORIE_BANDO;
   bandiFiltrati: BandoDTO[] = [];
   ente$?: EnteDTO= undefined;
   
ngOnInit() {
  this.auth.enteId$.pipe(
    take(1), // Prende il primo valore e completa l'osservabile
    filter(enteId => !!enteId), // Filtra per assicurarsi che enteId non sia null o undefined
    switchMap(enteId => {
   // Prima ottieni l'ente
      return this.enteService.getEnteById(enteId!).pipe(
        switchMap(ente => {
          this.ente$ = ente;
          console.log('Ente corrente:', this.ente$);
          // Poi, con l'ente disponibile, fai la chiamata per i bandi
          return this.bandoService.getBandiByEnte(ente.id);
   })
      );
    })
  ).subscribe({
    next: bandi => {
      this.bandi = bandi;
      this.bandiFiltrati = [...bandi];
      this.cdr.detectChanges();
      console.log('Bandi filtrati:', this.bandiFiltrati);
    },
    error: err => {
      console.error('Errore:', err);
    }
  });
}
   
  creaBando() {
  const dialogRef= this.dialog.open(AddEditBando, {
    width: '600px',
    data: {mode: 'add'}
  });
  dialogRef.afterClosed().subscribe(result => {
    if (result) {
     this.bandoService.createBando(result).subscribe({
        next: (newBando) => {
          console.log("NUOVO BANDO CREATO", newBando);
this.toastr.success('Bando creato con successo!', 'Successo');
    }
  });
  }
  });
  }

  modificaBando(bando: BandoDTO){
    const dialogRef=this.dialog.open(AddEditBando, {
      width: '600px',
      data: {mode: 'edit', bando: bando}
    });
    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.bandoService.updateBando(bando.id, result).subscribe({
          next: (updatedBando) => {
            console.log("BANDO AGGIORNATO", updatedBando);
            this.toastr.success('Bando aggiornato con successo!', 'Successo');
          },
          error: (error) => {
            console.error("Errore durante l'aggiornamento del bando", error);
            this.toastr.error('Errore durante l\'aggiornamento del bando', 'Errore');
          }
        });
      }
    });
  }

  pubblicaBando(bandoId: string) {
this.bandoService.publicateBando(bandoId).subscribe({
  next: (bando) => { 
    if (bando){
this.toastr.success('Bando pubblicato con successo!', 'Successo');
this.reloadBandi();
    }
    
}
});
}

validaBando(bandoId: string) {
this.bandoService.validateBando(bandoId).subscribe({
  next: (bando) => {
    if (bando) {
      this.toastr.success('Bando validato con successo!', 'Successo');
      this.reloadBandi();
    }
  }
});
}

visualizzaBando(bando: BandoDTO) {
 const dialogRef=this.dialog.open(AddEditBando, {
      width: '600px',
      data: {mode: 'show', bando: bando}
    });
  dialogRef.afterClosed().subscribe(result => {
    if (result) {
      console.log("Visualizzazione bando:", result);
      // Puoi gestire ulteriori azioni dopo la visualizzazione, se necessario
    }
  });
}


reloadBandi() {
  // Ricarica i bandi dell'ente corrente
  if (this.ente$ && this.ente$.id) {
    this.bandoService.getBandiByEnte(this.ente$.id).subscribe({
      next: bandi => {
        this.bandi = bandi;
        this.bandiFiltrati = [...bandi];
        this.cdr.detectChanges();
        console.log('Bandi ricaricati:', this.bandiFiltrati);
      },
      error: err => {
        console.error('Errore durante il reload dei bandi:', err);
        this.toastr.error('Errore durante il reload dei bandi', 'Errore');
      }
    });
  }
}

gestisciCandidature(arg0: string) {
throw new Error('Method not implemented.');
}



chiudiBando(arg0: string) {
throw new Error('Method not implemented.');
}
isScaduto(bando: BandoDTO): any {
if (bando.dataFine) {
  const dataFine = new Date(bando.dataFine);
  const oggi = new Date();
  return dataFine < oggi;
}
return false;
}









  getStatoClass(stato: string): string {
  switch (stato.toLowerCase()) {
    case 'bozza':
      return 'stato-bozza';
    case 'validato':
      return 'stato-validato';
    case 'pubblicato':
      return 'stato-pubblicato';
    case 'chiuso':
      return 'stato-chiuso';
    default:
      return 'stato-default';
  }
}

getStatoIcon(stato: string): string {
  switch (stato.toLowerCase()) {
    case 'bozza':
      return 'fa-pencil-alt';
    case 'validato':
      return 'fa-check-circle';
    case 'pubblicato':
      return 'fa-bullhorn';
    case 'chiuso':
      return 'fa-lock';
    default:
      return 'fa-info-circle';
  }
}
}
