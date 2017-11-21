package com.ian.springjpadatatransaction.dao;

import com.ian.springjpadatatransaction.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {


}
