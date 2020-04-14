package com.espark.adarsh.dao;

import com.espark.adarsh.entities.Employee;

import java.util.List;

public interface EmployeeRepository {

	void saveEmployee(Employee employee);
	
	List<Employee> findAllEmployees();
	
	void deleteEmployeeBySsn(String ssn);
	
	Employee findBySsn(String ssn);
	
	void updateEmployee(Employee employee);
}
