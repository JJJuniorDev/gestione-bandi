package com.gestionebandi.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gestionebandi.entity.UtentiEntity;


@Repository
public interface LoginRepository extends JpaRepository<UtentiEntity, UUID> {
	
	@Transactional
	@Modifying
	@Query(value = "INSERT INTO \"Utenti\" (username, password, ruolo) VALUES (:username, :password, :role)", nativeQuery = true)
	int registerUserAndReturnString(@Param("username") String username, @Param("password") String password,  @Param("role")String role);
	
	
	@Transactional
	@Query(value = "SELECT u.username, u.password, u.ruolo FROM \"Utenti\" u WHERE u.username = :username AND u.password = :password", nativeQuery = true)
	List<String> login(@Param("username") String username, @Param("password") String Password);
	
	
}
