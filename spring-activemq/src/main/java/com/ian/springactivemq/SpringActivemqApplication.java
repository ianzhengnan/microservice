package com.ian.springactivemq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.core.JmsTemplate;

@SpringBootApplication
public class SpringActivemqApplication implements CommandLineRunner{

	@Autowired
	JmsTemplate jmsTemplate;

	@Override
	public void run(String... strings) throws Exception {
		jmsTemplate.send("my-destination", new Msg());
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringActivemqApplication.class, args);
	}
}
