import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

//@WebServlet(name = "Part4Servlet")
public class Part4Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Part 4</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>Part 4</h2>");


        Enumeration<String> parName = request.getParameterNames();
        while(parName.hasMoreElements()){
            String para = parName.nextElement();
            String[] val = request.getParameterValues(para);
            out.println(para+": ");
            for(int i = 0; i<val.length; i++){
                out.println(val[i]+"  ");
            }
            out.println("<br/>");
        }

        out.println("</body>");
        out.println("</html>");
    }
}
