package com.springframework.didemo.controllers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.springframework.didemo.services.GreetingService;

@Controller
public class MyController {
	GreetingService greetingService;
	
	public MyController(GreetingService greetingService) {
		super();
		this.greetingService = greetingService;
	}


	public String hello(){
		System.out.println(greetingService.sayGreeting());
		return "0";
	}
}
