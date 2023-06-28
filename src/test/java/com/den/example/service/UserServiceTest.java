package com.den.example.service;

import com.den.example.model.User;
import org.junit.Assert;
import org.junit.Test;

public class UserServiceTest {

    private final UserService userService = new UserServiceImpl();

    //TODO ошибки в названиях Lenght, LEnght(length)
    @Test
    public void givenUserWithInvalidLenghtName_whenIsValidLEnghtName_thenResultIsFalse() {

        User userFalse = new User(2L, "DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD",
                "123",
                "admin");

        Assert.assertFalse(userService.isValidLengthName(userFalse));
    }
    @Test
    public void givenUserWithValidLenghtName_whenIsValidLEnghtName_thenResultIsTrue() {

        User userTrue = new User(1L, "Denis", "123", "admin");

        Assert.assertTrue(userService.isValidLengthName(userTrue));
    }
}