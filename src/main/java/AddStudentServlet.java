import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addStudent")
public class AddStudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置请求和响应的字符编码为UTF-8
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

            // 创建JDBC连接URL，指定时区和字符编码
            String url = "jdbc:mysql://localhost:3306/ssm_test2?useUnicode=true&characterEncoding=UTF-8";
            Connection conn = DriverManager.getConnection(url, "root", "zyz1106");

            // 关闭自动提交
            conn.setAutoCommit(false);

            // 插入学生信息的SQL语句
            String sql = "INSERT INTO student (stuNO, name, sex, nation, telephone, birthday, address, photo, resume) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, stuNO);
            pstmt.setString(2, name);
            pstmt.setString(3, sex);
            pstmt.setString(4, nation);
            pstmt.setString(5, telephone);
            pstmt.setString(6, birthday);
            pstmt.setString(7, address);
            pstmt.setString(8, photo);
            pstmt.setString(9, resume);

            // 执行插入操作
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("学生信息添加成功，学号：" + stuNO);
                // 提交事务
                conn.commit();
            } else {
                System.out.println("学生信息添加失败！");
                // 回滚事务
                conn.rollback();
            }

            // 关闭资源
            pstmt.close();
            conn.close();

            // 添加成功后跳转到主页
            response.sendRedirect(request.getContextPath() + "/home.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            // 返回错误信息给用户
            response.getWriter().println("添加学生信息失败，发生异常：" + e.getMessage());
        }
    }
}