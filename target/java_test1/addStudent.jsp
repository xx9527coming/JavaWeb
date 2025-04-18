<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>添加学生信息</title>
</head>
<body>
<h1>添加学生信息</h1>
<form action="addStudent" method="post">
    <label>学号:</label>
    <input type="number" name="stuNO" required><br><br>
    <label>姓名:</label>
    <input type="text" name="name" required><br><br>
    <label>性别:</label>
    <input type="text" name="sex"><br><br>
    <label>民族:</label>
    <input type="text" name="nation"><br><br>
    <label>电话:</label>
    <input type="text" name="telephone"><br><br>
    <label>出生年月:</label>
    <input type="date" name="birthday"><br><br>
    <label>地址:</label>
    <input type="text" name="address"><br><br>
    <label>照片:</label>
    <input type="text" name="photo"><br><br>
    <label>个人简介:</label>
    <textarea name="resume"></textarea><br><br>
    <input type="submit" value="添加">
</form>
<a href="home.jsp">返回主页</a>
</body>
</html>