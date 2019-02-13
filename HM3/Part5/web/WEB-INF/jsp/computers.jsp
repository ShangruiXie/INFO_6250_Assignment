<%--
  Created by IntelliJ IDEA.
  User: Xie
  Date: 2/13/2019
  Time: 05:47
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
        <input type="checkbox" name="product" value="Apple Macbook Pro with 13.3' Display:1299.99">
        <label>Apple Macbook Pro with 13.3' Display[$1299.99]</label><br/>
        <input type="checkbox" name="product" value="Asus Laptop with Centrmo 2 Black:949.95">
        <label>Asus Laptop with Centrmo 2 Black[$949.95]</label><br/>
        <input type="checkbox" name="product" value="HP Pavlion Laptop with Centrmo 2 DV7:1199.95">
        <label>HP Pavlion Laptop with Centrmo 2 DV7[$1199.95]</label><br/>
        <input type="checkbox" name="product" value="Toshiba Satellite Laptop with Centrmo 2 -Copper:899.99">
        <label>Toshiba Satellite Laptop with Centrmo 2 -Copper[$899.99]</label><br/>
        <input type="checkbox" name="product" value="Sony VALO Laptop Cosmopolitan Pink:779.99">
        <label>Sony VALO Laptop Cosmopolitan Pink[$779.99]</label><br/>
        <button type="submit">Add to Cart</button>
    </form>

</div>
</body>
</html>
