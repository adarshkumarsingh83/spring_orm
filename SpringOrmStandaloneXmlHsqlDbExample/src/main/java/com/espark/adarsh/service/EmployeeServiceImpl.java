package com.espark.adarsh.service;

import com.espark.adarsh.dao.EmployeeRepository;
import com.espark.adarsh.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Qualifier("employeeRepository")
    @Autowired(required = true)
    private EmployeeRepository employeeRepository;

    public void saveEmployee(Employee employee) {
        employeeRepository.saveEmployee(employee);
    }

    public List<Employee> findAllEmployees() {
        return employeeRepository.findAllEmployees();
    }

    public void deleteEmployeeBySsn(String ssn) {
        employeeRepository.deleteEmployeeBySsn(ssn);
    }

    public Employee findBySsn(String ssn) {
        return employeeRepository.findBySsn(ssn);
    }

    public void updateEmployee(Employee employee) {
        employeeRepository.updateEmployee(employee);
    }
}
