package com.ak;

import com.ak.entity.User;
import com.ak.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

/**
 * Created by MacDuck on 11/15/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ContactBookApplication.class)
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    public void addUserTest(){
        User user1 = new User("admin", "qwerty", "EKA");
        userService.addUser(user1);
        assertEquals("admin", userService.findByLogin("admin").getLogin());
    }

    @Test
    public void getUserTest(){
        String searchingLogin = "admin";
        User testedUser = userService.findByLogin(searchingLogin);
        assertEquals(searchingLogin, testedUser.getLogin());
    }
}
