package com.ian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 这个要放在dao,domain,service,controller包的外面

@SpringBootApplication
public class ProviderUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderUserApplication.class, args);
    }
}
