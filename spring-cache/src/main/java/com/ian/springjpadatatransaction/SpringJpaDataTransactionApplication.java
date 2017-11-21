package com.ian.springjpadatatransaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching // 开启缓存支持
public class SpringJpaDataTransactionApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaDataTransactionApplication.class, args);
	}
}
