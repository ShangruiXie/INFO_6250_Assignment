<%--
  Created by IntelliJ IDEA.
  User: Xie
  Date: 2/6/2019
  Time: 01:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book List</title>
</head>
<body>
    <%
        int num = Integer.parseInt(request.getParameter("num"));
    %>
    <%--<input type="hidden" name="num" value="<%=num%>">--%>
    <form method="post" action="AddServlet">
        <table border="1" style="margin: 5px">
            <tr>
                <th>ISBN</th>
                <th>Book Title</th>
                <th>Author</th>
                <th>Price</th>
            </tr>
            <%
                for(int i=0; i< num; i++){

            %>
            <tr>
                <td><input type="text" name="ISBN"></td>
                <td><input type="text" name="title"></td>
                <td><input type="text" name="author"></td>
                <td><input type="text" name="price"></td>
            </tr>
            <%
                }
            %>
            <tr><td colspan="4" style="text-align: center"><button type="submit">Add Books</button></td></tr>
        </table>
    </form>
</body>
</html>
