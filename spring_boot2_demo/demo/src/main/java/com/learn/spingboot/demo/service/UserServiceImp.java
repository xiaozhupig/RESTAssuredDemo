package com.learn.spingboot.demo.service;

import com.learn.spingboot.demo.dao.UserMapper;
import com.learn.spingboot.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImp implements UserService{

    @Autowired
    private  UserMapper userMapper;
    @Override
    public List<User> getUser(int age) {
        return userMapper.getUser(age);
    }
}
