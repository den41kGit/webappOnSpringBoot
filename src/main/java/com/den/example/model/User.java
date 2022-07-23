package com.den.example.model;

import lombok.*;

/**
 * POJO класс пользователя
 */
@Data
@AllArgsConstructor
public class User {

    private String userName;
    private String password;
//    private UserRole role = UserRole.user;
    private String userRole;// разобраться с РОЛЯМИ!!!!!!!!!!!

}
