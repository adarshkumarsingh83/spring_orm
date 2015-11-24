package com.adarsh.spring.service;

import com.adarsh.spring.dao.EmployeeDao;
import com.adarsh.spring.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 0001 $, $Date:: 31/1/2015 00:11 AM#
 */
@Service("employeeService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addEmployee(Employee employee) {
		employeeDao.addEmployee(employee);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<Employee> listEmployees() {
		return employeeDao.listEmployees();
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public Employee getEmployee(int empId) {
		return employeeDao.getEmployee(empId);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteEmployee(Employee employee) {
		employeeDao.deleteEmployee(employee);
	}

}
