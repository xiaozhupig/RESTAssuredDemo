package com.learn.pojo;


import com.learn.valid.ValidGroup1;
import com.learn.valid.ValidGroup2;
import org.springframework.stereotype.Repository;
import sun.plugin2.message.Message;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Repository
public class Student {

    private int id;
    @NotNull(message = "用户名不能为空")
    private String name;
    @NotNull(message =" 密码不能为空")
    @Size(min = 3,max = 20,message = "密码长度在3-20之间",groups = {ValidGroup1.class, ValidGroup2.class})
    private String password;
    @Min(value = 5,message = "年龄最小值为5")
    @Max(value = 30,message = "年龄最大值为30")
    private int age;

    private int score;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }
}
