import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//@WebServlet(name = "CartServlet")
public class CartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String[] itemList = request.getParameterValues("item");
        if(session.getAttribute("items") == null){
            return;
        }else{
            String[] items = (String[]) session.getAttribute("items");
            for(int j=0; j < itemList.length; j++){
                for (int i = 0; i < items.length; i++) {
                    if(itemList[j].equals(items[i])){
                        ArrayList<String> list = new ArrayList<String>(items.length);
                        Collections.addAll(list, items);
                        list.remove(itemList[j]);
                        items = list.toArray(new String[1]);
                    }
                }
            }
            session.setAttribute("items", items);
        }


        response.sendRedirect("./Cart.jsp");
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String[] itemList = request.getParameterValues("item");
        //


        //save to session

        if(session.getAttribute("items") == null){
            session.setAttribute("items", itemList);
        }else{
            String[] items = (String[]) session.getAttribute("items");

            for(int j=0; j < itemList.length; j++) {
                Boolean flag = false;
                for (int i = 0; i < items.length; i++) {
                    if(itemList[j].equals(items[i])){
                        flag = true;
                        break;
                    }
                }
                if(flag == false) {
                    //add by just using Array
                    items = Arrays.copyOf(items, items.length + 1);
                    items[items.length - 1] = itemList[j];

                }
            }
            if(items[0] == null){
                ArrayList<String> list = new ArrayList<String>(items.length);
                Collections.addAll(list, items);
                list.remove(items[0]);
                items = list.toArray(new String[1]);
            }

            session.setAttribute("items", items);
        }


//        PrintWriter out = response.getWriter();
//        String[] items = (String[]) session.getAttribute("items");
//        for(int i=0; i < items.length; i++)
//            out.println(items[i]);

//        response.sendRedirect("./Cart.jsp");
        request.setAttribute("items", itemList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("./addSucc.jsp");
        dispatcher.forward(request, response);

    }
}
