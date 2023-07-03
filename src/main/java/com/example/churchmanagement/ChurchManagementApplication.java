package com.example.churchmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.scheduling.annotation.EnableScheduling;

import static org.hibernate.sql.ast.SqlTreeCreationLogger.LOGGER;


@SpringBootApplication

public class ChurchManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChurchManagementApplication.class, args);
	}

}
