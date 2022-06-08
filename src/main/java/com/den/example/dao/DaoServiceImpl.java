package com.den.example.dao;

import com.den.example.model.User;
import org.springframework.stereotype.Repository;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class DaoServiceImpl implements DaoService<User> {
    private static final Map<Integer, User> USERS = new HashMap<>();

    private static final AtomicInteger USERS_ID_GENERATION = new AtomicInteger();

    @Override
    public User save(User user) {
        final int userId = USERS_ID_GENERATION.incrementAndGet();
        user.setId(userId);
        USERS.put(userId, user);
        return USERS.get(userId);
    }

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

    @Override
    public boolean update(User user, int id) {
        if (USERS.containsKey(id)){
            user.setId(id);
            USERS.put(id, user);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        return USERS.remove(id) !=null;
    }
}