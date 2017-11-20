package com.ian.springjpa.dao;

import com.ian.springjpa.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findByAddress(String name);

    Person findByNameAndAddress(String name, String address);

    @Query("select p from Person p where p.name = :name and p.address = :address")
    Person withNameAndAddressQuery(@Param("name") String name, @Param("address")String address);

    /**
     * 使用@NamedQuery查询， 使用domain中的@NamedQuery
     * @param name
     * @param address
     * @return
     */
    Person withNameAndAddressNamedQuery(String name, String address);
}
