package com.den.example.service;


import com.den.example.exception.DateEnterIncorrectException;
import com.den.example.exception.IdNotFoundException;
import com.den.example.exception.UsersNotFoundException;
import com.den.example.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Сервис по работе с Пользователями
 */
@Service
public interface UserService {
    //TODO неуверен что тут в сигнатуру надо писать эти ошибки, ведь они runtime, и в имплиментации их нет
    long save(User user) throws DateEnterIncorrectException;
    int deleteById(int id) throws IdNotFoundException;
    int update(User element, int id) throws IdNotFoundException;
    List<User> selectAll() throws UsersNotFoundException;
    User selectById(int id) throws IdNotFoundException;

    boolean isValidLengthName(User user);

}