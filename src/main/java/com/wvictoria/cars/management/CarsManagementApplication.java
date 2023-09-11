package com.wvictoria.cars.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CarsManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarsManagementApplication.class, args);
	}

<<<<<<< Updated upstream
=======
/*	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/cars-management/api/v1/").allowedOrigins("http://localhost:4200");
			}
		};
	}*/
>>>>>>> Stashed changes
}
