import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/updateStudent")
public class UpdateStudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        // 获取表单数据
        int stuNO = Integer.parseInt(request.getParameter("stuNO"));
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String nation = request.getParameter("nation");
        String telephone = request.getParameter("telephone");
        String birthday = request.getParameter("birthday");
        String address = request.getParameter("address");
        String photo = request.getParameter("photo");
        String resume = request.getParameter("resume");

        try {
            // 加载MySQL驱动
            Class.forName("com.mysql.jdbc.Driver");

            // 创建JDBC连接URL，并指定时区
            String url = "jdbc:mysql://localhost:3306/ssm_test2?useUnicode=true&characterEncoding=UTF8";
            Connection conn = DriverManager.getConnection(url, "root", "zyz1106");

            // 更新学生信息的SQL语句
            String sql = "UPDATE student SET name = ?, sex = ?, nation = ?, telephone = ?, birthday = ?, address = ?, photo = ?, resume = ? WHERE stuNO = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, sex);
            pstmt.setString(3, nation);
            pstmt.setString(4, telephone);
            pstmt.setString(5, birthday);
            pstmt.setString(6, address);
            pstmt.setString(7, photo);
            pstmt.setString(8, resume);
            pstmt.setInt(9, stuNO);

            // 执行更新操作
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("学生信息更新成功，学号：" + stuNO);
            } else {
                System.out.println("学生信息更新失败，未找到学号：" + stuNO);
            }

            // 关闭资源
            pstmt.close();
            conn.close();

            // 更新成功后跳转到主页
            response.sendRedirect(request.getContextPath() + "/home.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            // 返回错误信息给用户
            response.getWriter().println("更新学生信息失败，发生异常：" + e.getMessage());
        }
    }
}