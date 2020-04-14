package com.adarsh.spring.repository;

import com.adarsh.spring.entity.Employee;
import com.adarsh.spring.entity.Phone;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * @Author Adarsh
 * Created By: Adarsh
 * Created On Date: 2/2/2015  Time: 6:32 PM
 * This Class provide the implementation for the functionality of..
 */
@Repository
public class EmployeeRepositoryImpl<E,ED> implements EmployeeRepository<E,ED> {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public void saveEmployee(Employee employee) {
        this.sessionFactory.openSession().saveOrUpdate(employee);
    }

    @Override
    public void saveEmployeePhone(Phone phone) {
        this.sessionFactory.openSession().saveOrUpdate(phone);
    }

    @Override
    public List<Employee> getEmployee() {
        return this.sessionFactory.openSession().createCriteria(Employee.class).list();
    }

    @Override
    public List<Phone> getEmployeePhone(){
        return this.sessionFactory.openSession().createCriteria(Phone.class).list();
    }
}
