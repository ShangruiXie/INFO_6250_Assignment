<%--
  Created by IntelliJ IDEA.
  User: Xie
  Date: 3/4/2019
  Time: 22:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Your score: ${requestScope.score}/5</h1>
<table border="1">
    <tr>
        <td>Your answers</td>
        <c:forEach var="ans" begin="1" end="5" items="${sessionScope.answers}">
            <td><c:out value="${ans}"/></td>
        </c:forEach>
    </tr>
    <tr>
        <td>Correct answers</td>
        <c:forEach var="cor" items="${requestScope.correctAnswers}">
            <td><c:out value="${cor}"/></td>
        </c:forEach>
    </tr>
</table>




</body>
</html>
