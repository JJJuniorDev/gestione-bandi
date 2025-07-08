package com.project.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.project.project",
		"controller",
		"config",
		"dto",
		"Entity",
		"mapper",
		"repository",
		"service"})
@EnableJpaRepositories("repository")  // abilita esplicitamente i repository in quel package
@EntityScan("Entity")
public class ProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}

}
