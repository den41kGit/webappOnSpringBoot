package com.den.example.model;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;
//TODO возможно тут можно было просто использовать @Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ApiErrors {
    String message;
    List<String> details;
    HttpStatus status;
    LocalDateTime timestamp;
}
