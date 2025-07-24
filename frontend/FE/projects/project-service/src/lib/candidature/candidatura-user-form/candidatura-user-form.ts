import { Component, Inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MatButtonModule } from '@angular/material/button';
import { MatInputModule } from '@angular/material/input';

@Component({
  selector: 'lib-candidatura-user-form',
  standalone: true,
  imports: [
    CommonModule,
    ReactiveFormsModule,
    MatButtonModule,
    MatInputModule,
  ],
  templateUrl: './candidatura-user-form.html',
  styleUrl: './candidatura-user-form.css'
})
export class CandidaturaUserForm {
  
form: FormGroup;

  constructor(
    private fb: FormBuilder,
    public dialogRef: MatDialogRef<CandidaturaUserForm>,
    @Inject(MAT_DIALOG_DATA) public data: { bando: any }
  ) {
    this.form = this.fb.group({
      nome: ['', Validators.required],
      cognome: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      motivazione: ['', Validators.required],
      allegatoCV: [null, Validators.required]
    });
  }

  onFileChange(event: any) {
    this.form.patchValue({ allegatoCV: event.target.files[0] });
  }

  submit() {
    if (this.form.valid) {
      this.dialogRef.close({ ...this.form.value, bandoId: this.data.bando.id });
    }
  }

  close() {
    this.dialogRef.close();
  }

}
