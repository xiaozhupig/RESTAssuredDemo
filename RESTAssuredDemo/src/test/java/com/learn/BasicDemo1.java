package com.learn;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class BasicDemo1 {

    @Test
    public  void test(){
        get("https://www.baidu.com").then().statusCode(200).log().all();
    }

    @Test
    public void test2(){
        get("http://jsonplaceholder.typicode.com/posts/3").then().body("id",equalTo(3),"title",equalTo("hello.world"));
    }
    /*
    * 有请求参数： param().when()
    * */
    @Test
    public void test3(){
        given().param("userId",2).when().get("http://jsonplaceholder.typicode.com/posts").then().statusCode(200).log().all();
    }
    /*
    *
    * 有多个请求参数：params().when()
    * */
    @Test
    public void test4(){
        Map<String, Integer> parameters = new HashMap<String, Integer>();
        parameters.put("userId",2);
        parameters.put("id",17);
        given().params(parameters).when().get("http://jsonplaceholder.typicode.com/posts").then().statusCode(200).log().all();
    }
    /*
    * 添加一个请求头：header().when()
    *
    * */
    @Test
    public  void  test5(){
        given().header("accept-encoding","gzip").when().log().all().get("http://jsonplaceholder.typicode.com/posts").then().statusCode(200);
    }
    /*
    *
    * 添加多个请求头：headers().when()
    * */
    @Test
    public void test6(){
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("accept-encoding", "gzip,deflate");
        headers.put("accept-language", "zh-CN");
        given().headers(headers).when().log().all().get("http://jsonplaceholder.typicode.com/posts").then().statusCode(200).log().all();
    }
    /*
    * 同时添加多个请求头和请求参数:headers(headers).and().params(parameters)
    *                           或者headers(headers).params(parameters)
    * */
    @Test
    public void test7(){
        Map<String, Integer> parameters = new HashMap<String, Integer>();
        parameters.put("userId",2);
        parameters.put("id",17);

        Map<String, String> headers = new HashMap<String, String>();
        headers.put("accept-encoding", "gzip,deflate");
        headers.put("accept-language", "zh-CN");

        given().headers(headers).and().params(parameters).when().log().all().get("http://jsonplaceholder.typicode.com/posts").then().statusCode(200).log().all();

    }
}
