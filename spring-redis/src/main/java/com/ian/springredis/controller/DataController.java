package com.ian.springredis.controller;

import com.ian.springredis.dao.PersonDao;
import com.ian.springredis.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataController {

    @Autowired
    private PersonDao personDao;

    @RequestMapping("/set")
    public void set(){
        Person person = new Person("1", "郑楠", 35);
        personDao.save(person);
        personDao.stringRedisTemplateDemo();
    }

    @RequestMapping("/getStr")
    public String getStr(){
        return personDao.getString();
    }

    @RequestMapping("/getPerson")
    public Person getPerson(){
        return personDao.getPerson();
    }
}
