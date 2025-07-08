package mapper;

import dto.ProjectDTO;
import Entity.Project;

public class ProjectMapper {

    public static ProjectDTO toDTO(Project project) {
        if (project == null) return null;
        ProjectDTO dto = new ProjectDTO();
        dto.setId(project.getId() != null ? project.getId().toString() : null);
        dto.setTitle(project.getTitle());
        dto.setDescription(project.getDescription());
        dto.setStartDate(project.getStartDate());
        dto.setEndDate(project.getEndDate());
        dto.setStatus(project.getStatus());
        dto.setUserId(project.getUserId() != null ? project.getUserId().toString() : null);
        return dto;
    }

    public static Project toEntity(ProjectDTO dto) {
        if (dto == null) return null;
        Project project = new Project();
        project.setId(dto.getId() != null ? Long.valueOf(dto.getId()) : null);
        project.setTitle(dto.getTitle());
        project.setDescription(dto.getDescription());
        project.setStartDate(dto.getStartDate());
        project.setEndDate(dto.getEndDate());
        project.setStatus(dto.getStatus());
        project.setUserId(dto.getUserId() != null ? Long.valueOf(dto.getUserId()) : null);
        return project;
    }
}
