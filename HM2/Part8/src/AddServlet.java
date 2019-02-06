import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

//@WebServlet(name = "AddServlet")
public class AddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

//        int num = Integer.parseInt(request.getParameter("num"));
//        System.out.print(num);

        String[] title = request.getParameterValues("title");
        String[] ISBN = request.getParameterValues("ISBN");
        String[] author = request.getParameterValues("author");
        String[] price = request.getParameterValues("price");

        out.println("<h2>"+title.length+" books added successfully</h2>");


        Connection conn = null;
        ResultSet rs = null;
        Statement stmt = null;
        PreparedStatement pstmt = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/info_6250?useSSL=false&serverTimezone=UTC", "root","root");



            String sql = "INSERT INTO books (isbn, title, authors, price) VALUES (?, ?, ?, ?);";
            pstmt = conn.prepareStatement(sql);

            for(int i=0; i<title.length; i++){
                pstmt.setString(1, ISBN[i]);
                pstmt.setString(2, title[i]);
                pstmt.setString(3, author[i]);
                pstmt.setFloat(4, Float.parseFloat(price[i]));
                pstmt.addBatch();
            }
            pstmt.executeBatch();

            out.println("<a href=\"javascript:window.location.href='index.jsp'\">Click here to go back to the main page</a>");
            out.println("<br/>");
            out.println("<br/>");
            out.println("<br/>");


            String selectSQL = "SELECT * FROM books";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(selectSQL);

            out.println("<table border=\"1\">" +
                    "<tr><th>ISBN</th>" +
                    "<th>Book Title</th>" +
                    "<th>Author</th>" +
                    "<th>Price</th></tr>");
            while (rs.next()) {
                out.println("<tr>");
                out.println("<td>"+ rs.getString("isbn")+"</td>");
                out.println("<td>" + rs.getString("title")+"</td>");
                out.println("<td>"+ rs.getString("authors")+"</td>");
                out.println("<td>" + rs.getString("price")+"</td>");
                out.println("</tr>");
            }
            out.println("</table>");
            out.println("<br/>");





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
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println("SQLException" + ex.getMessage());
            }
        }





    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        int num = Integer.parseInt(request.getParameter("num"));

        request.setAttribute("num", num);
        RequestDispatcher dispatcher = request.getRequestDispatcher("./bookList.jsp");
        dispatcher.forward(request, response);

    }
}
