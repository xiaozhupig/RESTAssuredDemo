package com.learn.spring_boot2_demo.bean;

import com.learn.spring_boot2_demo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.logging.Logger;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PersonTest {
    Logger logger = Logger.getLogger("PersonTest.class");
    @Autowired
    private  User user;

    @Autowired
    @Qualifier("Imp2")     //此处要使用实现类的别名 即：@Service("Imp2") 才行；如果直接使用类名，会报错
    private UserService service;

    @Test
    //@Ignore
    public void test(){
        System.out.println(user.toString());

    }

    @Test
    public void test1(){
        logger.info("日志记录开始");
        System.out.println(service.toString());
        logger.info("执行成功，并结束");

    }

}
