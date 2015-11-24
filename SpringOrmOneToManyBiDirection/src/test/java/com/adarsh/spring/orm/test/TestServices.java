package com.adarsh.spring.orm.test;

import com.adarsh.spring.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author Adarsh
 * Created By: Adarsh
 * Created On Date: 2/2/2015  Time: 6:32 PM
 * This Class provide the implementation for the functionality of..
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/configuration/applicationContext.xml"})
public class TestServices {

    @Qualifier("employeeServiceImpl")
    @Autowired
    private EmployeeService employeeService;


    @Test
    public void testSaveEmployee(){

    }
}