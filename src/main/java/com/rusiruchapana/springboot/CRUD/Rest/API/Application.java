package com.rusiruchapana.springboot.CRUD.Rest.API;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Springboot Rest API",
				version = "1.0",
				description = "Using springboot framework created RestFull web services.",
				license = @License(
						name = "Apache 2.0",
						url = "https://github.com/rusiruchapana?tab=repositories"
				),
				contact = @Contact(
						name = "Rusiru chapana",
						email = "rusiruchapana@gmail.com",
						url = "https://github.com/rusiruchapana?tab=repositories"
				)
		)

)
public class Application {

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
