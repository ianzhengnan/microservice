package com.ian.springjpadatatransaction.service;

import com.ian.springjpadatatransaction.domain.Person;

public interface PersonService {

    Person save(Person person);

    void remove(Long id);

    Person findOne(Person person);

}
