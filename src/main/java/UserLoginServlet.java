import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class UserLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            // 加载MySQL驱动
            Class.forName("com.mysql.jdbc.Driver");

            // 创建JDBC连接URL，并指定时区
            String url = "jdbc:mysql://localhost:3306/ssm_test2";
            Connection conn = DriverManager.getConnection(url, "root", "zyz1106");

            // 查询用户数据的SQL语句
            String sql = "SELECT * FROM user WHERE username = ? AND password = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            // 执行查询
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                // 登录成功，创建Session并跳转到主页
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                System.out.println("用户 " + username + " 登录成功，跳转到主页...");
                response.sendRedirect(request.getContextPath() + "/home.jsp");
            } else {
                // 登录失败，返回登录页面并显示错误
                System.out.println("用户 " + username + " 登录失败，用户名或密码错误！");
                response.sendRedirect(request.getContextPath() + "/login.jsp?error=1");
            }

            // 关闭资源
            rs.close();
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            // 返回错误信息给用户
            response.getWriter().println("error：" + e.getMessage());
        }
    }
}