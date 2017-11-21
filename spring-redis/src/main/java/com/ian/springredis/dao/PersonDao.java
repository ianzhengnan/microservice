package com.ian.springredis.dao;

import com.ian.springredis.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class PersonDao {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Resource(name = "stringRedisTemplate")
    private ValueOperations<String, String> valOpsStr;

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Resource(name = "redisTemplate")
    private ValueOperations<Object, Object> valOps;

    public void stringRedisTemplateDemo(){
        valOpsStr.set("name", "郑楠");
    }

    public void save(Person person){
        valOps.set(person.getId(), person);
    }

    public String getString(){
        return valOpsStr.get("name");
    }

    public Person getPerson(){
        return (Person) valOps.get("1");
    }

}
