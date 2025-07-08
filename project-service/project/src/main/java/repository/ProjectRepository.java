package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Long>{

}
