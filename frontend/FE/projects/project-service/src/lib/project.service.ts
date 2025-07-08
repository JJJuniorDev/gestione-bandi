import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { ProjectDTO } from "./models/projectDTO.model";
import { environment } from '../../../../src/environments/environment'; // Adjust the path as necessary

@Injectable({providedIn: 'root'})
export class ProjectService {

private apiURL= environment.api.project;

constructor(private http: HttpClient) {}

getAllProjects(){
    return this.http.get<ProjectDTO[]>(`${this.apiURL}/projects`);
}
}