package com.learn.demo;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.matchesPattern;

public class Demo1 {

    @Test
    public void test(){
        /*
        * current: 1
            currentImg: ""
            fundsProject: "有机卡宾"
            fundsSources: ""
            search: ""
            showImg: false
            size: 10
        *
        *   使用map封装json请求数据
        * */
        Map<String,Object> jsonMap = new HashMap<String, Object>();
        jsonMap.put("current",1);
        jsonMap.put("currentImg","");
        jsonMap.put("fundsProject","有机卡宾");
        jsonMap.put("fundsSources","");
        jsonMap.put("search","");
        jsonMap.put("showImg",false);
        jsonMap.put("size",10);
        given().header("access_token","eyJhbGciOiJIUzI1NiIsInppcCI6IkdaSVAifQ.H4sIAAAAAAAAAKtWyirJVLJSMjVS0lEqLk0CMotLC1KLElNyM_OAQpmJJUpWhqbmhpYWhmaGljpKqRUFYAEjAwtLoEAtAM9hQ3JBAAAA.VpQYwuureNNfwUd3IBnGD9LgzD9SB-wDvx71D99fRDQ").
                contentType(ContentType.JSON).body(jsonMap).when().
                post("http://10.10.11.167:8080/exchange/back/exchange-project/pageAll").then().statusCode(200).log().all();
    }

}
