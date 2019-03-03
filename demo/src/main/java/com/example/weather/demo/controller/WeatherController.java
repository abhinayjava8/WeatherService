package com.example.weather.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.weather.demo.service.WeatherService;

@RestController
@RequestMapping("/demo")

public class WeatherController {

	@Autowired
	WeatherService service;

	
	@GetMapping("/weather/{zipcode}")
	public String getMinTempByHour(@PathVariable String zipcode) {
		String temp = "";
		try {
			temp = service.getTodayMinTemp(zipcode);
			return temp;
		} catch (Exception ex) {
			return "Exception occured.....";
		}
	}

}
