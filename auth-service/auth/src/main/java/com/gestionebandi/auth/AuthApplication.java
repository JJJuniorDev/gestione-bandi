package com.gestionebandi.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.gestionebandi.auth", "com.gestionebandi.controller","com.gestionebandi.config", "com.gestionebandi.dto","com.gestionebandi.dto","com.gestionebandi.entity","com.gestionebandi.repository", "com.gestionebandi.security","com.gestionebandi.service.impl", "com.example.jwt.token"}) // <-- AGGIUNGI QUI
@EnableJpaRepositories(basePackages = "com.gestionebandi.repository") // <-- Solo se usi Spring Data JPA e il pacchetto è diverso da quello di @SpringBootApplication
@EntityScan(basePackages = "com.gestionebandi.entity") 
public class AuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthApplication.class, args);
	}

}
