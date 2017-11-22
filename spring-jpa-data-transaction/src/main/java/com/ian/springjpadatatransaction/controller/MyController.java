package com.ian.springjpadatatransaction.controller;

import com.ian.springjpadatatransaction.domain.Person;
import com.ian.springjpadatatransaction.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyController {

    @Autowired
    private PersonService personService;

    @RequestMapping("/rollback")
    public Person rollback(Person person){
        return personService.savePersonWithRollback(person);
    }

    @RequestMapping("/norollback")
    public Person norollback(Person person){
        return personService.savePersonWithoutRollback(person);
    }

    @RequestMapping(value = "/persons", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Person> findAll(){
        return personService.findAllPerson();
    }
}
