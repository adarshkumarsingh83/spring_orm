package com.adarsh.spring.repository;

import com.adarsh.spring.entity.Groups;
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
 * Created On Date: 2/2/2015  Time: 6:16 PM
 * This Class provide the implementation for the functionality of..
 */

@Repository
public class GroupRepositoryImpl<G> implements GroupRepository<G> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveGroup(G group) {
        this.sessionFactory.getCurrentSession().saveOrUpdate(group);
    }

    @Override
    public void saveGroups(List<G> list) {
        for(G g:list) {
            this.sessionFactory.getCurrentSession().saveOrUpdate(g);
        }
    }

    @Override
    public G getGroup(G group) {
        final Groups groupsObject =(Groups)group;
        Object object=null;
        if(groupsObject != null && groupsObject.getGroupId() != null) {
            object = this.sessionFactory.getCurrentSession().get(Groups.class, groupsObject.getGroupId());
        }else {
            final Criteria criteria=sessionFactory.getCurrentSession().createCriteria(Groups.class);
            criteria.add(Restrictions.eq("groupName", groupsObject.getGroupName()));
            object = criteria.uniqueResult();
        }
        if(object !=null) {
            return (G)object;
        }else {
            return null;
        }
    }

    @Override
    public List<G> getGroup() {
        final List<Object> groupList=this.sessionFactory.getCurrentSession().createCriteria(Groups.class).list();
        if(groupList != null ) {
            return (List<G>)groupList;
        }else{
            return null;
        }
    }

    @Override
    public void deleteGroup(G group) {
        this.sessionFactory.getCurrentSession()
                .createQuery("DELETE FROM Groups WHERE groupId = " + ((Groups) group).getGroupId()).executeUpdate();
    }
}
