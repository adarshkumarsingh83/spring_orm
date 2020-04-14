package com.adarsh.spring.repository;

import com.adarsh.spring.entity.User;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Adarsh
 * @Product Lucas.
 * Created By: Adarsh
 * Created On Date: 2/2/2015  Time: 6:02 PM
 * This Class provide the implementation for the functionality of..
 */

@Repository
public class UserRepositoryImpl<U> implements UserRepository<U>{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveUser(U user) {
        this.sessionFactory.getCurrentSession().saveOrUpdate(user);
    }

    @Override
    public void saveUser(List<U> list) {
        for(U u:list){
            this.sessionFactory.getCurrentSession().saveOrUpdate(u);
        }
    }

    @Override
    public U getUser(U user) {
        final User userObject= ((User)user);
        Object object=null;
        if(userObject != null && userObject.getUserId() != null){
            object=this.sessionFactory.getCurrentSession().get(User.class, userObject.getUserId());
        }else{
            final Criteria criteria=sessionFactory.getCurrentSession().createCriteria(User.class);
            criteria.add(Restrictions.eq("userName", userObject.getUserName()));
            object = criteria.uniqueResult();
        }
        if(object !=null) {
            return (U)object;
        }else {
            return null;
        }

    }

    @Override
    public List<U> getUsers() {
        final List<Object> userList=this.sessionFactory.getCurrentSession().createCriteria(User.class).list();
        if(userList != null ) {
            return (List<U>)userList;
        }else{
            return null;
        }
    }

    @Override
    public void updateUser(U user) {

    }

    @Override
    public void deleteUser(U user) {
        this.sessionFactory.getCurrentSession().createQuery("DELETE FROM User WHERE userId = "+((User)user).getUserId()).executeUpdate();
    }


}
