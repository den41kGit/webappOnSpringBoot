package com.den.example;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
@AllArgsConstructor
public class SpringCrudApplication implements CommandLineRunner {

    private JdbcTemplate jdbcTemplate;

   public static void main(String[] args) {
        SpringApplication.run(SpringCrudApplication.class,args);
    }


    @Override
    public void run(String... args) throws Exception {

        jdbcTemplate.execute("DROP TABLE IF  EXISTS users");
        jdbcTemplate.execute("DROP TYPE IF  EXISTS role_state");
        jdbcTemplate.execute("CREATE TYPE role_state AS ENUM ('user', 'admin', 'moderator')");
        jdbcTemplate.execute("CREATE TABLE users(" +
                "id SERIAL primary key, username VARCHAR(255), password VARCHAR(255), role role_state )");

    }
}
