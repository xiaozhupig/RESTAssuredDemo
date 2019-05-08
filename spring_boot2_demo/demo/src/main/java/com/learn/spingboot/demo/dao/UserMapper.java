package com.learn.spingboot.demo.dao;

import com.learn.spingboot.demo.pojo.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
//@Mapper
public interface UserMapper {

    @Select("select id,name,age,phone,email from users where age=#{age}")
    List<User> getUser(int age);

}
