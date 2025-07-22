import { Component, computed, NgModule, OnInit, signal } from '@angular/core';
import { EnteDTO } from '../models/enteDTO.model';
import { ActivatedRoute, Router } from '@angular/router';
import { FormsModule, NgModel } from '@angular/forms';
import { EnteService } from '../ente/ente-service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'lib-home',
  imports: [FormsModule, CommonModule],
  templateUrl: './home.html',
  styleUrl: './home.css'
})
export class Home implements OnInit{

 searchText = signal('');
  enti= signal<EnteDTO[]>([]);
filteredEnti = computed(() => {
    const testoDaCercare = this.searchText().toLowerCase();
    return this.enti().filter(ente => ente.nome.toLowerCase().includes(testoDaCercare));
  });

  constructor(private router: Router,
    private enteService: EnteService
  ) {}

  ngOnInit() {

    this.enteService.getAllEnti().subscribe((data: EnteDTO[]) => {
      this.enti.set(data);
    })
  }

 updateSearchText(event: Event) {
    const input= event.target as HTMLInputElement;
    this.searchText.set(input.value);
  }

  selectEnte(ente: EnteDTO) {
    this.router.navigate(['/enti', ente.id]);
  }

 trackEnteById(index: number, ente: any) {
  return ente.id;
}

onGoToLogin() {
    this.router.navigate(['/login']);
  }
  
}
