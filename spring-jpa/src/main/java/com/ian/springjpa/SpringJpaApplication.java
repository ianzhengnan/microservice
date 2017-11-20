package com.ian.springjpa;

import com.ian.springjpa.dao.CustomRepositoryFactoryBean;
import com.ian.springjpa.dao.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(repositoryFactoryBeanClass = CustomRepositoryFactoryBean.class)
public class SpringJpaApplication {

	@Autowired
	PersonRepository personRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaApplication.class, args);
	}
}
