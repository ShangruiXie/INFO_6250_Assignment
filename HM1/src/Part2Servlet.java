import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;


//This is Assignment2 part2

//@WebServlet(name = "Part2Servlet")
public class Part2Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        Enumeration<String> headerNames = request.getHeaderNames();
//        Enumeration<String> header = request.getHeaders("accept");

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Part 2</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>Part 2 headers</h2>");

        while(headerNames.hasMoreElements()){
            String name = headerNames.nextElement();
            out.println(name+": ");

            Enumeration<String> header = request.getHeaders(name);
            while(header.hasMoreElements())
                out.println(header.nextElement());
            out.println("<br/>");
        }



        out.println("</BODY>");
        out.println("</HTML>");

    }
}
