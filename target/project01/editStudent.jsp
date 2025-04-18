<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>编辑学生信息</title>
</head>
<body>
<h1>编辑学生信息</h1>
<%
  int stuNO = Integer.parseInt(request.getParameter("stuNO"));
  try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    String url = "jdbc:mysql://localhost:3306/student?serverTimezone=Asia/Shanghai";
    Connection conn = DriverManager.getConnection(url, "root", "root");
    String sql = "SELECT * FROM Student WHERE stuNO = ?";
    PreparedStatement pstmt = conn.prepareStatement(sql);
    pstmt.setInt(1, stuNO);
    ResultSet rs = pstmt.executeQuery();

    if (rs.next()) {
%>
<form action="updateStudent" method="post">
  <input type="hidden" name="stuNO" value="<%= rs.getInt("stuNO") %>">
  <label>姓名:</label>
  <input type="text" name="name" value="<%= rs.getString("name") %>"><br><br>
  <label>性别:</label>
  <input type="text" name="sex" value="<%= rs.getString("sex") %>"><br><br>
  <label>民族:</label>
  <input type="text" name="nation" value="<%= rs.getString("nation") %>"><br><br>
  <label>电话:</label>
  <input type="text" name="telephone" value="<%= rs.getString("telephone") %>"><br><br>
  <label>出生年月:</label>
  <input type="date" name="birthday" value="<%= rs.getString("birthday") %>"><br><br>
  <label>地址:</label>
  <input type="text" name="address" value="<%= rs.getString("address") %>"><br><br>
  <label>照片:</label>
  <input type="text" name="photo" value="<%= rs.getString("photo") %>"><br><br>
  <label>个人简介:</label>
  <textarea name="resume"><%= rs.getString("resume") %></textarea><br><br>
  <input type="submit" value="更新">
</form>
<%
    }
    rs.close();
    pstmt.close();
    conn.close();
  } catch (Exception e) {
    e.printStackTrace();
  }
%>
<a href="home.jsp">返回主页</a>
</body>
</html>