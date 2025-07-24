import { Component, OnInit, signal } from '@angular/core';
import { EnteService } from '../ente-service';
import { EnteDTO } from '../../models/enteDTO.model';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { DatePipe } from '@angular/common';
import { BandoDTO } from '../../models/bandoDTO.model';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { HttpClient } from '@angular/common/http';
import { MatDialog } from '@angular/material/dialog';   
import { CandidaturaUserForm } from '../../candidature/candidatura-user-form/candidatura-user-form';

@Component({
  selector: 'lib-ente-item',
  standalone: true,
  imports: [DatePipe, MatIconModule, MatButtonModule, RouterLink, CandidaturaUserForm],
  templateUrl: './ente-item.html',
  styleUrl: './ente-item.css'
})
export class EnteItem implements OnInit{
  

  ente= signal<EnteDTO | null>(null);
  enteId= signal<string | null>(null);


  constructor(private enteService: EnteService,
    private route: ActivatedRoute,
    private router: Router,
    private http: HttpClient,
    private dialog: MatDialog
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

 this.http.get('https://e64043bae0da.ngrok-free.app/api/user/me', { withCredentials: true })
    .subscribe({
      next: data => console.log('Utente autenticato:', data),
      error: err => console.log('Non autenticato o errore:', err)
    });
  }
  
//reindirizza l’utente verso l’IdP SPID configurato (es. InfoCert)
//
 startSpidLogin() {
  window.location.href = 'https://e64043bae0da.ngrok-free.app/saml2/authenticate/spid';
   
 }



openCandidaturaForm(bando: any) {
    const dialogRef = this.dialog.open(CandidaturaUserForm, {
      width: '500px',
      data: { bando }
    });

    dialogRef.afterClosed().subscribe((result: any) => {
      if (result) {
        console.log('Candidatura inviata:', result);
      }
    });
  }


}
