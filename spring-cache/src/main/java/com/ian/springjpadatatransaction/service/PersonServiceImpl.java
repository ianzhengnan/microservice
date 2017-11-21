package com.ian.springjpadatatransaction.service;

import com.ian.springjpadatatransaction.dao.PersonRepository;
import com.ian.springjpadatatransaction.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository pr;

    @Override
    @CachePut(value = "people", key = "#person.id")
    public Person save(Person person) {
        Person p = pr.save(person);
        System.out.println("为id、key为：" + p.getId() + "的数据做了缓存");
        return p;
    }

    @Override
    @CacheEvict(value = "people") // 没有制定key, 则方法的参数做为key
    public void remove(Long id) {
        System.out.println("删除了id、key为：" + id + "的数据缓存");
//        pr.delete(id);
    }

    @Override
    @Cacheable(value = "people", key = "#person.id")
    public Person findOne(Person person) {
        Person p = pr.findOne(person.getId());
        System.out.println("为id、key为：" + p.getId() + "的数据做了缓存");
        return p;
    }
}
