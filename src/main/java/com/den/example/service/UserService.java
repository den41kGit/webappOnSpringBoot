package com.den.example.service;


import com.den.example.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Сервис по работе с Пользователями
 */

public interface UserService {

    long save(User user);
    int deleteById(int id);
    int update(User element, int id);
    List<User> selectAll();
    User selectById(int id);

    boolean isValidLengthName(User user);

}