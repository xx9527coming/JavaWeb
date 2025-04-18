<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户注册</title>
</head>
<body>
<h1>用户注册</h1>
<form action="register" method="post">
    <label>用户名:</label>
    <input type="text" name="username" required><br><br>
    <label>密码:</label>
    <input type="password" name="password" required><br><br>
    <label>电话:</label>
    <input type="text" name="tel"><br><br>
    <label>邮箱:</label>
    <input type="email" name="email"><br><br>
    <input type="submit" value="注册">
</form>
<p>已有账号？<a href="login.jsp">登录</a></p>
</body>
</html>