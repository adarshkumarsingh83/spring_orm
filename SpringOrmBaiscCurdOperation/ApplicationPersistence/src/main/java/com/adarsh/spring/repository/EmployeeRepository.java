package com.adarsh.spring.repository;

import com.adarsh.spring.entity.impl.Employee;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */

public interface EmployeeRepository {

    public Long getTableSize();

    public List<Employee> getAllEmployee();

    public void saveEmployee(Employee employee);

    public void deleteEmployee(Employee employee);

    public void updateEmployee(Employee employee);

    public Employee getEmployee(Employee employee);

    public void setSessionFactory(SessionFactory sessionFactory);
}
