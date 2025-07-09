package repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import Entity.Candidatura;

public interface ProjectRepository extends JpaRepository<Candidatura, Long>{
Optional<List<Candidatura>> findAllByUserId(Long id);
}
