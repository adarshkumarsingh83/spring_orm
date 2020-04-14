package com.adarsh.spring.jpa.test;

import com.adarsh.spring.jpa.entity.Person;
import com.adarsh.spring.jpa.service.PersonServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Adarsh on 3/21/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/configuration/applicationContext.xml"})
public class JpaServiceTest {

    @Autowired
    private PersonServiceImpl personService;

    @Rollback(false)
    @Transactional(readOnly = false)
    @Test
    public void savePerson() {
        final Person person = new Person();
        person.setName("Adarsh kumar");
        person.setEmail("adarshkumar@gmail.com");
        personService.addPerson(person);
        System.out.println("Person : " + person + " added successfully");
    }

    @Rollback(false)
    @Transactional(readOnly = true)
    @Test
    public void getAllUser() {
        final List<Person> persons = personService.fetchAllPersons();
        for(Person person:persons){
            System.out.println(person);
        }
    }
}
