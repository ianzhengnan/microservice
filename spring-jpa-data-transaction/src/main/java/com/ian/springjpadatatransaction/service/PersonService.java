package com.ian.springjpadatatransaction.service;

import com.ian.springjpadatatransaction.domain.Person;

public interface PersonService {

    Person savePersonWithRollback(Person person);

    Person savePersonWithoutRollback(Person person);


}
