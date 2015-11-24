package com.adarsh.spring.repository.impl;

import com.adarsh.spring.entity.impl.Permission;
import com.adarsh.spring.repository.PermissionRepository;
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
@Repository(value = "permissionRepositoryImpl")
public class PermissionRepositoryImpl implements PermissionRepository {

    @Autowired(required = true)
    private SessionFactory sessionFactory;

    @Override
    public Permission savePermission(Permission permission) {
        this.getSession().save(permission);
        return permission;
    }

    @Override
    public Permission updatePermission(Permission permission) {
        this.getSession().saveOrUpdate(permission);
        return permission;
    }

    @Override
    public Permission findByPermissionId(Long permissionId) {
        final Session session = this.getSession();
        final Criteria criteria = session.createCriteria(Permission.class);
        criteria.add(Restrictions.eq("permissionId", permissionId));
        criteria.add(Restrictions.eq("active", Boolean.TRUE));
        final Permission permission = (Permission) criteria.uniqueResult();
        return permission;
    }

    @Override
    public boolean deletePermission(Permission permission) {
        try {
            this.getSession().delete(permission);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Permission findByPermissionName(String permissionName) {
        final Session session = this.getSession();
        final Criteria criteria = session.createCriteria(Permission.class);
        criteria.add(Restrictions.eq("permissionName", permissionName));
        criteria.add(Restrictions.eq("active", Boolean.TRUE));
        final Permission permission = (Permission) criteria.uniqueResult();
        return permission;
    }

    @Override
    public List<Permission> getAllPermission(boolean active) {
        final Session session = this.getSession();
        final Criteria criteria = session.createCriteria(Permission.class);
        if (active) {
            criteria.add(Restrictions.eq("active", Boolean.TRUE));
        }
        final List<Permission> permissionList = criteria.list();
        return permissionList;
    }

    private org.hibernate.Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }
}
