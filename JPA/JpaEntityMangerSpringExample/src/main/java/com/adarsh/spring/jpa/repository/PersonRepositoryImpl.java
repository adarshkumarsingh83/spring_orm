package com.adarsh.spring.jpa.repository;

/**
 * Created by Adarsh on 3/21/15.
 */
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.adarsh.spring.jpa.entity.Person;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository("personRepository")
@Transactional(propagation = Propagation.REQUIRED)
public class PersonRepositoryImpl implements PersonRepository{

    private static final String SELECT_QUERY = "select p from Person p";

    @PersistenceContext
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void insert(Person person) {
        entityManager.persist(person);
    }

    @Override
    public List<Person> selectAll() {
        final Query query = entityManager.createQuery(SELECT_QUERY);
        final List<Person> persons = (List<Person>) query.getResultList();
        return persons;
    }

}
