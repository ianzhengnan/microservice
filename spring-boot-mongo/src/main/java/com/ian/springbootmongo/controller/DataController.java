package com.ian.springbootmongo.controller;

import com.ian.springbootmongo.dao.PersonRepository;
import com.ian.springbootmongo.domain.Location;
import com.ian.springbootmongo.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

@RestController
public class DataController {

    @Autowired
    private PersonRepository pr;

    @RequestMapping("/save")
    public Person save(){
        Person p = new Person("郑楠", 35);
        Collection<Location> locations = new LinkedHashSet<>();
        Location loc1 = new Location("上海", "2007");
        Location loc2 = new Location("北京", "2008");
        Location loc3 = new Location("武汉", "2009");
        Location loc4 = new Location("上海", "2010");
        locations.add(loc1);
        locations.add(loc2);
        locations.add(loc3);
        locations.add(loc4);
        p.setLocations(locations);
        return pr.save(p);
    }

    @RequestMapping("/q1")
    public Person q1(String name){
        return pr.findByName(name);
    }

    @RequestMapping("/q2")
    public List<Person> q2(Integer age){
        return pr.withQueryFindByAge(age);
    }
}
