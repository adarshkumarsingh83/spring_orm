package com.adarsh.spring.repository.impl;

import com.adarsh.spring.entity.impl.Employee;
import com.adarsh.spring.repository.EmployeeRepository;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    @Autowired(required = true)
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

   /* @Transactional(readOnly = false)*/
    public void saveEmployee(Employee employee) {
        sessionFactory.getCurrentSession().save(employee);
    }

    /*@Transactional(readOnly = false)*/
    public void deleteEmployee(Employee employee) {
        sessionFactory.getCurrentSession().delete(employee);
    }

    /*@Transactional(readOnly = false)*/
    public void updateEmployee(Employee employee) {
        sessionFactory.getCurrentSession().update(employee);
    }

    /*@Transactional(readOnly = true)*/
    public Employee getEmployee(Employee employee) {
        return (Employee) sessionFactory.getCurrentSession().get(Employee.class, employee.getId());
    }

    /*@Transactional(readOnly = true)*/
    public List<Employee> getAllEmployee() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Employee.class);
        return criteria.list();
    }

    /*@Transactional(readOnly = true)*/
    public Long getTableSize() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Employee.class);
        criteria.setProjection(Projections.rowCount());
        List list = criteria.list();
        return (list.get(0) != null) ? (Long) list.get(0) : 0;
    }
}
