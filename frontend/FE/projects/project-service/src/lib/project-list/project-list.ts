import { Component, OnInit, signal } from '@angular/core';
import { ProjectService } from '../project.service';
import { ProjectDTO } from '../models/projectDTO.model';
import { CommonModule } from '@angular/common';
@Component({
  selector: 'lib-project-list',
  imports: [CommonModule],
  templateUrl: './project-list.html',
  styleUrls: ['./project-list.css']
})
export class ProjectList implements OnInit{
  
  constructor(private projectService: ProjectService){}
  
  //SE QUI NON USO SIGNAL NON FUNZIONA L'AGGIORNAMENTO DELLA LISTA
  projects= signal<ProjectDTO[]>([]);
  private role:string="";
  private userId:string="1";

  ngOnInit() {
    if (this.role === "ADMIN") {
    console.log("SIAMO QUI");
   this.projectService.getAllProjects().subscribe({
      next: (projects: ProjectDTO[]) => {
        this.projects.set(projects);
         console.log("PROJECTS (DOPO FETCH)", this.projects); 
      },
      error: (error) => {
        console.error('Error fetching projects:', error);
      }
   });
  }
  else {
    this.projectService.getProjectsByUserId(this.userId).subscribe({
      next: (projects: ProjectDTO[]) => {
        this.projects.set(projects);
        console.log("PROJECTS BY ID", this.projects);
      }
    });
  }
}
}
