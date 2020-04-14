package com.espark.adarsh.test;

import com.adarsh.spring.entity.impl.Group;
import com.adarsh.spring.entity.impl.Users;
import com.adarsh.spring.manager.UserManager;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")
public class UsersManagerTest {

    @Autowired(required = true)
    private UserManager userManager;

    @Transactional
    @Test
    public void testGetAllUser(){
        final List<Users> usersList = this.userManager.getAllUser(true,false);
        Assert.assertNotNull("Users List is Null ", usersList);
        System.out.println("\n\n\n===>"+usersList);
    }

    @Transactional
    @Test
    public void testGetAllUserWithDependency(){
        final List<Users> usersList = this.userManager.getAllUser(true,true);
        Assert.assertNotNull("Users List is Null ", usersList);
        System.out.println("\n\n\n===>"+usersList);
    }

    @Transactional
    @Test
    public void testGetAllGroup(){
        final List<Group> groupList=this.userManager.getAllGroup(true,true);
        Assert.assertNotNull("Group List is Null ", groupList);
        System.out.println("\n\n\n===>"+groupList);
    }
}
