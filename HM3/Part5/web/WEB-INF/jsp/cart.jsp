<%--
  Created by IntelliJ IDEA.
  User: Xie
  Date: 2/13/2019
  Time: 06:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Part 5</title>
    <link rel="stylesheet" type="text/css" href="style/css/style.css">
</head>
<body>
<div id="header">
    <h1 id="title">Cart</h1>
</div>
<div id="nav">
    <li><a href="NavServlet?option=books">Books</a></li>
    <li><a href="NavServlet?option=music">Music</a></li>
    <li><a href="NavServlet?option=computers">Computers</a></li>
</div>
<div id="itemList">
    <form method="post" id="itemForm" action="CartServlet">
    <div id="viewCart">
       <button type="submit">Remove</button>
    </div>
        <c:if test="${sessionScope.cartProducts == null}">
        <label>Your cart is empty</label>
        </c:if>

        <c:forEach var="product" items="${sessionScope.cartProducts}">
            <input type="checkbox" name="item" value="${product.getProductName()}:${product.getPrice()}">
            <label><c:out value="${product.getProductName()}"></c:out>
                [$<c:out value="${product.getPrice()}"></c:out>]</label><br/>
        </c:forEach>
    </form>
    <div>
        <label>[<a href="NavServlet?option=books">Go to Books Page</a>]</label>
        <label>[<a href="NavServlet?option=music">Go to Music Page</a>]</label>
        <label>[<a href="NavServlet?option=computers">Go to Computers Page</a>]</label>
    </div>

</div>
</body>
</html>
