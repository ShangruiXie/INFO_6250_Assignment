<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Xie
  Date: 2/13/2019
  Time: 03:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Results</title>
</head>
<body>
    <h2>You searched for <c:out value="${keyword}"></c:out></h2><br/>
    <c:if test="${empty movieList}">
        <U><B>No result</B></U><br/>
    </c:if>
    <c:if test="${not empty movieList}">
    <U><B>Here are the search results</B></U><br/>
    <table border="1">

        <tr>
            <th>Movie Title</th>
            <th>Lead Actor</th>
            <th>Lead Actress</th>
            <th>Genre</th>
            <th>Year</th>
        </tr>

        <tbody>
        <c:forEach var="movie" items="${movieList}">
            <tr>
                <td><c:out value="${movie.getTitle()}"></c:out></td>
                <td><c:out value="${movie.getActor()}"></c:out></td>
                <td><c:out value="${movie.getActress()}"></c:out></td>
                <td><c:out value="${movie.getGenre()}"></c:out></td>
                <td><c:out value="${movie.getYear()}"></c:out></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    </c:if>
    <br/>
    <a href="index.jsp">Click here to go back to the main page</a>
</body>
</html>
