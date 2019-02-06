import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.relique.jdbc.csv.CsvDriver;

//@WebServlet(name = "CsvServlet")
public class CsvServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String csvName = request.getParameter("csv");
        try{
            Class.forName("org.relique.jdbc.csv.CsvDriver");
            Connection conn = DriverManager.getConnection("jdbc:relique:csv:"+
                    "C:\\Users\\KeyboardCat\\Documents\\INFO 6250\\HM2\\Part5\\web\\" );
            Statement stmt = conn.createStatement();
            ResultSet results = stmt.executeQuery("SELECT * FROM "+csvName);

            int columns = results.getMetaData().getColumnCount();

            out.println("<table border=\"1\">");
            out.println("<tr>");
            for(int i=1; i<=columns; i++)
            {
                out.println("<th>");
                out.print(results.getMetaData().getColumnName(i));
                out.println("</th>");
            }
            out.println("</tr>");

            while(results.next())
            {
                out.println("<tr>");
                for(int i=1;i<=columns;i++)
                {
                    out.println("<td>");
                    out.print(results.getString(i));
                    out.println("</td>");
                }
                out.println("</tr>");
            }
            out.println("</table>");

            results.close();
            stmt.close();
            conn.close();
        }catch (Exception e){
            System.out.println(e);
        }



    }
}
