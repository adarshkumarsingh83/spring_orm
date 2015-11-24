package com.adarsh.spring.repository.impl;

import com.adarsh.spring.entity.impl.Group;
import com.adarsh.spring.repository.GroupRepository;
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
@Repository(value = "groupRepositoryImpl")
public class GroupRepositoryImpl implements GroupRepository {

    @Autowired(required = true)
    private SessionFactory sessionFactory;

    @Override
    public Group saveGroup(Group group) {
        this.getSession().save(group);
        return group;
    }

    @Override
    public Group updateGroup(Group group) {
        this.getSession().saveOrUpdate(group);
        return group;
    }

    @Override
    public Group findGroupById(Long groupId) {
        final Session session = this.getSession();
        final Criteria criteria = session.createCriteria(Group.class);
        criteria.add(Restrictions.eq("groupId", groupId));
        criteria.add(Restrictions.eq("active", Boolean.TRUE));
        final Group group = (Group) criteria.uniqueResult();
        return group;
    }

    @Override
    public boolean deleteGroup(Group group) {
        try {
            this.getSession().delete(group);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Group findGroupByName(String groupName) {
        final Session session = this.getSession();
        final Criteria criteria = session.createCriteria(Group.class);
        criteria.add(Restrictions.eq("groupName", groupName));
        criteria.add(Restrictions.eq("active", Boolean.TRUE));
        final Group group = (Group) criteria.uniqueResult();
        return group;
    }

    @Override
    public List<Group> getAllGroup(boolean active) {
        final Session session = this.getSession();
        final Criteria criteria = session.createCriteria(Group.class);
        if (active) {
            criteria.add(Restrictions.eq("active", active));
        }
        final List<Group> groupList = criteria.list();
        return groupList;
    }

    private org.hibernate.Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }
}
