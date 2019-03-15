<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Xie
  Date: 2/5/2019
  Time: 00:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add New Movie to Database</title>
</head>
<body>
    <h1>Please enter the details below</h1>
    <%--<form method="post" action="addMovie.htm">--%>
        <%--Movie Title:<input type="text" name="title"><br/>--%>
        <%--Lead Actor:<input type="text" name="actor"><br/>--%>
        <%--Lead Actress:<input type="text" name="actress"><br/>--%>
        <%--Genre:<input type="text" name="genre"><br/>--%>
        <%--Year:<input type="text" name="year"><br/>--%>
        <%--<button type="submit">Add Movie</button>--%>
    <%--</form>--%>
    <form:form method="post" action="addMovie.htm" commandName="movie">
        Movie Title:<form:input path="title" />
        <form:errors path="title" cssStyle="color: red"/><br/>

        Lead Actor:<form:input path="actor"/>
        <form:errors path="actor" cssStyle="color: red"/><br/>

        Lead Actress:<form:input path="actress"/>
        <form:errors path="actress" cssStyle="color: red"/><br/>

        Genre:<form:input path="genre"/>
        <form:errors path="genre" cssStyle="color: red"/><br/>

        Year:<form:input path="year"/>
        <form:errors path="year" cssStyle="color: red"/><br/>

        <button type="submit">Add Movie</button>
    </form:form>
</body>
</html>
