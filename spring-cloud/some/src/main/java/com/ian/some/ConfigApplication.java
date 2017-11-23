package com.ian.some;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class ConfigApplication {

	@Value("@{my.message}")
	private String message;

	@RequestMapping(value = "/getsome")
	public String getSome() {
		return message;
	}

	public static void main(String[] args) {
		SpringApplication.run(ConfigApplication.class, args);
	}
}
