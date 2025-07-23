package com.gestionebandi.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Utenti")
public class UtentiEntity {

	@Id
    @GeneratedValue
    private UUID id;
	
	
	@Column(name = "username",nullable = false, unique = true)
	private String username;
	
	@Column(name = "password")
	private String password;
	
	 @Enumerated(EnumType.STRING) // salva come "USER", "ADMIN", ecc.
	 private Role role;

	 @Column(name="ente_id")
	 private String enteId;
	 
	 
	 public UUID getId() {
		 return id;
	 }

	 public void setId(UUID id) {
		 this.id = id;
	 }

	 public String getUsername() {
		 return username;
	 }

	 public void setUsername(String username) {
		 this.username = username;
	 }

	 public String getPassword() {
		 return password;
	 }

	 public void setPassword(String password) {
		 this.password = password;
	 }

	 public Role getRole() {
		 return role;
	 }

	 public void setRole(Role role) {
		 this.role = role;
	 }

	 public String getEnteId() {
		 return enteId;
	 }

	 public void setEnteId(String enteId) {
		 this.enteId = enteId;
	 }
	
	
}
