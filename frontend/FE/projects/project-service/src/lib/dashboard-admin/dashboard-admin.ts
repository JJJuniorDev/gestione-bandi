import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { AuthService } from '../auth-service';
import { MatDialog } from '@angular/material/dialog';
import { AddEditBando } from '../bando/add-edit-bando/add-edit-bando';
import { BandoService } from '../bando/bandoService';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'lib-dashboard-admin',
  imports: [CommonModule,],
  templateUrl: './dashboard-admin.html',
  styleUrl: './dashboard-admin.css'
})
export class DashboardAdmin {

  constructor(public auth: AuthService,
    private dialog: MatDialog,
    private bandoService: BandoService,
    private toastr: ToastrService
  ){}

  creaBando() {
  const dialogRef= this.dialog.open(AddEditBando, {
    width: '400px',
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
}
