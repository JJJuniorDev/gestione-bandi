import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { CandidaturaDTO } from '../../models/candidaturaDTO.model';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'lib-add-edit-candidatura',
  imports: [ReactiveFormsModule, MatFormFieldModule, MatInputModule, MatDatepickerModule, DatePipe],
  templateUrl: './add-edit-candidatura.html',
  styleUrl: './add-edit-candidatura.css',
})
export class AddEditCandidatura implements OnInit {

  mode: 'add' | 'edit' | 'default' = 'default';
  candidaturaForm: FormGroup;
  today: Date = new Date();

  constructor(
    @Inject(MAT_DIALOG_DATA)
    public data: { mode: 'add' | 'edit'; bandoId?: string; candidatura?: CandidaturaDTO },
    private dialogRef: MatDialogRef<AddEditCandidatura>,
    private fb: FormBuilder
  ) {
    if (data.mode === 'add') {
      this.mode = 'add';
    } else if (data.mode === 'edit') {
      this.mode = 'edit';
    }
     this.candidaturaForm= this.fb.group({

        title: ['', Validators.required],
        description: [''],
        dataInvio: [this.today, Validators.required],
        status: [''],
       // userId: ['', Validators.required],
      })
  }

  ngOnInit() {
    if (this.mode === 'edit' && this.data.candidatura){
      this.candidaturaForm.patchValue({
        title: this.data.candidatura.title,
        description: this.data.candidatura.description,
        dataInvio: this.data.candidatura.dataInvio,
        status: this.data.candidatura.status,
        userId: this.data.candidatura.userId, // Assuming userId is not editable
      });
    }
    if (this.mode === 'add') {
      this.candidaturaForm.patchValue({
        dataInvio: this.today, // Set today's date for new candidatura
      });
    }
  }

  onSubmit(){
    if (this.candidaturaForm.valid) {
      const candidatura: CandidaturaDTO = {
        ...this.candidaturaForm.value,
        id: this.data.candidatura ? this.data.candidatura.id : null, 
        bandoDTO: this.data.bandoId ? { id: this.data.bandoId } : null, // Assuming bandoId is passed in data
      };
      this.dialogRef.close(candidatura);
    }
  }

   onCancel(): void {
    this.dialogRef.close();
  }
}
