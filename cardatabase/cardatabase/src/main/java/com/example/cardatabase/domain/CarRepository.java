package com.example.cardatabase.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.cardatabase.entity.Car;

public interface CarRepository extends CrudRepository<Car, Long>{

	
	// Fetch cars by color
	List<Car> findByColor(String color);
	// Fetch cars by year 
	//List<Car> findByYear(int car_year);
	// Fetch cars by brand and model
	List<Car> findByBrandAndModel(String brand, String model);
	// Fetch cars by brand or color 
	List<Car> findByBrandOrColor(String brand, String color);
	
	// Fetch cars by brand using SQL
	@Query("select c from Car c where c.brand = ?1") 
	List<Car> findByBrand(String brand);
}
