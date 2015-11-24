package com.adarsh.spring.service;

import com.adarsh.spring.domain.Person;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


@Transactional
@Service("personService")
public class PersonService {

    protected static Logger logger = Logger.getLogger("service");

    /**
     * Retrieves all persons
     *
     * @return a list of persons
     */
    public List<Person> getAll() {
        logger.debug("Retrieving all persons");
        // Retrieve session from Hibernate
        Session session = sessionFactory.getCurrentSession();
        // Create a Hibernate query (HQL)
        Query query = session.createQuery("FROM  Person");
        // Retrieve all
        return query.list();
    }

    /**
     * Retrieves a single person
     */
    public Person get(Integer id) {
        // Retrieve session from Hibernate
        Session session = sessionFactory.getCurrentSession();
        // Retrieve existing person first
        Person person = (Person) session.get(Person.class, id);
        return person;
    }

    /**
     * Adds a new person
     */
    public void add(Person person) {
        logger.debug("Adding new person");
        // Retrieve session from Hibernate
        Session session = sessionFactory.getCurrentSession();
        // Save
        session.save(person);
    }

    /**
     * Deletes an existing person
     *
     * @param id the id of the existing person
     */
    public void delete(Integer id) {
        logger.debug("Deleting existing person");
        // Retrieve session from Hibernate
        Session session = sessionFactory.getCurrentSession();
        // Retrieve existing person first
        Person person = (Person) session.get(Person.class, id);
        // Delete
        session.delete(person);
    }

    /**
     * Edits an existing person
     */
    public void edit(Person person) {
        logger.debug("Editing existing person");
        // Retrieve session from Hibernate
        Session session = sessionFactory.getCurrentSession();
        // Retrieve existing person via id
        Person existingPerson = (Person) session.get(Person.class, person.getId());
        // Assign updated values to this person
        existingPerson.setFirstName(person.getFirstName());
        existingPerson.setLastName(person.getLastName());
        existingPerson.setMoney(person.getMoney());
        // Save updates
        session.save(existingPerson);
    }

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
