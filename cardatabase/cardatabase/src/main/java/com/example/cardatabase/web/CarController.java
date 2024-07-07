package com.example.cardatabase.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cardatabase.domain.CarRepository;
import com.example.cardatabase.entity.Car;

@RestController
public class CarController {
	@Autowired
	private CarRepository reposory;
	
	@RequestMapping("/cars")
	public Iterable<Car> getCars(){
		return reposory.findAll();
	}
}
