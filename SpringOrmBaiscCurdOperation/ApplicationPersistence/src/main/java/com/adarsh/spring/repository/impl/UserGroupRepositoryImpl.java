package com.adarsh.spring.repository.impl;

import com.adarsh.spring.entity.impl.UserGroup;
import com.adarsh.spring.repository.UserGroupRepository;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Adarsh on 7/10/15.
 */
@Repository(value = "userGroupRepositoryImpl")
public class UserGroupRepositoryImpl implements UserGroupRepository {

    @Autowired(required = true)
    private SessionFactory sessionFactory;

    @Override
    public UserGroup saveUserGroup(UserGroup userGroup) {
        this.getSession().save(userGroup);
        return userGroup;
    }

    @Override
    public UserGroup updateUserGroup(UserGroup userGroup) {
        this.getSession().saveOrUpdate(userGroup);
        return userGroup;
    }

    @Override
    public UserGroup findUserGroupById(Long userGroupId) {
        final Session session = this.getSession();
        final Criteria criteria = session.createCriteria(UserGroup.class);
        criteria.add(Restrictions.eq("userGroupId", userGroupId));
        criteria.add(Restrictions.eq("active", Boolean.TRUE));
        final UserGroup userGroup = (UserGroup) criteria.uniqueResult();
        return userGroup;
    }

    @Override
    public boolean deleteUserGroup(UserGroup userGroup) {
        try {
            this.getSession().delete(userGroup);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<UserGroup> findUserGroupByUserId(Long userId) {
        final Session session = this.getSession();
        final Criteria criteria = session.createCriteria(UserGroup.class,"entity");
        criteria.add(Restrictions.eq("entity.active", true));
        criteria.createAlias("entity.users", "ua");
        criteria.add(Restrictions.eq("ua.userId", userId));
        final List<UserGroup> userGroups = criteria.list();
        return userGroups;
    }

    @Override
    public List<UserGroup> findUserGroupByGroupId(Long groupId) {
        final Session session = this.getSession();
        final Criteria criteria = session.createCriteria(UserGroup.class);
        criteria.add(Restrictions.eq("active", Boolean.TRUE));
        criteria.createAlias("group", "g");
        criteria.add(Restrictions.eq("g.groupId", groupId));
        final List<UserGroup> userGroups = criteria.list();
        return userGroups;
    }

    @Override
    public UserGroup findUserGroupByGroupIdAndUserId(Long groupId, Long userId) {
        final Session session = this.getSession();
        final Criteria criteria = session.createCriteria(UserGroup.class);
        criteria.add(Restrictions.eq("active", Boolean.TRUE));
        criteria.createAlias("users", "u");
        criteria.add(Restrictions.eq("u.userId", userId));
        criteria.createAlias("group", "g");
        criteria.add(Restrictions.eq("g.groupId", groupId));
        final UserGroup userGroup = (UserGroup)criteria.uniqueResult();
        return userGroup;
    }

    @Override
    public UserGroup findUserGroupByGroupNameAndUserName(String groupName, String userName) {
        final Session session = this.getSession();
        final Criteria criteria = session.createCriteria(UserGroup.class);
        criteria.add(Restrictions.eq("active", Boolean.TRUE));
        criteria.createAlias("users", "u");
        criteria.add(Restrictions.eq("u.userName", userName));
        criteria.createAlias("group", "g");
        criteria.add(Restrictions.eq("g.groupName", groupName));
        final UserGroup userGroup = (UserGroup)criteria.uniqueResult();
        return userGroup;
    }

    private Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }
}
