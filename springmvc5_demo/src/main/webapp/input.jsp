<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>

<h3>编辑员工</h3>
<form action="/saveOrUpdate" method="post">
    <%--<input type="hidden" name="id" value="${student.id}"/>--%>
    账号<input type="text" name="name" value="${student.name}"/><br/>
    密码<input type="text" name="password"  value="${student.password}"/><br/>
    年龄<input type="text" name="age"  value="${student.age}"/><br/>
    分数<input type="text" name="score"  value="${student.score}"/><br/>
    <input type="submit" value="保存"/>
</form>
</body>
</html>