package com.adarsh.spring.repository.impl;

import com.adarsh.spring.entity.impl.Users;
import com.adarsh.spring.repository.UserRepository;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Adarsh on 7/10/15.
 */
@Repository(value = "userRepositoryImpl")
public class UserRepositoryImpl implements UserRepository {

    @Autowired(required = true)
    private SessionFactory sessionFactory;

    @Override
    public Users saveUser(Users users) {
        this.getSession().save(users);
        return users;
    }

    @Override
    public Users updateUser(Users users) {
        this.getSession().saveOrUpdate(users);
        return users;
    }

    @Override
    public Users findUserById(Long userId) {
        final Session session = this.getSession();
        final Criteria criteria = session.createCriteria(Users.class);
        criteria.add(Restrictions.eq("userId", userId));
        criteria.add(Restrictions.eq("active", Boolean.TRUE));
        final Users users = (Users) criteria.uniqueResult();
        return users;
    }

    @Override
    public boolean deleteUser(Users users) {
        try {
            this.getSession().delete(users);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Users findUserByName(String userName) {
        final Session session = this.getSession();
        final Criteria criteria = session.createCriteria(Users.class);
        criteria.add(Restrictions.eq("userName", userName));
        criteria.add(Restrictions.eq("active", Boolean.TRUE));
        final Users users = (Users) criteria.uniqueResult();
        return users;
    }

    @Override
    public List<Users> getAllUser(boolean active) {
        final Session session = this.getSession();
        final Criteria criteria = session.createCriteria(Users.class);
        if (active) {
            criteria.add(Restrictions.eq("active", active));
        }
        final List<Users> usersList = criteria.list();
        return usersList;
    }

    private org.hibernate.Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }
}
