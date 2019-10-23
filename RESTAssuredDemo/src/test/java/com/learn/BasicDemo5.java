package com.learn;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
public class BasicDemo5 {
    /*
    * baseURI
    * basePath
    *
    * */
    @BeforeTest
    public void setup(){
        baseURI = "http://jsonplaceholder.typicode.com";
//        port = 80;
        basePath ="/posts";
    }

    @Test
    public void test1(){
        given().get("/1").then().statusCode(200).log().all();
    }

    @Test
    public  void test2(){
        given().get("/1/comments").then().statusCode(200).log().all();
    }

    @Test
    public void test3(){
        given().get("?userId=1").then().statusCode(200).log().all();
    }
}
