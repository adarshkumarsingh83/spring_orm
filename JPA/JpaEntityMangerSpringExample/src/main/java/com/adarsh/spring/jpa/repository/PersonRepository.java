package com.adarsh.spring.jpa.repository;

import com.adarsh.spring.jpa.entity.Person;

import java.util.List;

/**
 * Created by Adarsh on 3/21/15.
 */
public interface PersonRepository {
    void insert(Person person);

    List<Person> selectAll();
}
