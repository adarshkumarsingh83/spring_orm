package com.adarsh.spring.repository.impl;

import com.adarsh.spring.entity.impl.UserPermission;
import com.adarsh.spring.repository.UserPermissionRepository;
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
@Repository(value = "userPermissionRepositoryImpl")
public class UserPermissionRepositoryImpl implements UserPermissionRepository {

    @Autowired(required = true)
    private SessionFactory sessionFactory;

    @Override
    public UserPermission saveUserPermission(UserPermission userPermission) {
        this.getSession().save(userPermission);
        return userPermission;
    }

    @Override
    public UserPermission updateUserPermission(UserPermission userPermission) {
        this.getSession().saveOrUpdate(userPermission);
        return userPermission;
    }

    @Override
    public UserPermission findUserPermissionById(Long userPermissionId) {
        final Session session = this.getSession();
        final Criteria criteria = session.createCriteria(UserPermission.class);
        criteria.add(Restrictions.eq("userPermissionId", userPermissionId));
        criteria.add(Restrictions.eq("active", Boolean.TRUE));
        final UserPermission userPermission = (UserPermission) criteria.uniqueResult();
        return userPermission;
    }

    @Override
    public boolean deleteUserPermission(UserPermission userPermission) {
        try {
            this.getSession().delete(userPermission);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<UserPermission> findUserPermissionByPermissionId(final Long permissionId) {
        final Session session = this.getSession();
        final Criteria criteria = session.createCriteria(UserPermission.class);
        criteria.createAlias("permission", "p");
        criteria.add(Restrictions.eq("p.permission", permissionId));
        criteria.add(Restrictions.eq("active", Boolean.TRUE));
        final List<UserPermission> userPermission = criteria.list();
        return userPermission;
    }

    @Override
    public List<UserPermission> findUserPermissionByUserId(Long userId) {
        final Session session = this.getSession();
        final Criteria criteria = session.createCriteria(UserPermission.class);
        criteria.createAlias("users", "u");
        criteria.add(Restrictions.eq("u.userId", userId));
        criteria.add(Restrictions.eq("active", Boolean.TRUE));
        final List<UserPermission> userPermission = criteria.list();
        return userPermission;
    }

    @Override
    public UserPermission findUserPermissionByUserIdAndPermissionId(Long userId, Long permissionId) {
        final Session session = this.getSession();
        final Criteria criteria = session.createCriteria(UserPermission.class);
        criteria.createAlias("permission", "p");
        criteria.add(Restrictions.eq("p.permission", permissionId));
        criteria.createAlias("users", "u");
        criteria.add(Restrictions.eq("u.userId", userId));
        criteria.add(Restrictions.eq("active", Boolean.TRUE));
        final UserPermission userPermission = (UserPermission)criteria.uniqueResult();
        return userPermission;
    }

    @Override
    public UserPermission findUserPermissionByUserNameAndPermissionName(String userName, String permissionName) {
        final Session session = this.getSession();
        final Criteria criteria = session.createCriteria(UserPermission.class);
        criteria.createAlias("permission", "p");
        criteria.add(Restrictions.eq("p.permissionName", permissionName));
        criteria.createAlias("users", "u");
        criteria.add(Restrictions.eq("u.userName", userName));
        criteria.add(Restrictions.eq("active", Boolean.TRUE));
        final UserPermission userPermission = (UserPermission)criteria.uniqueResult();
        return userPermission;
    }

    private org.hibernate.Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }
}
