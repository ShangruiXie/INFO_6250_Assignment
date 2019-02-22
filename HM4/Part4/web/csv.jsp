
<%--
  Created by IntelliJ IDEA.
  User: Xie
  Date: 2/22/2019
  Time: 01:52
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="csvtag" uri="http://csvtag.com" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Part4</title>
</head>
<body>

<h1>INFO 6250 students are able to see the csv file</h1>

<% if(request.isUserInRole("manager-script")){ %>
    <csvtag:display >
        SalesOrder
    </csvtag:display>
<% } %>
</body>
</html>
