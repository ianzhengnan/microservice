package com.ian.ui.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SomeHystrixService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallbackSome")
    public String getSome(){
        return restTemplate.getForObject("http://some/getsome", String.class);
    }

    public String fallbackSome(){
        return "some service模块故障";
    }
}
