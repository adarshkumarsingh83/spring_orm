package com.adarsh.spring;

import com.adarsh.spring.domain.Role;
import com.adarsh.spring.domain.User;
import com.adarsh.spring.repository.RoleRepository;
import com.adarsh.spring.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;


public class JpaTest {

    private static final ApplicationContext APPLICATION_CONTEXT = new ClassPathXmlApplicationContext("classpath:/spring/applicationContext.xml");
    private static final UserService USER_SERVICE = APPLICATION_CONTEXT.getBean(UserService.class);
    private static final RoleRepository ROLE_REPOSITORY = APPLICATION_CONTEXT.getBean(RoleRepository.class);

    @Test
    public void testGetAllUser() {

        List<User> userList = USER_SERVICE.getAllUser();
        for (User user : userList) {
            System.out.println(user.display());
        }
    }

    @Test
    public void testSaveUser() {
        Role role=ROLE_REPOSITORY.findById(2L);
        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setId((2L + i));
            user.setFirstName("firstName" + i);
            user.setLastName("lastname" + i);
            user.setUsername("Username"+i);
            user.setPassword("userpwd"+i);
            user.setRole(role);
            USER_SERVICE.saveUser(user);
        }
    }

    @Test
    public void testGetAllRoles() {
        List<Role> roleList = ROLE_REPOSITORY.findAll();
        for (Role role : roleList) {
            System.out.println(role.toString());
        }
    }


}
