package com.learn;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class BasicDemo4 {
/*
*
* 响应断言：assertThat()
*
* */
    @Test
    public void test1(){
        given().get("http://jsonplaceholder.typicode.com/photos/").then().assertThat().statusCode(200);
        given().get("http://jsonplaceholder.typicode.com/photos/").then().assertThat().contentType(ContentType.JSON);
        given().get("http://jsonplaceholder.typicode.com/photos/").then().assertThat().header("X-Powered-By","Express");
        given().get("http://jsonplaceholder.typicode.com/photos/").then().assertThat().headers("Vary","Origin, Accept-Encoding","Content-Type", containsString("json"));
    }

    /*
    *
    * 通过RequestSpecBuilder封装请求头
    *
    * */
    @Test
    public void test2(){

        //封装请求头
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.addParam("userId","2");
        requestSpecBuilder.addHeader("Accept-Encoding", "gzip, deflate");
        RequestSpecification requestSpecification = requestSpecBuilder.build();


        given().spec(requestSpecification).log().all()
                .when().get("http://jsonplaceholder.typicode.com/posts").then().statusCode(200);

    }

    /*
    * 通过ResponseSpecBuilder封装响应头
    * */
    @Test
    public void test3(){

        //封装响应头
        ResponseSpecBuilder builder = new ResponseSpecBuilder();
        builder.expectStatusCode(200);
        builder.expectHeader("Content-Type", "application/json; charset=utf-8");
        builder.expectHeader("Cache-Control", "public, max-age=14400");
        ResponseSpecification build = builder.build();

        given().get("http://jsonplaceholder.typicode.com/posts?userId=2").then().spec(build).time(lessThan(3000L));
    }

    /*
    * 日志打印：  log()
    *
    * */
    @Test
    public void test4(){
        given().get("http://jsonplaceholder.typicode.com/posts?userId=2").then().log().cookies();
        System.out.println("++++++++++");
        given().get("http://jsonplaceholder.typicode.com/posts?userId=2").then().log().headers();
        System.out.println("++++++++++");
        given().get("http://jsonplaceholder.typicode.com/posts?userId=2").then().log().body();
        System.out.println("**********");
        given().get("http://jsonplaceholder.typicode.com/posts?userId=1112").then().log().ifError();
        given().get("http://jsonplaceholder.typicode.com/posts?userId=1112").then().log().ifStatusCodeIsEqualTo(200);


    }
}
