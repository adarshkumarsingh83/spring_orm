package com.adarsh.spring.jpa.service;

/**
 * Created by Adarsh on 3/21/15.
 */
import java.util.List;

import com.adarsh.spring.jpa.repository.PersonRepository;
import com.adarsh.spring.jpa.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService{

    @Autowired
    private PersonRepository personRepository;

    @Override
    public void addPerson(Person person) {
        personRepository.insert(person);
    }

    @Override
    public List<Person> fetchAllPersons() {
        return personRepository.selectAll();
    }
}
