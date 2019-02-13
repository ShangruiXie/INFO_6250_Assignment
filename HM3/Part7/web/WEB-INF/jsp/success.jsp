<%--
  Created by IntelliJ IDEA.
  User: Xie
  Date: 2/13/2019
  Time: 03:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Part7</title>
</head>
<body>
    <h2><c:out value="${requestScope.addMovies}"></c:out> Movie Added Successfully</h2>
    <a href="index.jsp">Click here to go back to the main page</a>
</body>
</html>
