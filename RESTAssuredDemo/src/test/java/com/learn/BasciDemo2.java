package com.learn;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
public class BasciDemo2 {
    /*
    * 校验响应内容格式html:  contentType(ContentType.HTML)
    *
    * */
    @Test
    public void test1(){
        given().get("https://www.baidu.com").then().statusCode(200).contentType(ContentType.HTML);
    }
    /*
    * 校验响应内容格式json: contentType(ContentType.JSON)
    * */
    @Test
    public void test2(){
        given().get("http://jsonplaceholder.typicode.com/photos/1").then().statusCode(200).contentType(ContentType.JSON);
    }
    /*
     * 校验响应内容格式json: contentType(ContentType.XML)
     * */
    @Test
    public void test3(){
        given().get("http://www.thomas-bayer.com/sqlrest/INVOICE/").then().statusCode(200).contentType(ContentType.XML);
    }
}
