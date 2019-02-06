import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

//@WebServlet(name = "Part5Servlet")
public class Part5Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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

        Map<String, String[]> parName = request.getParameterMap();


        for(Map.Entry<String, String[]> entry: parName.entrySet()){

            out.println(entry.getKey()+": ");
            for(int i = 0; i<entry.getValue().length; i++){
                out.println(entry.getValue()[i]+"  ");
            }
            out.println("<br/>");
        }

        out.println("</body>");
        out.println("</html>");
    }
}
