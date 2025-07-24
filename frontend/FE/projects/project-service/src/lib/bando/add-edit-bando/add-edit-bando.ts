import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { BandoDTO } from '../../models/bandoDTO.model';
import { CommonModule, DatePipe } from '@angular/common';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule, MatOptionModule } from '@angular/material/core';
import { MatSelectModule } from '@angular/material/select';
import { CATEGORIE_BANDO } from '../../shared/categorie';

@Component({
  selector: 'lib-add-edit-bando',
  imports: [DatePipe, ReactiveFormsModule, MatFormFieldModule, MatInputModule, MatDatepickerModule, MatOptionModule, MatSelectModule, CommonModule, MatDatepickerModule, MatNativeDateModule],
  templateUrl: './add-edit-bando.html',
  styleUrl: './add-edit-bando.css'
})
export class AddEditBando implements OnInit {

  mode: 'add' | 'edit' | 'show' | 'default' = 'default';
  bandoForm: FormGroup;
  today: Date = new Date();
  categorie: string[] =CATEGORIE_BANDO;
  constructor(
    @Inject(MAT_DIALOG_DATA)
    public data: { mode: 'add' | 'edit'; bando?: BandoDTO },
    private dialogRef: MatDialogRef<AddEditBando>,
    private fb: FormBuilder
  ) {
    if (data.mode === 'add') {
      this.mode = 'add';
    } else if (data.mode === 'edit') {
      this.mode = 'edit';
    }
    else if (data.mode === 'show') {
      this.mode = 'show';
    }
     this.bandoForm= this.fb.group({

        titolo: ['', Validators.required],
        descrizione: [''],
        dataInizio: [this.today, Validators.required],
        dataFine: [null, Validators.required],
        categoria: ['', Validators.required],
        aperto: [true, Validators.required],
        candidature: [[]] 
      });
  }
     

  ngOnInit() {
    if (this.mode === 'edit' && this.data.bando){
      this.bandoForm.patchValue({
        titolo: this.data.bando.titolo,
        descrizione: this.data.bando.descrizione,
        dataInizio: this.data.bando.dataInizio,
        dataFine: this.data.bando.dataFine,
        categoria: this.data.bando.categoria, 
        aperto: this.data.bando.aperto,
        candidature: this.data.bando.candidature || []
      });
    }
    if (this.mode === 'show' && this.data.bando) {
       this.bandoForm = this.fb.group({
    titolo: [{ value: this.data.bando?.titolo || '', disabled: this.mode === 'show' }],
    descrizione: [{ value: this.data.bando?.descrizione || '', disabled: this.mode === 'show' }],
    dataInizio: [{ value: this.data.bando?.dataInizio || '', disabled: this.mode === 'show' }],
    dataFine: [{ value: this.data.bando?.dataFine || '', disabled: this.mode === 'show' }],
    categoria: [{ value: this.data.bando?.categoria || '', disabled: this.mode === 'show' }],
    aperto: [{ value: this.data.bando?.aperto || '', disabled: this.mode === 'show' }]
  });
}
    if (this.mode === 'add') {
      this.bandoForm.patchValue({
        dataInvio: this.today, // Set today's date for new candidatura
      });
    }
  }

  onSubmit(){
    if (this.bandoForm.valid) {
      const bando: BandoDTO = {
        ...this.bandoForm.value,
        id: this.data.bando ? this.data.bando.id : null, 
      };
      this.dialogRef.close(bando);
    }
  }

   onCancel(): void {
    this.dialogRef.close();
  }
}
