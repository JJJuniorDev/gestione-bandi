package repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import Entity.Candidatura;
import jakarta.transaction.Transactional;

public interface CandidaturaRepository extends JpaRepository<Candidatura, Long>{
	
	 @Transactional
Optional<List<Candidatura>> findAllByUserId(Long id);
}
