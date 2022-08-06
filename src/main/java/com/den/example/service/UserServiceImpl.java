package com.den.example.service;

import com.den.example.dao.DaoService;
import com.den.example.model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    private DaoService<User> daoService;

    @Override
    public Number save(User user) {
        return daoService.save(user);
    }
    @Override
    public int deleteById(int id) {
        return daoService.deleteById(id);
    }
    @Override
    public int update(User element, int id) {
        return daoService.update(element, id);
    }

    @Override
    public List<User> selectAll() {
        return daoService.selectAll();
    }

    @Override
    public User selectById(int id) {
        return daoService.selectById(id);
    }

    @Override
    public boolean checkLengthName(User user) {

        return (user.getUserName().length() < 35);
    }
}
