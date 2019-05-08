package com.learn.spingboot.demo.service;

import com.learn.spingboot.demo.pojo.User;

import java.util.List;

public interface UserService {

    List<User> getUser(int age);
}
