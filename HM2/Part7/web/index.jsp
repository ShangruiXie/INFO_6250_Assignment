<%--
  Created by IntelliJ IDEA.
  User: Xie
  Date: 2/5/2019
  Time: 00:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Movie Store</title>
  </head>
  <body>
  <h1>Welcome to our Movie Store</h1>
  <label>Please make your selection below</label>
  <form method="get" action="DirectionServlet">
    <select name="selection">
      <option value="Browse">Browse Movies</option>
      <option value="Add">Add New Movie to Database</option>
    </select>
    <button type="submit">Send</button>
  </form>


  </body>
</html>
