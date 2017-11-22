package com.ian.springjpadatatransaction.service;

import com.ian.springjpadatatransaction.domain.Person;

import java.util.List;

public interface PersonService {

    Person savePersonWithRollback(Person person);

    Person savePersonWithoutRollback(Person person);

    List<Person> findAllPerson();
}
