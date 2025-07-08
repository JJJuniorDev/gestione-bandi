package repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import Entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Long>{
Optional<List<Project>> findAllByUserId(Long id);
}
