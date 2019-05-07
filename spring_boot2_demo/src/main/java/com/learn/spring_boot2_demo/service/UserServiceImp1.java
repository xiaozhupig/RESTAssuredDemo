package com.learn.spring_boot2_demo.service;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImp1  implements  UserService{
    @Override
    public void select() {
        System.out.println("select **");
    }

    @Override
    public void deleteId() {
        System.out.println("dele --");
    }
}
