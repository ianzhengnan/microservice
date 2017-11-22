package com.ian.springrabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringRabbitmqApplication implements CommandLineRunner{

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Bean
	public Queue testQueue(){
		return new Queue("my-queue");
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringRabbitmqApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		rabbitTemplate.convertAndSend("my-queue", "来自RabbitMQ的问候");
	}
}
