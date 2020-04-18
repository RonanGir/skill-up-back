package com.training.skillup.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	@GetMapping("/api/hello")
	public String sayHello() {
		String greeting = "Coucou toi";
		return greeting;
	}

}
