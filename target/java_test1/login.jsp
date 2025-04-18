<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户登录</title>
</head>
<body>
<h1>用户登录</h1>
<form action="login" method="post">
    <label>用户名:</label>
    <input type="text" name="username" required><br><br>
    <label>密码:</label>
    <input type="password" name="password" required><br><br>
    <input type="submit" value="登录">
</form>
<p>没有账号？<a href="register.jsp">注册</a></p>
<%
    String error = request.getParameter("error");
    if (error != null && error.equals("1")) {
        System.out.println("<p style='color:red;'>用户名或密码错误！</p>");
    }
%>
</body>
</html>