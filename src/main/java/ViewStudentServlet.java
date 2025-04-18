
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

@WebServlet("/viewStudent")
public class ViewStudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int stuNO = Integer.parseInt(request.getParameter("stuNO"));

        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/ssm_test2?useUnicode=true&characterEncoding=UTF8";

            // 使用 try-with-resources 自动关闭 Connection, PreparedStatement 和 ResultSet
            try (Connection conn = DriverManager.getConnection(url, "root", "zyz1106");
                 PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM student WHERE stuNO = ?");
                 ResultSet rs = pstmt.executeQuery()) {

                pstmt.setInt(1, stuNO);

                if (rs.next()) {
                    request.setAttribute("stuNO", rs.getInt("stuNO"));
                    request.setAttribute("name", rs.getString("name"));
                    request.setAttribute("sex", rs.getString("sex"));
                    request.setAttribute("nation", rs.getString("nation"));
                    request.setAttribute("telephone", rs.getString("telephone"));
                    request.setAttribute("birthday", rs.getString("birthday"));
                    request.setAttribute("address", rs.getString("address"));
                    request.setAttribute("photo", rs.getString("photo"));
                    request.setAttribute("resume", rs.getString("resume"));
                }
            }

            request.getRequestDispatcher("viewAllStudent.jsp").forward(request, response); // 跳转到查看学生信息页面
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}