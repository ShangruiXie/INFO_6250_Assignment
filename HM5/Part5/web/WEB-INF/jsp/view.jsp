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

<h1>Your score: <c:out value="${requestScope.score}"/>/5</h1>
<table border="1">
    <tr>
        <td>Your answers</td>
        <td><c:out value="${result.answer1}"/></td>
        <td><c:out value="${result.answer2}"/></td>
        <td><c:out value="${result.answer3}"/></td>
        <td><c:out value="${result.answer4}"/></td>
        <td><c:out value="${result.answer5}"/></td>

    </tr>
    <tr>
        <td>Correct answers</td>
        <td><c:out value="${result.correctAnswer1}"/></td>
        <td><c:out value="${result.correctAnswer2}"/></td>
        <td><c:out value="${result.correctAnswer3}"/></td>
        <td><c:out value="${result.correctAnswer4}"/></td>
        <td><c:out value="${result.correctAnswer5}"/></td>

    </tr>
</table>

<a href="question.htm">Return</a>




</body>
</html>
