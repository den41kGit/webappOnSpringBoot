package com.den.example.service;


import com.den.example.model.User;

import java.util.List;

/**
 * Сервис по работе с Пользователями
 */
public interface UserService {

    Number save(User user);
    int deleteById(int id);
    int update(User element, int id);
    List<User> selectAll();
    User selectById(int id);

    boolean checkLengthName(User user);

}