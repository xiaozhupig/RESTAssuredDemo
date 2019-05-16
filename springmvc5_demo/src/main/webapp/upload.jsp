<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/5/13
  Time: 16:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上传文件页面</title>
    <h1>上传</h1>
    <form action="/springmvc5_demo_war_exploded/upload1" method="post" enctype="multipart/form-data">
        <input type="file" name="fileName" >
        <input type="submit" name="提交">

    </form>
    <hr/>

    <form enctype="multipart/form-data" method="post" action="/springmvc5_demo_war_exploded/upload/static">
    <p class="text-info">上传至/web/static</p>

    <input type="file" name="uploadFile">

        <input type="submit" name="提交">
    </form>
<body>

</body>
</html>
