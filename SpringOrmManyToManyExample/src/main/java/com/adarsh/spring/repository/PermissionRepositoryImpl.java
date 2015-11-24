package com.adarsh.spring.repository;

import com.adarsh.spring.entity.Permission;
import com.adarsh.spring.entity.User;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author Adarsh
 * @Product Lucas.
 * Created By: Adarsh
 * Created On Date: 2/2/2015  Time: 7:25 PM
 * This Class provide the implementation for the functionality of..
 */

@Repository
public class PermissionRepositoryImpl<P> implements  PermissionRepository<P> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void savePermission(P permission) {
        this.sessionFactory.getCurrentSession().saveOrUpdate(permission);
    }

    @Override
    public void savePermissions(List<P> list) {
          for(P p:list){
              this.sessionFactory.getCurrentSession().saveOrUpdate(p);
          }
    }

    @Override
    public P getPermission(P permission) {
        final Permission permissionObject= ((Permission)permission);
        Object object=null;
        if(permissionObject != null && permissionObject.getPermissionId() != null){
            object=this.sessionFactory.getCurrentSession().get(User.class, permissionObject.getPermissionId());
        }else{
            final Criteria criteria=sessionFactory.getCurrentSession().createCriteria(Permission.class);
            criteria.add(Restrictions.eq("permissionName", permissionObject.getPermissionName()));
            object = criteria.uniqueResult();
        }
        if(object !=null) {
            return (P)object;
        }else {
            return null;
        }
    }

    @Override
    public List<P> getPermissions() {
        final List<Object> permissionList=this.sessionFactory.getCurrentSession().createCriteria(Permission.class).list();
        if(permissionList != null ) {
            return (List<P>)permissionList;
        }else{
            return null;
        }
    }

    @Override
    public void updatePermission(P permission) {

    }

    @Override
    public void deletePermission(P permission) {
        this.sessionFactory.getCurrentSession().createQuery("DELETE FROM Permission WHERE permissionId = "+((Permission)permission).getPermissionId()).executeUpdate();
    }
}
