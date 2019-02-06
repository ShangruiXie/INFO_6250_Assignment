import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

//@WebServlet(name = "XlsServlet")
public class XlsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String xlsName = request.getParameter("xls");

        InputStream is = new FileInputStream(
                "C:\\Users\\KeyboardCat\\Documents\\INFO 6250\\HM2\\Part6\\web\\"+xlsName+".xls");
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);

        out.println("<table border=\"1\">");
        for(int i=0; i< hssfWorkbook.getNumberOfSheets(); i++){
            HSSFSheet sheetAt = hssfWorkbook.getSheetAt(i);

            out.println("<tr>");
            HSSFRow title = sheetAt.getRow(0);
            for(int k=0; k< title.getLastCellNum(); k++){
                out.println("<th>");
                out.println(title.getCell(k));
                out.println("</th>");
            }
            out.println("</tr>");

            for(int j=1; j< sheetAt.getLastRowNum(); j++){
                HSSFRow row = sheetAt.getRow(j);
                out.println("<tr>");
                for(int k=0; k< row.getLastCellNum(); k++){
                    out.println("<td>");
                    out.println(row.getCell(k));
                    out.println("</td>");
                }
                out.println("</tr>");
            }
        }
        out.println("</table>");

    }
}
