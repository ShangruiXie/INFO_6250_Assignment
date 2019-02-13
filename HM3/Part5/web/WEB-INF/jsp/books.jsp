<%--
  Created by IntelliJ IDEA.
  User: Xie
  Date: 2/13/2019
  Time: 05:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Part 5</title>
    <link rel="stylesheet" type="text/css" href="style/css/style.css">
</head>
<body>
<div id="header">
    <h1 id="title">Shop for Books</h1>
</div>
<div id="nav">
    <li><a href="NavServlet?option=books">Books</a></li>
    <li><a href="NavServlet?option=music">Music</a></li>
    <li><a href="NavServlet?option=computers">Computers</a></li>
</div>
<div id="itemList">
    <div id="viewCart">
        <label>[<a href="NavServlet?option=cart">View Cart</a>]</label>
    </div>

    <form method="get" id="itemForm" action="CartServlet">
        <input type="checkbox" name="product" value="Java Servlet Programming:29.95">
        <label>Java Servlet Programming[$29.95]</label><br/>
        <input type="checkbox" name="product" value="Oracle Database Programming:48.95">
        <label>Oracle Database Programming[$48.95]</label><br/>
        <input type="checkbox" name="product" value="System Analysis and Design With UML:14.95">
        <label>System Analysis and Design With UML[$14.95]</label><br/>
        <input type="checkbox" name="product" value="Object Orient Software Engineer:35.99">
        <label>Object Orient Software Engineer[$35.99]</label><br/>
        <input type="checkbox" name="product" value="JJava Web Services:27.99">
        <label>Java Web Services[$27.99]</label><br/>

        <button type="submit">Add to Cart</button>
    </form>

</div>
</body>
</html>
