package com.adarsh.spring.service;

import com.adarsh.spring.entity.Employee;
import com.adarsh.spring.entity.Phone;

import java.util.List;

/**
 * @Author Adarsh
 * Created By: Adarsh
 * Created On Date: 2/2/2015  Time: 6:32 PM
 * This Class provide the implementation for the functionality of..
 */
public interface EmployeeService {


    public void saveEmployee(Employee employee);

    public void saveEmployeePhone(Phone phone);

    public List<Employee> getEmployee();

    public List<Phone> getEmployeePhone();
}
