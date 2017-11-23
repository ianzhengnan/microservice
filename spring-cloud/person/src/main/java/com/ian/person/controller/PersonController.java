package com.ian.person.controller;

import com.ian.person.dao.PersonRepository;
import com.ian.person.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonRepository pr;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public List<Person> savePerson(@RequestBody String personName){
        Person p = new Person(personName);
        pr.save(p);
        List<Person> people = pr.findAll(new PageRequest(0,10)).getContent();
        return people;
    }
}
