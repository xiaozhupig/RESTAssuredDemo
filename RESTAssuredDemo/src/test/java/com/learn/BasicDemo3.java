package com.learn;

import io.restassured.http.*;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
public class BasicDemo3 {
    /*
    * post 请求
    *
    * */
    @Test
    public void test1(){
        given().
                param("name","Anthony123").param("job","tester").
                header("Content-Type","text/html").when().
                post("https://reqres.in/api/users").then().statusCode(201).log().all();
    }
    /*
    * 响应转换成字符串： asString()
    * */
    @Test
    public void test2(){
        String response =get("https://reqres.in/api/users/2").asString();
        System.out.println(response);
    }

    /*
    * 响应转换成输入流： asInputStream
    * */
    @Test
    public void test3() throws IOException {
        InputStream responseAsInputStream = get("https://reqres.in/api/users/2").asInputStream();

        int length = responseAsInputStream.toString().length();
        System.out.println(length);
        responseAsInputStream.close();
    }
    /*
    * 响应转换成字节数组: asByteArray()
    * */
    @Test
    public  void test4(){
        byte[] bytes = get("https://reqres.in/api/users/2").asByteArray();
        System.out.println(bytes.length);
        for(byte b :bytes){
            System.out.println((char) b);
        }
    }
    /*
    * 提取内容： extract()
    *
    * */
    @Test
    public void test5(){
        String url = get("http://jsonplaceholder.typicode.com/photos/1").then().statusCode(200).extract().path("url");
        System.out.println(url);

    }

    @Test
    public void test6(){
        int code = get("http://jsonplaceholder.typicode.com/photos/1").then().extract().statusCode();
        System.out.println(code);
    }
    /*
    * 获取响应对象后，再进行解析
    *
    * */
    @Test
    public void test7(){
        Response response = get("http://jsonplaceholder.typicode.com/photos/1").then().extract().response();
        System.out.println(response.contentType());
        System.out.println(response.statusLine());

    }
    /*
    * 获取响应头: getHeaders(), getHeader()
    *
    * */
    @Test
    public void test8(){
        Headers headers = get("http://jsonplaceholder.typicode.com/photos").getHeaders();
        for(Header h : headers){
            System.out.println(h.getName()+":"+h.getValue());
        }
        System.out.println("----------------");
        String header = get("http://jsonplaceholder.typicode.com/photos").getHeader("Content-Type");
        System.out.println(header);

    }
    /*
    * 获取cookies：getCookies()
    *              遍历
    *
    * */
    @Test
    public void test9(){
        String cookie = get("http://jsonplaceholder.typicode.com/photos").getCookie("__cfduid");
        Map<String, String> cookies= get("http://jsonplaceholder.typicode.com/photos").getCookies();
        System.out.println(cookie);
        for(Map.Entry<String,String> entry : cookies.entrySet()){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }
    /*
    * 获取cookie的详细信息： getDetailedCookie()
    * */
    @Test
    public void test10(){
        Cookie cookie = get("http://jsonplaceholder.typicode.com/photos").getDetailedCookie("__cfduid");
        System.out.println(cookie.getName());
        System.out.println(cookie.getExpiryDate());
        System.out.println(cookie.hasValue());
    }
    /*
    *
    * 通过变量名称拼接成完整的请求url: pathParam()
    * */

    @Test
    public void test11(){
        given().pathParam("section","posts").pathParam("id","3").
                when().log().all().
                get("http://jsonplaceholder.typicode.com/{section}/{id}").then().log().all().statusCode(200);
    }

    /*
    * 请求中创建cookie:  cookie()
    * */
    @Test
    public void test12(){
        given().
                cookie("__id","1","2").when().log().all().
                get("http://jsonplaceholder.typicode.com/hello.html").then().statusCode(404);
    }

    @Test
    public  void test13(){
        Cookie cookie = new Cookie.Builder("__uuck", "hello123").setSecured(true).setComment("haha").build();
        //设置一个详细的cookie
        given().cookie(cookie).when().log().all().
                get("http://jsonplaceholder.typicode.com/hello.html").then().statusCode(404);

        //设置多个详细的cookie
        Cookie cookie1 = new Cookie.Builder("__sid", "ss123").setSecured(true).setComment("test").build();
        Cookies cookies = new Cookies(cookie, cookie1);
        given().cookies(cookies).when().log().all().
                get("http://jsonplaceholder.typicode.com/hello.html").then().statusCode(404);
    }

}
