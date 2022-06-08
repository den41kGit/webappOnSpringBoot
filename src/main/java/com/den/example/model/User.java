package com.den.example.model;

import lombok.*;

/**
 * POJO класс пользователя
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    private String userName;
    private int password;
    private UserRole role = UserRole.USER;

}
