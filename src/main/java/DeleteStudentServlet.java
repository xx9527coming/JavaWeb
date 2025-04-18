import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deleteStudent")
public class DeleteStudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        handleRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        handleRequest(request, response);
    }

    private void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        int stuNO = Integer.parseInt(request.getParameter("stuNO"));

        try {
            // 加载MySQL驱动
            Class.forName("com.mysql.jdbc.Driver");

            // 创建JDBC连接URL，指定时区和字符编码
            String url = "jdbc:mysql://localhost:3306/ssm_test2?useUnicode=true&characterEncoding=UTF8";
            Connection conn = DriverManager.getConnection(url, "root", "zyz1106");

            // 关闭自动提交
            conn.setAutoCommit(false);

            // 删除学生信息的SQL语句
            String sql = "DELETE FROM student WHERE stuNO = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, stuNO);

            // 执行删除操作
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("学生信息删除成功，学号：" + stuNO);
                // 提交事务
                conn.commit();
            } else {
                System.out.println("学生信息删除失败，学号不存在！");
                // 回滚事务
                conn.rollback();
            }

            // 关闭资源
            pstmt.close();
            conn.close();

            // 删除成功后跳转到主页
            response.sendRedirect(request.getContextPath() + "/home.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            // 返回错误信息给用户
            response.getWriter().println("删除学生信息失败，发生异常：" + e.getMessage());
            response.getWriter().println("SQL: DELETE FROM student WHERE stuNO = " + stuNO);
        }
    }
}