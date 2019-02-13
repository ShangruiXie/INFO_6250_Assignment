<%--
  Created by IntelliJ IDEA.
  User: Xie
  Date: 2/9/2019
  Time: 14:57
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
    <h1 id="title">Shop</h1>
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

    </form>

</div>
</body>
</html>
