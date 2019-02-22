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

    <h1>Searching Moives</h1>
    <form method="post" action="searchmovie.htm">
        Keyword: <input type="text" name="keyword"><br/>
        <input type="radio" name="searchMethod" value="title">Search By Title<br/>
        <input type="radio" name="searchMethod" value="actor">Search By Actor<br/>
        <input type="radio" name="searchMethod" value="actress">Search By Actress<br/>

        <button type="submit">Search Movies</button>
    </form>
</body>
</html>
