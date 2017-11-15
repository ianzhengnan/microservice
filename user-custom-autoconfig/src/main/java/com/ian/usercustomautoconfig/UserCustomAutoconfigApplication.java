package com.ian.usercustomautoconfig;

import com.ian.springbootstarterhello.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class UserCustomAutoconfigApplication {

	@Autowired
	HelloService helloService;

	@GetMapping("/")
	public String index(){
		return helloService.sayHello();
	}

	public static void main(String[] args) {
		SpringApplication.run(UserCustomAutoconfigApplication.class, args);
	}
}
