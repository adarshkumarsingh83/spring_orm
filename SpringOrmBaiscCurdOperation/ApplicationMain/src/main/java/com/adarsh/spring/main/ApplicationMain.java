package com.adarsh.spring.main;

import com.adarsh.spring.entity.impl.Employee;
import com.adarsh.spring.manager.EmployeeManager;
import com.adarsh.spring.util.ApplicationUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
public class ApplicationMain {

    private static final Logger logger = Logger.getLogger(ApplicationMain.class);

    public static void main(String[] args) {
        logger.info("ApplicationMain class main()");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/spring/applicationContext.xml");
        ApplicationMain applicationMain = (ApplicationMain) applicationContext.getBean("applicationMain");
        applicationMain.saveEmployee();
        applicationMain.getTableSize();
        applicationMain.displayEmployee();
        applicationMain.updateEmployee();
        applicationMain.displayEmployee();
        applicationMain.deleteEmployee();
        applicationMain.getTableSize();
    }


    private void saveEmployee() {
        Employee adarsh = new Employee("adarsh", "kumar", "singh", "adarsh@kumar.com", ApplicationUtil.getDate("09-13-1983"));
        employeeManagerImpl.saveEmployee(adarsh);
    }

    private void getTableSize() {
        Long tableSize = employeeManagerImpl.getTableSize();
        logger.info("Employee Table size " + tableSize);
    }



    private void displayEmployee() {
        List<Employee> employeeList = employeeManagerImpl.getAllEmployee();
        for (Employee e : employeeList) {
            logger.info(e.toString());
        }
    }

    private void updateEmployee() {
        Employee employee = employeeManagerImpl.getEmployee(new Employee(2));
        employee.setMiddleName("KR");
        employeeManagerImpl.updateEmployee(employee);
    }

    private void deleteEmployee(){
        employeeManagerImpl.deleteEmployee(new Employee(1));
    }

    @Autowired(required = true)
    private EmployeeManager employeeManagerImpl;

    public void setEmployeeManagerImpl(EmployeeManager employeeManagerImpl) {
        this.employeeManagerImpl = employeeManagerImpl;
    }
}

