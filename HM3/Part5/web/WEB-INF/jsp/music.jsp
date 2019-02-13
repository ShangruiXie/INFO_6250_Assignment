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
        <input type="checkbox" name="product" value="I'm Going to Tell You a Secret by Madonna:26.99">
        <label>I'm Going to Tell You a Secret by Madonna[$26.99]</label><br/>
        <input type="checkbox" name="product" value="Baby One More Time by Britney Spears:10.95">
        <label>Baby One More Time by Britney Spears[$10.95]</label><br/>
        <input type="checkbox" name="product" value="Justified by Justin Timberlake:9.97">
        <label>Justified by Justin Timberlake[$ 9.97]</label><br/>
        <input type="checkbox" name="product" value="Loose by Nelly Furtado:13.98">
        <label>Loose by Nelly Furtado[$13.98]</label><br/>
        <input type="checkbox" name="product" value="Gold Digger by Kanye Went:27.99">
        <label>Gold Digger by Kanye Went[$27.99]</label><br/>
        <button type="submit">Add to Cart</button>
    </form>

</div>
</body>
</html>
