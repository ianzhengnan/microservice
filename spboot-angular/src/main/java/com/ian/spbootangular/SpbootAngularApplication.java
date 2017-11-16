package com.ian.spbootangular;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SpbootAngularApplication {

	@RequestMapping(value = "/search", produces = {MediaType.APPLICATION_JSON_VALUE})
	public Person search(String personName){
		return new Person(personName, 35, "Shanghai");
	}

	public static void main(String[] args) {
		SpringApplication.run(SpbootAngularApplication.class, args);
	}
}
