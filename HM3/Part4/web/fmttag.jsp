<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Xie
  Date: 2/9/2019
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Formatiting tag</title>
</head>
<body>
<h2>fmt:parseNumbeer</h2><br/>
<fmt:parseNumber var="fnum" type="number" value="${requestScope.fnumber}"></fmt:parseNumber>
<c:out value="${fnum}"></c:out><br/>
<fmt:parseNumber var="fnum" type="number" integerOnly="true" value="${requestScope.fnumber}"></fmt:parseNumber>
<c:out value="${fnum}"></c:out><br/>

<h2>fmt:timeZone fmt:formatDate </h2><br/>
<c:set value="<%= new java.util.Date()%>" var="time"></c:set>
<fmt:formatDate value="${time}" type="both" timeStyle="long" dateStyle="long"></fmt:formatDate>

<c:forEach var="zone" items="<%=java.util.TimeZone.getAvailableIDs()%>">
    <p><c:out value="${zone}"></c:out>:
        <fmt:timeZone value="${zone}">
            <fmt:formatDate value="${time}" timeZone="${zn}" type="both"></fmt:formatDate>
            <%--what do "zn" and "type=both" mean?--%>
        </fmt:timeZone>
    </p>
</c:forEach>

<h2>fmt:formatNumber</h2><br/>
<fmt:formatNumber value="${fnumber}" type="currency"></fmt:formatNumber><br/>
<fmt:formatNumber value="${fnumber}" type="number" groupingUsed="true"></fmt:formatNumber><br/>
<fmt:formatNumber value="${fnumber}" type="number" groupingUsed="false"></fmt:formatNumber><br/>
<fmt:formatNumber value="${fnumber}" type="number" maxIntegerDigits="3"></fmt:formatNumber><br/>
<fmt:formatNumber value="${fnumber}" type="number" minIntegerDigits="10"></fmt:formatNumber><br/>
<fmt:formatNumber value="${fnumber}" type="number" maxFractionDigits="3"></fmt:formatNumber><br/>
<fmt:formatNumber value="${fnumber}" type="number" minFractionDigits="10"></fmt:formatNumber><br/>
<fmt:formatNumber value="${fnumber}" type="percent" maxIntegerDigits="3"></fmt:formatNumber><br/>
<fmt:formatNumber value="${fnumber}" type="percent" minFractionDigits="10"></fmt:formatNumber><br/>
<fmt:formatNumber value="${fnumber}" type="number" pattern="###.###$"></fmt:formatNumber>

<h2>fmt:parseDate</h2><br/>
<c:set var="now" value="02-14-2019" />
<c:out value="${now}"></c:out><br/>
<fmt:parseDate value="${now}" var="parsedNow" pattern="MM-dd-yyyy"></fmt:parseDate>
<c:out value="${parsedNow}"></c:out>


<h2>fmt:bundle</h2><br/>
<%--bundle requires ListResourceBundle--%>
<fmt:bundle basename="BundleExample" prefix="animals.">
    <fmt:message key="cat"></fmt:message><br/>
    <fmt:message key="dog"></fmt:message><br/>
    <fmt:message key="bird"></fmt:message><br/>
</fmt:bundle>

<h2>fmt:setTimeZone</h2><br/>
<fmt:formatDate value="${time}" type="both" timeStyle="long" dateStyle="long"></fmt:formatDate><br/>
<fmt:setTimeZone value="GMT-8" />
GMT-8: <fmt:formatDate value="${time}" type="both" timeStyle="long" dateStyle="long"></fmt:formatDate><br/>

<%--<h2>fmt:setBundle</h2><br/>--%>
<%--<fmt:setBundle basename="BundleExample" var="lang">--%>
    <%--<fmt:message key="animals.cat" bundle="${lang}"></fmt:message><br/>--%>
    <%--<fmt:message key="animals.dog" bundle="${lang}"></fmt:message><br/>--%>
    <%--<fmt:message key="animals.bird" bundle="${animal}"></fmt:message><br/>--%>
<%--</fmt:setBundle>--%>
<%--cannot work--%>

<h2>fmt:formatDate</h2><br/>
<fmt:formatDate value="${now}" type="time"></fmt:formatDate><br/>
<fmt:formatDate value="${now}" type="date"></fmt:formatDate><br/>
<fmt:formatDate value="${now}" type="both" dateStyle = "short" timeStyle = "short"></fmt:formatDate><br/>
<fmt:formatDate value="${now}" type="time" dateStyle = "medium" timeStyle = "medium"></fmt:formatDate><br/>
<fmt:formatDate value="${now}" type="time" dateStyle = "long" timeStyle = "long"></fmt:formatDate><br/>
<fmt:formatDate value="${now}" type="time" pattern = "MM-dd-yyyy"></fmt:formatDate><br/>


</body>
</html>
