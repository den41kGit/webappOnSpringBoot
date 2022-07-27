package com.den.example.model;

import lombok.*;

/**
 * POJO класс пользователя
 */
@Data
@RequiredArgsConstructor
public class User {

    private String userName;
    private String password;
    private String userRole = "user";

}
