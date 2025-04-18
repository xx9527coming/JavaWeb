import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class UserRegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String tel = request.getParameter("tel");
        String email = request.getParameter("email");

        try {
            // 加载MySQL驱动
            Class.forName("com.mysql.jdbc.Driver");

            // 创建JDBC连接URL，并指定时区
            String url = "jdbc:mysql://localhost:3306/ssm_test2?useUnicode=true&characterEncoding=UTF8";
            Connection conn = DriverManager.getConnection(url, "root", "zyz1106");

            // 插入用户数据的SQL语句
            String sql = "INSERT INTO user(username, password, tel, email) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setString(3, tel);
            pstmt.setString(4, email);

            // 执行SQL语句
            pstmt.executeUpdate();

            // 关闭资源
            pstmt.close();
            conn.close();

            // 注册成功后跳转到登录页面
            response.sendRedirect("login.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("error：" + e.getMessage());
        }
    }
}