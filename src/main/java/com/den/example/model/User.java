package com.den.example.model;

import lombok.*;

/**
 * POJO класс пользователя
 */
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class User {
    private Long id;
    private String userName;
    private String password;
    private String userRole = "user";

    public User(Long id, String userName, String userRole) {
        this.id = id;
        this.userName = userName;
        this.userRole = userRole;
     }
}
