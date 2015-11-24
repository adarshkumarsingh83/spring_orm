package com.adarsh.spring.service;

import com.adarsh.spring.entity.Employee;
import com.adarsh.spring.entity.Phone;
import com.adarsh.spring.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/**
 * @Author Adarsh
 * Created By: Adarsh
 * Created On Date: 2/2/2015  Time: 6:32 PM
 * This Class provide the implementation for the functionality of..
 */
@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    @Transactional
    public void saveEmployee(Employee employee) {
        this.employeeRepository.saveEmployee(employee);
    }

    @Override
    @Transactional
    public void saveEmployeePhone(Phone phone) {
        this.employeeRepository.saveEmployeePhone(phone);
    }

    @Override
    @Transactional
    public List<Employee> getEmployee() {
        return this.employeeRepository.getEmployee();
    }

    @Override
    @Transactional
    public List<Phone> getEmployeePhone() {
        return this.employeeRepository.getEmployeePhone();
    }
}
