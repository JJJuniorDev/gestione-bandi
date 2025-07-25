import { Component, Inject, OnInit } from '@angular/core';
import { CandidaturaDTO } from '../../models/candidaturaDTO.model';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { CommonModule } from '@angular/common';
import { MatButtonModule } from '@angular/material/button';
import { MatDividerModule } from '@angular/material/divider';
import { MatCardModule } from '@angular/material/card';

@Component({
  selector: 'lib-candidatura-item',
  imports: [CommonModule, MatButtonModule, MatDividerModule, MatCardModule],
  templateUrl: './candidatura-item.html',
  styleUrl: './candidatura-item.css'
})
export class CandidaturaItem implements OnInit {

  mode: 'visualize'= 'visualize';
  candidatura?: CandidaturaDTO;


  constructor(
    @Inject(MAT_DIALOG_DATA) public data: { candidatura: CandidaturaDTO },
    private dialogRef: MatDialogRef<CandidaturaItem>
  ) {}
  
  ngOnInit(): void {
   
  }

   closeDialog(): void {
    this.dialogRef.close();
  }
  
}
