package com.adarsh.spring.manager;

import com.adarsh.spring.entity.impl.Employee;

import java.util.List;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */

public interface EmployeeManager {

    public Long getTableSize();

    public List<Employee> getAllEmployee();

    public void saveEmployee(Employee employee);

    public void deleteEmployee(Employee employee);

    public void updateEmployee(Employee employee);

    public Employee getEmployee(Employee employee);

}
