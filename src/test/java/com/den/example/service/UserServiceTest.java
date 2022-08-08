package com.den.example.service;

import com.den.example.model.User;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest extends TestCase {

    @Autowired
    private UserService userService;
    @Test
    public void testIsValidLengthName() {

        User user1 = new User(1L, "Denis", "123", "admin");
        User user2 = new User(2L, "DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD", "123", "admin");

        Assert.assertTrue(userService.isValidLengthName(user1));
        Assert.assertFalse(userService.isValidLengthName(user2));
    }
}