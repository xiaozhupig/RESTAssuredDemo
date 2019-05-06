package com.learn.spring_boot2_demo;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestDemo {

    @Test
    public void  test1(){
        System.out.println("this is test----");
    }

    @Before
    public void beforeTest(){
        System.out.println("this is before test===");
    }

    @After
    public void afterTest(){
        System.out.println("this is after test+++=");
    }
}
