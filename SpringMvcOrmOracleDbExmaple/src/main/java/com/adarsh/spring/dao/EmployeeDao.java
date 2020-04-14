package com.adarsh.spring.dao;

import com.adarsh.spring.entity.Employee;

import java.util.List;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 0001 $, $Date:: 31/1/2015 00:11 AM#
 */

public interface EmployeeDao {
	
	public void addEmployee(Employee employee);

	public List<Employee> listEmployees();
	
	public Employee getEmployee(int empId);
	
	public void deleteEmployee(Employee employee);
}
