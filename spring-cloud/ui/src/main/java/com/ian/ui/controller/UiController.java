package com.ian.ui.controller;

import com.ian.ui.domain.Person;
import com.ian.ui.service.PersonHystrixService;
import com.ian.ui.service.SomeHystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UiController {

    @Autowired
    private SomeHystrixService shs;

    @Autowired
    private PersonHystrixService phs;

    @RequestMapping("/dispatch")
    public List<Person> sendMessage(@RequestBody String personName) {
        return phs.save(personName);
    }

    @RequestMapping(value = "/getsome", produces = {MediaType.TEXT_PLAIN_VALUE})
    public String getSome(){
        return shs.getSome();
    }

}
