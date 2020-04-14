package com.adarsh.spring.repository.impl;

import com.adarsh.spring.entity.impl.GroupPermission;
import com.adarsh.spring.repository.GroupPermissionRepository;
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
@Repository(value = "groupPermissionRepositoryImpl")
public class GroupPermissionRepositoryImpl implements GroupPermissionRepository {

    @Autowired(required = true)
    private SessionFactory sessionFactory;

    @Override
    public GroupPermission saveGroupPermission(GroupPermission groupPermission) {
        this.getSession().save(groupPermission);
        return groupPermission;
    }

    @Override
    public GroupPermission updateGroupPermission(GroupPermission groupPermission) {
        this.getSession().saveOrUpdate(groupPermission);
        return groupPermission;
    }

    @Override
    public GroupPermission findGroupPermissionById(Long groupPermissionId) {
        final Session session = this.getSession();
        final Criteria criteria = session.createCriteria(GroupPermission.class);
        criteria.add(Restrictions.eq("groupPermissionId", groupPermissionId));
        criteria.add(Restrictions.eq("active", Boolean.TRUE));
        final GroupPermission groupPermission = (GroupPermission) criteria.uniqueResult();
        return groupPermission;
    }

    @Override
    public boolean deleteGroupPermission(GroupPermission groupPermission) {
        try {
            this.getSession().delete(groupPermission);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<GroupPermission> findGroupPermissionByGroupId(Long groupId) {
        final Session session = this.getSession();
        final Criteria criteria = session.createCriteria(GroupPermission.class);
        criteria.createAlias("group", "g");
        criteria.add(Restrictions.eq("g.groupId", groupId));
        criteria.add(Restrictions.eq("active", Boolean.TRUE));
        final List<GroupPermission> groupPermissions = criteria.list();
        return groupPermissions;
    }

    @Override
    public List<GroupPermission> findGroupPermissionByPermissionId(Long permissionId) {
        final Session session = this.getSession();
        final Criteria criteria = session.createCriteria(GroupPermission.class);
        criteria.createAlias("permission", "p");
        criteria.add(Restrictions.eq("p.permission", permissionId));
        criteria.add(Restrictions.eq("active", Boolean.TRUE));
        final List<GroupPermission> groupPermissions = criteria.list();
        return groupPermissions;
    }

    @Override
    public GroupPermission findGroupPermissionByPermissionIdAndGroupId(Long permissionId, Long groupId) {
        final Session session = this.getSession();
        final Criteria criteria = session.createCriteria(GroupPermission.class);
        criteria.createAlias("permission", "p");
        criteria.add(Restrictions.eq("p.permission", permissionId));
        criteria.createAlias("group", "g");
        criteria.add(Restrictions.eq("g.groupId", groupId));
        criteria.add(Restrictions.eq("active", Boolean.TRUE));
        final GroupPermission groupPermission = (GroupPermission)criteria.uniqueResult();
        return groupPermission;
    }

    @Override
    public GroupPermission findGroupPermissionByPermissionNameAndGroupName(String permissionName, String groupName) {
        final Session session = this.getSession();
        final Criteria criteria = session.createCriteria(GroupPermission.class);
        criteria.createAlias("permission", "p");
        criteria.add(Restrictions.eq("p.permissionName", permissionName));
        criteria.createAlias("group", "g");
        criteria.add(Restrictions.eq("g.groupName", groupName));
        criteria.add(Restrictions.eq("active", Boolean.TRUE));
        final GroupPermission groupPermission = (GroupPermission)criteria.uniqueResult();
        return groupPermission;
    }

    private org.hibernate.Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }
}
