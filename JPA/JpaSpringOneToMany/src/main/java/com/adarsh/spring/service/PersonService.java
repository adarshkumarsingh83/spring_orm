package com.adarsh.spring.service;

import com.adarsh.spring.domain.CreditCard;
import com.adarsh.spring.domain.Person;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Set;


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
        // Create a JPA query
        Query query = entityManager.createQuery("FROM Person");
        // Retrieve all
        return query.getResultList();
    }

    /**
     * Retrieves a single person
     */
    public Person get(Integer id) {
        // Retrieve existing person
        // Create a JPA query
        Query query = entityManager.createQuery("FROM Person as p LEFT JOIN FETCH  p.creditCards WHERE p.id=" + id);
        return (Person) query.getSingleResult();
    }

    /**
     * Adds a new person
     */
    public void add(Person person) {
        logger.debug("Adding new person");
       // Persists to db
        entityManager.persist(person);
    }

    /**
     * Deletes an existing person
     *
     * @param id the id of the existing person
     */
    public void delete(Integer id) {
        logger.debug("Deleting existing person");
        // Create a Hibernate query (HQL)
        Query query = entityManager.createQuery("FROM Person as p LEFT JOIN FETCH  p.creditCards WHERE p.id=" + id);
        // Retrieve record
        Person person = (Person) query.getSingleResult();
        Set<CreditCard> creditCards = person.getCreditCards();
        // Delete person
        entityManager.remove(person);
        // Delete associated credit cards
        for (CreditCard creditCard : creditCards) {
            entityManager.remove(creditCard);
        }
    }

    /**
     * Edits an existing person
     */
    public void edit(Person person) {
        logger.debug("Editing existing person");
        // Retrieve existing person via id
        Person existingPerson = this.get(person.getId());
        // Assign updated values to this person
        existingPerson.setFirstName(person.getFirstName());
        existingPerson.setLastName(person.getLastName());
        existingPerson.setMoney(person.getMoney());
        // Save updates
        entityManager.merge(existingPerson);
    }

    @PersistenceContext
    private EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

}
