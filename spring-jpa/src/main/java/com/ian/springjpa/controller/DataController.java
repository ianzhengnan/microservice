package com.ian.springjpa.controller;

import com.ian.springjpa.dao.PersonRepository;
import com.ian.springjpa.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DataController {

    @Autowired
    private PersonRepository pr;

    /**
     * 保存
     * save 支持批量保存: <S extends T> Iterable<S> save(Iterable<S> entities);
     *
     * 删除
     * 支持用id删除对象，批量删除以及删除全部
     * void delete(ID id)
     * void delete(T entity)
     * void delete(Iterable<? extends T> entites);
     * void deleteAll();
     * @param name
     * @param address
     * @param age
     * @return
     */
    @RequestMapping("/save")
    public Person save(String name, String address, Integer age){
        Person person = pr.save(new Person(null, name, age, address));
        return person;
    }

    @RequestMapping("/q1")
    public List<Person> q1(String address){
        List<Person> people = pr.findByAddress(address);
        return people;
    }

    @RequestMapping("/q2")
    public Person q2(String name, String address){
        Person person = pr.findByNameAndAddress(name, address);
        return person;
    }

    @RequestMapping("/q3")
    public Person q3(String name, String address){
        return pr.withNameAndAddressQuery(name, address);
    }

    @RequestMapping("/q4")
    public Person q4(String name, String address){
        return pr.withNameAndAddressNamedQuery(name, address);
    }

    @RequestMapping("/sort")
    public List<Person> sort(){
        return pr.findAll(new Sort(Sort.Direction.ASC, "age"));
    }

    @RequestMapping("/page")
    public Page<Person> page(){
        return pr.findAll(new PageRequest(1, 2));
    }

    @RequestMapping("/auto")
    public Page<Person> auto(Person person){
        return pr.findByAuto(person, new PageRequest(0,10));
    }
}
