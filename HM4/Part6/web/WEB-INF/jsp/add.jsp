<%--
  Created by IntelliJ IDEA.
  User: Xie
  Date: 2/5/2019
  Time: 00:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add New Movie to Database</title>
</head>
<body>
    <h1>Please enter the details below</h1>
    <form method="post" action="addmovie.htm">
        Movie Title:<input type="text" name="title"><br/>
        Lead Actor:<input type="text" name="actor"><br/>
        Lead Actress:<input type="text" name="actress"><br/>
        Genre:<input type="text" name="genre"><br/>
        Year:<input type="text" name="year"><br/>
        <button type="submit">Add Movie</button>
    </form>
</body>
</html>
