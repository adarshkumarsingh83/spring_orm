package com.adarsh.spring.repository;

import com.adarsh.spring.entity.Employee;
import com.adarsh.spring.entity.Meetings;

import java.util.List;

/**
 * @Author Adarsh
 * Created By: Adarsh
 * Created On Date: 2/2/2015  Time: 6:32 PM
 * This Class provide the implementation for the functionality of..
 */
public interface EmployeeRepository<E,ED> {

    public void saveEmployee(Employee employee);

    public void saveEmployeePhone(Meetings meetings);

    public List<Employee> getEmployee();

    public List<Meetings> getEmployeePhone();

}
