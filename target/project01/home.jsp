<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>主页</title>
</head>
<body>
<h1>欢迎, <%= session.getAttribute("username") %>!</h1>
<a href="logout">退出登录</a>

<h2>学生信息管理</h2>
<ul>
  <li><a href="addStudent.jsp">添加学生信息</a></li>
  <li><a href="viewAllStudents.jsp">查看所有学生信息</a></li>
</ul>
</body>
</html>