<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Xie
  Date: 2/5/2019
  Time: 00:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search Movies</title>
</head>
<body>
    <h1>Searching Moives</h1>
    <%--<form method="post" action="searchMovie.htm">--%>
        <%--Keyword: <input type="text" name="keyword"><br/>--%>
        <%--<input type="radio" name="searchMethod" value="title">Search By Title<br/>--%>
        <%--<input type="radio" name="searchMethod" value="actor">Search By Actor<br/>--%>
        <%--<input type="radio" name="searchMethod" value="actress">Search By Actress<br/>--%>

        <%--<button type="submit">Search Movies</button>--%>
    <%--</form>--%>
    <form:form method="post" action="searchMovie.htm" commandName="search">
        Keyword: <form:input path="keyword"/>
        <form:errors path="keyword" cssStyle="color: red"/> <br/>

        <form:radiobutton path="searchMethod" value="title" label="Search By Title"/>
        <form:radiobutton path="searchMethod" value="actor" label="Search By Actor"/>
        <form:radiobutton path="searchMethod" value="actress" label="Search By Actress"/>
        <form:errors path="searchMethod" cssStyle="color: red"/>

        <button type="submit">Search Movies</button>
    </form:form>
</body>
</html>
