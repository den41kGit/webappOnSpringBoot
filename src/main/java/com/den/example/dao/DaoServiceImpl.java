package com.den.example.dao;

import com.den.example.exception.UsersNotFoundException;
import com.den.example.model.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.*;


@Repository
@AllArgsConstructor
public class DaoServiceImpl implements DaoService<User> {

    private JdbcTemplate jdbcTemplate;

    @Override
    public long save(User user) {

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection
                    .prepareStatement("INSERT INTO users(username, password, role)" +
                "VALUES(?,?,cast(? as role_state))", new String[]{"id"});
                ps.setString(1, user.getUserName());
                ps.setString(2, user.getPassword());
                ps.setString(3, user.getUserRole());
                return ps;
        }, keyHolder);
        return keyHolder.getKey().longValue();
    }

    @Override
    public int deleteById(int id) {
        if(id <= 0){
            throw new RuntimeException("Other type of exception");
        }
        return jdbcTemplate.update("DELETE FROM users " +
                "WHERE id = ?", id);
    }

    @Override
    public int update(User user, int id) {
        if(id <= 0){
            throw new RuntimeException("Other type of exception");
        }

        return jdbcTemplate.update("UPDATE users SET username = ?, password = ?, role = cast(? as role_state) " +
                " WHERE id = ?", user.getUserName(),
                user.getPassword(), user.getUserRole(), id);
    }

    @Override
    public List<User> selectAll() {

        List<User> listUsers =  jdbcTemplate.query("SELECT id, username, role FROM users", (rs, rowNum) -> new User(
                rs.getLong("id"),
                rs.getString("userName"),
                rs.getString("role")
                )
        );
        if (listUsers.isEmpty()){
            throw new UsersNotFoundException("Database is Empty");
        }
        return listUsers;

    }

    @Override
    public User selectById(int id) {
        if(id <= 0){
            throw new RuntimeException("Other type of exception");
        }
        return jdbcTemplate.queryForObject("SELECT id, username, role FROM users WHERE id = ?",
                new Object[]{id}, (rs, rowNum) ->
                new User(
                        rs.getLong("id"),
                        rs.getString("userName"),
                        rs.getString("role")
                ));
    }
}
