<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>查看所有学生信息</title>
</head>
<body>
<h1>学生信息列表</h1>
<table border="1">
    <tr>
        <th>学号</th>
        <th>姓名</th>
        <th>性别</th>
        <th>民族</th>
        <th>电话</th>
        <th>出生年月</th>
        <th>地址</th>
        <th>照片</th>
        <th>个人简介</th>
        <th>操作</th>
    </tr>
    <%
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/student?serverTimezone=Asia/Shanghai";
            Connection conn = DriverManager.getConnection(url, "root", "root");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Student");

            while (rs.next()) {
                out.println("<tr>");
                out.println("<td>" + rs.getInt("stuNO") + "</td>");
                out.println("<td>" + rs.getString("name") + "</td>");
                out.println("<td>" + rs.getString("sex") + "</td>");
                out.println("<td>" + rs.getString("nation") + "</td>");
                out.println("<td>" + rs.getString("telephone") + "</td>");
                out.println("<td>" + rs.getString("birthday") + "</td>");
                out.println("<td>" + rs.getString("address") + "</td>");
                out.println("<td>" + rs.getString("photo") + "</td>");
                out.println("<td>" + rs.getString("resume") + "</td>");
                out.println("<td><a href='editStudent.jsp?stuNO=" + rs.getInt("stuNO") + "'>编辑</a> | <a href='deleteStudent?stuNO=" + rs.getInt("stuNO") + "'>删除</a></td>");
                out.println("</tr>");
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    %>
</table>
<a href="home.jsp">返回主页</a>
</body>
</html>