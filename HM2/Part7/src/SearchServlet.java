import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

//@WebServlet(name = "SearchServlet")
public class SearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String keyword = request.getParameter("keyword");
        String searchMethod = request.getParameter("searchMethod");

        Connection conn = null;
        ResultSet rs = null;
        Statement stmt = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/info_6250?useSSL=false&serverTimezone=UTC", "root","root");
            stmt = conn.createStatement();

            String sql = "SELECT title, actor, actress, genre, year FROM movies WHERE " + searchMethod + " = '" + keyword +"';";

            System.out.print(sql);

            rs = stmt.executeQuery(sql);



            out.println("You searched for \""+keyword+"\"");
            out.println("<br/>");
            out.println("<U><B>Here are the search results</B></U>");
            out.println("<br/>");
            while (rs.next()) {
                out.println("<B>Movie Title: </B>"+ rs.getString("title"));
                out.println("<br/>");
                out.println("<B>Lead Actor: </B>" + rs.getString("actor"));
                out.println("<br/>");
                out.println("<B>Lead Actress: </B>" + rs.getString("actress"));
                out.println("<br/>");
                out.println("<B>Genre: </B>" + rs.getString("genre"));
                out.println("<br/>");
                out.println("<B>Year: </B>" + rs.getInt("year"));
                out.println("<br/>");
            }





        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException" + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("SQLException" + ex.getMessage());
        }finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println("SQLException" + ex.getMessage());
            }
        }


        out.println("<a href=\"javascript:window.location.href='index.jsp'\">Click here to go back to the main page</a>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
