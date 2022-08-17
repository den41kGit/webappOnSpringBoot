package com.den.example.service;

import com.den.example.dao.DaoService;
import com.den.example.model.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
public class UserServiceImpl implements UserService{
    @Autowired
    private DaoService<User> daoService;

    @Override
    public long save(User user) {
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
    public boolean isValidLengthName(User user) {

        return (user.getUserName().length() < 35);
    }
}
