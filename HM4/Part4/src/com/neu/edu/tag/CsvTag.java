package com.neu.edu.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CsvTag extends SimpleTagSupport {
    private String filename;

    public void setFilename(String filename) {
        this.filename = filename;
    }
    StringWriter sw = new StringWriter();

    public void doTag() throws JspException, IOException {
        if(filename != null){
            printCSV(filename);
        }else {
            getJspBody().invoke(sw);
            printCSV(sw.toString());

        }
    }

    public void printCSV(String filename){
        JspWriter out = getJspContext().getOut();
        try{
            Class.forName("org.relique.jdbc.csv.CsvDriver");
            Connection conn = DriverManager.getConnection("jdbc:relique:csv:"+
                    "C:\\Users\\KeyboardCat\\Documents\\INFO 6250\\INFO_6250_Assignment\\HM4\\Part4\\web" );
            Statement stmt = conn.createStatement();
            ResultSet results = stmt.executeQuery("SELECT * FROM "+filename);

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
