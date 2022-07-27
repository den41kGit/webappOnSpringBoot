package com.den.example.dao;

import com.den.example.model.User;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.*;


@Repository
@AllArgsConstructor
public class DaoServiceImpl implements DaoService<User> {

    private JdbcTemplate jdbcTemplate;

    @Override
    public User save(User user) {
        List<Object[]> parameters = new ArrayList<Object[]>();
        parameters.add(new Object[] {user.getUserName(),
                    user.getPassword(),user.getUserRole()});

        jdbcTemplate.batchUpdate("INSERT INTO users(username, password, role)" +
                "VALUES(?,?,cast(? as role_state))", parameters);

        return user;
    }
    @Override
    public int deleteById(int id) {
        return jdbcTemplate.update("DELETE FROM users " +
                "WHERE id = ?", id);
    }
    @Override
    public int update(User user, int id) {

        return jdbcTemplate.update("UPDATE users SET username = ?, password = ?, role = cast(? as role_state) " +
                " WHERE id = ?", user.getUserName(),
                user.getPassword(), user.getUserRole(), id);
    }
    /*
    @Override
    public List<User> saveMultiple(List<User> list) {
        List<User> arr = new ArrayList();
        for (User user : list) {
            arr.add(save(user));
        }
        return arr;
    }

    @Override
    public User selectById(int id) {
        return USERS.get(id);
    }

    @Override
    public List<User> selectAll() {
        return new ArrayList<>(USERS.values());
    }
    */
}
