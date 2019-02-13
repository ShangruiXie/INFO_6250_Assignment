<%--
  Created by IntelliJ IDEA.
  User: Xie
  Date: 2/13/2019
  Time: 01:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Part 6</title>
</head>
<body>
<table border="1">
    <tr>
        <th>SalesOrderID</th>
        <th>SalesOrderNumber</th>
        <th>PurchaseOrderNumber</th>
        <th>CustomerID</th>
        <th>SalesPersonID</th>
        <th>TotalDue</th>

    </tr>
    <c:forEach var="order" items="${requestScope.orderList}">
        <tr>
            <td><c:out value="${order.getSalesOrderID()}"></c:out></td>
            <td><c:out value="${order.getSalesOrderNumber()}"></c:out></td>
            <td><c:out value="${order.getPurchaseOrderNumber()}"></c:out></td>
            <td><c:out value="${order.getCustomerID()}"></c:out></td>
            <td><c:out value="${order.getSalesPersonID()}"></c:out></td>
            <td><c:out value="${order.getTotalDue()}"></c:out></td>

        </tr>
    </c:forEach>
</table>
</body>
</html>
