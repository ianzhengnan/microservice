package com.ian.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SidecarClientController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/test")
    public String test(){
        return this.restTemplate.getForObject("http://microservice-sidecar-node-service", String.class);
    }
}
