package com.adarsh.spring.controller;

/**
 * @Author Adarsh
 * @Product Lucas.
 * Created By: Adarsh
 * Created On Date: 2/2/2015  Time: 10:46 PM
 * This Class provide the implementation for the functionality of..
 */

import com.adarsh.spring.service.UserManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserManagementController {

    @Autowired
    private UserManagementService userManagementService;



}
