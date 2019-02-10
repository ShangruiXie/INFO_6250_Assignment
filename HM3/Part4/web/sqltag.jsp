<%--
  Created by IntelliJ IDEA.
  User: Xie
  Date: 2/9/2019
  Time: 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>SQL Tags</title>
</head>
<body>

<sql:setDataSource var="db" driver="com.mysql.cj.jdbc.Driver"
                   url="jdbc:mysql://localhost:3306/info_6250?useSSL=false&serverTimezone=UTC"
                   user="root"  password="root"></sql:setDataSource>

<sql:update dataSource="${db}" var="count">
    INSERT INTO movies VALUES ('movieeeeee','actorrrr', 'actreesss', 'genreeeee', 2018);
</sql:update>

<sql:query dataSource="${db}" var="rs">
    SELECT * from movies;
</sql:query>


<c:forEach var="result" items="${rs.rows}">
title:<c:out value="${result.title}"></c:out><br/>
    actor:<c:out value="${result.actor}"></c:out><br/>
</c:forEach>



</body>
</html>
