package com.adarsh.spring.jpa.service;

import com.adarsh.spring.jpa.entity.Person;

import java.util.List;

/**
 * Created by Adarsh on 3/21/15.
 */
public interface PersonService {

    public void addPerson(Person person);

    public List<Person> fetchAllPersons();
}
