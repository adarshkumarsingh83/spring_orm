package com.adarsh.spring;

import com.adarsh.spring.entity.Groups;
import com.adarsh.spring.entity.Permission;
import com.adarsh.spring.entity.User;
import com.adarsh.spring.service.UserManagementService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 * @Author Adarsh
 * @Product Lucas.
 * Created By: Adarsh
 * Created On Date: 2/2/2015  Time: 6:32 PM
 * This Class provide the implementation for the functionality of..
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/configuration/applicationContext.xml"})
public class TestServices {

    private final static Logger LOGGER = Logger.getLogger(TestServices.class);

    @Autowired
    private UserManagementService userManagementService;

    @Test
    @Rollback(false)
    @Transactional(readOnly = false)
    public void testSaveUser() {
        this.userManagementService.saveUser(new User("UserOne", "User@Email.com"));
        final User user = this.userManagementService.getUser(new User("UserOne", "User@Email.com"));
        org.springframework.util.Assert.notNull(user, "User Object is Null");
        LOGGER.info(user);
    }


    @Test
    @Rollback(false)
    @Transactional(readOnly = false)
    public void testSaveUsers() {
        final List<User> userList=new ArrayList<>();
        userList.add(new User("UserOne", "UserOne@Email.com"));
        userList.add(new User("UserTwo", "UserTwo@Email.com"));
        userList.add(new User("UserThree", "UserThree@Email.com"));
        this.userManagementService.saveUsers(userList);
        final List<User> userList1 = this.userManagementService.getUsers();
        org.springframework.util.Assert.notNull(userList1, "User List is Null");
        LOGGER.info(userList1);
    }



    @Test
    @Rollback(false)
    @Transactional(readOnly = false)
    public void testSavePermission(){
        this.userManagementService.savePermission(new Permission("PermissionOne"));
        final Permission permission=this.userManagementService.getPermission(new Permission("PermissionOne"));
        org.springframework.util.Assert.notNull(permission, "Permission Object is Null");
        LOGGER.info(permission);
    }

    @Test
    @Rollback(false)
    @Transactional(readOnly = false)
    public void testSavePermissions(){
        final List<Permission> permissionList=new ArrayList<>();
        permissionList.add(new Permission("PermissionOne") );
        permissionList.add(new Permission("PermissionTwo") );
        permissionList.add(new Permission("PermissionThree") );
        this.userManagementService.savePermission(permissionList);
        final List<Permission> permissionList1=this.userManagementService.getPermissions();
        org.springframework.util.Assert.notNull(permissionList1, "Permission List is Null");
        LOGGER.info(permissionList1);
    }

    @Test
    @Rollback(false)
    @Transactional(readOnly = false)
    public void testSaveGroup() {
        final Collection<User> userCollection = this.userManagementService.getUsers();
        final Collection<Permission>permissionCollection=this.userManagementService.getPermissions();
        this.userManagementService.saveGroup(new Groups("GroupOne", new HashSet(userCollection), new HashSet(permissionCollection)));
        final Groups groups = this.userManagementService.getGroup(new Groups("GroupOne", new HashSet(userCollection), new HashSet(permissionCollection)));
        org.springframework.util.Assert.notNull(groups, "User Group Object is Null");
        LOGGER.info(groups);
    }

    @Test
    @Rollback(false)
    @Transactional(readOnly = false)
    public void testSaveGroups() {
        final Collection<User> userCollection = this.userManagementService.getUsers();
        final Collection<Permission>permissionCollection=this.userManagementService.getPermissions();

        final List<Groups> groupsList=new ArrayList<>();
        groupsList.add(new Groups("GroupOne", new HashSet(userCollection), new HashSet(permissionCollection)));
        groupsList.add(new Groups("GroupTwo", new HashSet(userCollection), new HashSet(permissionCollection)));
        groupsList.add(new Groups("GroupThree", new HashSet(userCollection), new HashSet(permissionCollection)));

        this.userManagementService.saveGroup(groupsList);
        final List<Groups> groupsList1 = this.userManagementService.getGroup();
        org.springframework.util.Assert.notNull(groupsList1, "User Group Object is Null");
        LOGGER.info(groupsList1);
    }

}
