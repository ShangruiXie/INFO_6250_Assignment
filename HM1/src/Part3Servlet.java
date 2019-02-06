/*
File upload reference:
https://www.tutorialspoint.com/servlets/servlets-file-uploading.htm
http://www.runoob.com/jsp/jsp-file-uploading.html

Because of enctype="multipart/form-data", the normal input type, like the textfield input, cannot be recognised by "request.parameter",
"getFieldName()" to get input name and "item.getString()" to get input value are available.

All annotations are the normal ways to get parameter from jsp.

*/


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.output.*;


//@WebServlet(name = "Part3Servlet")
public class Part3Servlet extends HttpServlet {


    private String uploadPath;
    private int maxFileSize = 1024 * 1024 * 40;
    private int maxMemSize = 1024 * 1024 * 3;

    public void init( ){
        // Get the file location where it would be stored.
        uploadPath = getServletContext().getRealPath("/") + File.separator + "upload"; //file store path
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();



//        String email = request.getParameter("email");
//        String password = request.getParameter("password");
//        String confPass = request.getParameter("confPass");
//        String gender = request.getParameter("gender");
//        String country = request.getParameter("country");
//        String hobby[] = request.getParameterValues("hobby");
//        String address = request.getParameter("address");


        out.println("<html>");
        out.println("<head>");
        out.println("<title>Part 3</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>Part 3</h2>");

//
//        out.println("Email: " +email +"<br/>");
//        out.println("Password: " +password+"<br/>");
//        out.println("Confirm Password: " +confPass+"<br/>");



        // Check that we have a file upload request
        if(!ServletFileUpload.isMultipartContent(request)){
            out.println("Picture: file error <br/>" );
        }else{
            DiskFileItemFactory factory = new DiskFileItemFactory();
            factory.setSizeThreshold(maxMemSize);//max size file stored in memory
            factory.setRepository(new File(System.getProperty("java.io.tmpdir"))); //if data is larger than max memory size, it will store in "temp"
            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setSizeMax(maxFileSize); //maximum file size

            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir(); //if direction is no exist, create a new direction
            }


            try {
                List<FileItem> formItems = upload.parseRequest(request);//get file data

                if (formItems != null && formItems.size() > 0) {
                    for (FileItem item : formItems) {
                        if (!item.isFormField()) { //if it is file-type input
                            String fileName = new File(item.getName()).getName();
                            String filePath = uploadPath + File.separator + fileName; //File.separator is same as '//'
                            File storeFile = new File(filePath);

                            System.out.println(filePath);

                            item.write(storeFile);
                            out.println("Picture Filename: " + fileName + "<br>");
                        }
                        else { //if it is a normal input
                            String inputName = item.getFieldName();
                            String inputValue = item.getString();
                            out.println(inputName+ ": " +inputValue+"<br/>");
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e);
            }
        }





//        out.println("Gender: " +gender+"<br/>");
//        out.println("Country: " +country+"<br/>");
//
//        out.println("Hobby: ");
//        for(int i=0; i<hobby.length;i++){
//            out.println(hobby[i]+", ");
//        }
//        out.println("<br/>");
//
//        out.println("Address: " +address+"<br/>");

        out.println("</body>");
        out.println("</html>");


    }
}
