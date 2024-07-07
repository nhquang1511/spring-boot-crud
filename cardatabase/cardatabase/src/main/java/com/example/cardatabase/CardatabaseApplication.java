package com.example.cardatabase;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.cardatabase.domain.CarRepository;
import com.example.cardatabase.domain.OwnerRepository;
import com.example.cardatabase.domain.Users;
import com.example.cardatabase.domain.UserRepository;
import com.example.cardatabase.entity.Car;
import com.example.cardatabase.entity.Owner;

@SpringBootApplication
public class CardatabaseApplication {
	private static final Logger logger = LoggerFactory.getLogger(CardatabaseApplication.class);
	
	@Autowired 
	private CarRepository repository;
	
	@Autowired 
	private OwnerRepository orepository;
	
	@Autowired
	private UserRepository urepository;

	
	public static void main(String[] args) {
		SpringApplication.run(CardatabaseApplication.class, args);
		logger.info("Hello Spring Boot");
	}
	
//	@Bean
//	public WebMvcConfigurer configurer()
//	{
//		return new WebMvcConfigurer() {
//			@Override
//			public void addCorsMappings(CorsRegistry reg) {
//				reg.addMapping("/*").allowedOrigins("*");
//			}
//		};
//	}
//	
	@Bean
	CommandLineRunner runner(){ 
		return args -> {
			
			Owner owner1 = new Owner("John" , "Johnson"); 
			Owner owner2 = new Owner("Mary" , "Robinson");
			orepository.save(owner1);
			orepository.save(owner2);
			
			// Place your code here
			repository.save(new Car("Ford", "Mustang", "Red", "ADF-1121", 2017, 59000, owner1));
			repository.save(new Car("Nissan", "Leaf", "White", "SSJ-3002", 2014, 29000, owner2));
			repository.save(new Car("Toyota", "Prius", "Silver", "KKO-0212", 2018, 39000, owner2));
			
		// username: user password: user
		urepository.save(new Users("user", "$2a$04$1.YhMIgNX/8TkCKGFUONWO1waedKhQ5KrnB30fl0Q01QKqmzLf.Zi",
		"USER")); 
		// username: admin password: admin
		urepository.save(new Users("admin", "$2a$04$KNLUwOWHVQZVpXyMBNc7JOzbLiBjb9Tk9bP7KNcPI12ICuvzXQQKG",
		"ADMIN"));
		}; 
	}
	
}
