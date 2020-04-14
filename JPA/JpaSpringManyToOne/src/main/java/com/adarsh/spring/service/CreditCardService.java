package com.adarsh.spring.service;

import com.adarsh.spring.domain.CreditCard;
import com.adarsh.spring.domain.Person;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Transactional
@Service("creditCardService")
public class CreditCardService {

    protected static Logger logger = Logger.getLogger("service");

    /**
     * Retrieves all credit cards
     */
    public List<CreditCard> getAll(Integer personId) {
        logger.debug("Retrieving all credit cards");

        // Create a JPA query
        Query query = entityManager.createQuery("FROM  CreditCard WHERE person.id=" + personId);

        // Retrieve all
        return query.getResultList();
    }

    /**
     * Retrieves all credit cards
     */
    public List<CreditCard> getAll() {
        logger.debug("Retrieving all credit cards");

        // Create a JPA query
        Query query = entityManager.createQuery("FROM  CreditCard");

        // Retrieve all
        return query.getResultList();
    }

    /**
     * Retrieves a single credit card
     */
    public CreditCard get(Integer id) {

        // Retrieve existing credit card
        CreditCard creditCard = (CreditCard) entityManager.createQuery("FROM CreditCard p WHERE p.id = :id")
                .setParameter("id", id).getSingleResult();

        // Persists to db
        return creditCard;
    }

    /**
     * Adds a new credit card
     */
    public void add(Integer personId, CreditCard creditCard) {
        logger.debug("Adding new credit card");

        // Retrieve existing person via id
        Person existingPerson = personService.get(personId);

        // Add person to credit card
        creditCard.setPerson(existingPerson);

        // Persists to db
        entityManager.merge(creditCard);
    }

    /**
     * Deletes an existing credit card
     */
    public void delete(Integer id) {
        logger.debug("Deleting existing credit card");

        // Retrieve existing credit card
        CreditCard creditCard = this.get(id);

        // Delete
        entityManager.remove(creditCard);
    }

    /**
     * Deletes all credit cards based on the person's id
     */
    public void deleteAll(Integer personId) {
        logger.debug("Deleting existing credit cards based on person's id");

        // Create a JPA query
        Query query = entityManager.createQuery("DELETE FROM CreditCard WHERE person.id=" + personId);

        // Delete all
        query.executeUpdate();
    }

    /**
     * Edits an existing credit card
     */
    public void edit(CreditCard creditCard) {
        logger.debug("Editing existing creditCard");

        // Retrieve existing credit card via id
        CreditCard existingCreditCard = this.get(creditCard.getId());

        // Assign updated values to this credit card
        existingCreditCard.setNumber(creditCard.getNumber());
        existingCreditCard.setType(creditCard.getType());

        // Save updates
        entityManager.merge(existingCreditCard);
    }

    @Resource(name = "personService")
    private PersonService personService;

    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }

    @PersistenceContext
    private EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

}
