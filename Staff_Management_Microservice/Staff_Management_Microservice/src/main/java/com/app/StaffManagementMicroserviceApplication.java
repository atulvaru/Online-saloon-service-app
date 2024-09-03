package com.app;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Staff Management Microservice API Documentation", version = "1.0", description = "API documentation for the Staff Management Microservice, handling Staff creation, management, and retrieval.", contact = @Contact(name = "Atul Kumar", email = "atulk2512001@gmail.com", url = "xyz"), license = @License(name = "Apache 2.0", url = "xyz")), externalDocs = @ExternalDocumentation(description = "spring boot Staff management documentation", url = "xyz"))
public class StaffManagementMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StaffManagementMicroserviceApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
