import { Component, OnInit } from '@angular/core';
import { ProjectService } from '../project.service';
import { ProjectDTO } from '../models/projectDTO.model';
import { CommonModule } from '@angular/common';
@Component({
  selector: 'lib-project-list',
  imports: [CommonModule],
  templateUrl: './project-list.html',
  styleUrl: './project-list.css'
})
export class ProjectList implements OnInit{
  
  constructor(private projectService: ProjectService){}
  
  projects: ProjectDTO[] = [];
  
  ngOnInit() {
   this.projectService.getAllProjects().subscribe({
      next: (projects: ProjectDTO[]) => {
        this.projects = projects;
      },
      error: (error) => {
        console.error('Error fetching projects:', error);
      }
   });
  }

}
