package com.adarsh.spring.manager.impl;

import com.adarsh.spring.entity.impl.Employee;
import com.adarsh.spring.manager.EmployeeManager;
import com.adarsh.spring.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Transient;
import java.util.List;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
@Service
public class EmployeeManagerImpl implements EmployeeManager {

    @Transactional(readOnly = true)
    @Override
    public Long getTableSize() {
        return employeeRepositoryImpl.getTableSize();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepositoryImpl.getAllEmployee();
    }

    @Transactional(readOnly = false)
    @Override
    public void saveEmployee(Employee employee) {
        employeeRepositoryImpl.saveEmployee(employee);
    }

    @Transactional(readOnly = false)
    @Override
    public void deleteEmployee(Employee employee) {
        employeeRepositoryImpl.deleteEmployee(employee);
    }

    @Transactional(readOnly = false)
    @Override
    public void updateEmployee(Employee employee) {
        employeeRepositoryImpl.updateEmployee(employee);
    }

    @Transactional(readOnly = true)
    @Override
    public Employee getEmployee(Employee employee) {
        return employeeRepositoryImpl.getEmployee(employee);
    }

    @Autowired(required = true)
    private EmployeeRepository employeeRepositoryImpl;

    public void setEmployeeRepositoryImpl(EmployeeRepository employeeRepositoryImpl) {
        this.employeeRepositoryImpl = employeeRepositoryImpl;
    }
}
