<%--
  Created by IntelliJ IDEA.
  User: Xie
  Date: 2/9/2019
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Core Tag</title>
</head>
<body>

<h2>c:out</h2><br/>
<c:out value="${'This is a c:out string'}"></c:out><br/>
<c:out value="${requestScope.number}"></c:out>

<h2>c:import</h2><br/>
<c:import url="index.jsp" var="data"></c:import>
<c:out value="${data}"></c:out>

<h2>c:set</h2><br/>
request number: <c:out value="${number}"></c:out><br/>
<c:set var="number" scope="request" value="${999*4}"></c:set>
new number: <c:out value="${number}"></c:out><br/>

<h2>c:remove</h2><br/>
<c:remove var="number" scope="request"></c:remove>
request number:<c:out value="${requestScope.number}"></c:out><br/>

<h2>c:catch</h2><br/>
<c:catch var="Exception">
    <% int x = 25/0; %>
</c:catch>
<c:if test="${Exception != null}">
    Catch Exception: ${Exception} <br/>
</c:if>

<h2>c:if</h2><br/>
<c:if test="${number > 5000}">
    number: ${number} <br/>
</c:if>
<c:set var="number" scope="request" value="${5001}"></c:set><br/>
<c:if test="${number > 5000}">
    number: ${number} <br/>
</c:if>

<h2>c:choose c:when c:otherwise</h2><br/>
<c:forEach var="i" begin="1" end="5">
    <c:choose>
        <c:when test="${i <= 2}">
            ${i} < 3 <br/>
        </c:when>
        <c:when test="${i>3}">
            ${i} > 3 <br/>
        </c:when>
        <c:otherwise>
            ${i} == 3 <br/>
        </c:otherwise>
    </c:choose>
</c:forEach>


<h2>c:forEach</h2><br/>
<c:forEach var="list" items="${requestScope.list}">
    <c:out value="${list}"></c:out>
</c:forEach>

<h2>c:forTokens</h2><br/>
<c:forTokens items="${requestScope.list}" delims="," var="lsit">
    <c:out value="${list}"></c:out>
</c:forTokens>

<h2>c:param c:url</h2><br/>
<a href="
<c:url value="index.jsp" var="indexURL">
    <c:param name="username" value="user1"></c:param>
    <c:param name="password" value="****"></c:param>

</c:url>">${indexURL}</a>

<c:import url="${indexURL}"></c:import>


<h2>c:redirect</h2><br/>
<%--<c:redirect url="http://www.google.com"></c:redirect>">--%>




</body>
</html>
