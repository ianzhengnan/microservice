package com.ian.springjpadatatransaction.service;

import com.ian.springjpadatatransaction.dao.PersonRepository;
import com.ian.springjpadatatransaction.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository pr;

    @Override
    @Transactional(rollbackFor = {IllegalArgumentException.class})
    public Person savePersonWithRollback(Person person) {
        Person p = pr.save(person);
        if (p.getName().equals("郑楠")){
            throw new IllegalArgumentException("郑楠已经存在，数据将回滚");
        }
        return p;
    }

    @Override
    @Transactional(noRollbackFor = {IllegalArgumentException.class})
    public Person savePersonWithoutRollback(Person person) {
        Person p = pr.save(person);
        if (p.getName().equals("郑楠")){
            throw new IllegalArgumentException("郑楠虽然已经存在，但是不会回滚");
        }
        return p;
    }

    @Override
    public List<Person> findAllPerson() {
        return pr.findAll();
    }
}
