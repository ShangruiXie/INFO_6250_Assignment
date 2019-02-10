import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet(name = "displayServlet")
public class displayServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = "This is a String";
        int number = 999;
        double fnumber = 123000.000456;
        String[] list = {"a", "bb", "ccc", "dddd", "eeeee"};
        request.setAttribute("name", name);
        request.setAttribute("number", number);
        request.setAttribute("list", list);
        request.setAttribute("fnumber", fnumber);

        String option = request.getParameter("option");
        if(option.equals("ctag")) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("./ctag.jsp");
            dispatcher.forward(request, response);
        }else if(option.equals("fmttag")){
            RequestDispatcher dispatcher = request.getRequestDispatcher("./fmttag.jsp");
            dispatcher.forward(request, response);
        }else if(option.equals("fntag")){
            RequestDispatcher dispatcher = request.getRequestDispatcher("./fntag.jsp");
            dispatcher.forward(request, response);
        }else if(option.equals("sqltag")){
            RequestDispatcher dispatcher = request.getRequestDispatcher("./sqltag.jsp");
            dispatcher.forward(request, response);
        }else if(option.equals("xtag")){
            RequestDispatcher dispatcher = request.getRequestDispatcher("./xtag.jsp");
            dispatcher.forward(request, response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
