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
    public User save(User user) {
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

    /*@Override
    public List<User> saveMultiple(List<User> list) {
        return daoService.saveMultiple(list);
    }

    @Override
    public User selectById(int id) {
        return (User) daoService.selectById(id);
    }

    @Override
    public List<User> selectAll() {
        return daoService.selectAll();
    }
       */
}
