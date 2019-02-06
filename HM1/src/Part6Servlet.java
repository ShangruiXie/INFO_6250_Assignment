import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

//@WebServlet(name = "Part6Servlet")
public class Part6Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Part 5</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>Part 5</h2>");

        out.println("Your children's names are: <br/>");
        Map<String, String[]> parName = request.getParameterMap();


        for(Map.Entry<String, String[]> entry: parName.entrySet()){
            if(entry.getKey().equals("submit"))
                break;
//            out.println(entry.getKey()+": ");
            for(int i = 0; i<entry.getValue().length; i++){
                out.println(entry.getValue()[i]+"  ");

            }
            out.println("<br/><br/>");
        }

        out.println("</body>");
        out.println("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Part 5</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>Part 5</h2>");

        out.println("<form method ='post' action = 'Part6Servlet' >");

        int childNum = Integer.parseInt(request.getParameter("childNum"));
        for(int i=1; i<=childNum; i++){
            out.println("Please enter the name of child number "+ i +":");
            out.println("<br/>");
            out.println("<input type='text' name='child"+i+"'>");
            out.println("<br/>");
        }


        out.println("<input type='submit' name='submit' value='submit'>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }
}
