<%--
  Created by IntelliJ IDEA.
  User: Xie
  Date: 2/9/2019
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
    <title>Function Tags</title>
</head>
<body>
<h2>fn:contains</h2>
<c:set var="name" value="${name}"></c:set>
<c:if test="${fn:contains(name, 'String')}">
    <c:out value="${name}"></c:out>
</c:if>
<c:if test="${fn:contains(name, 'string')}">
    <c:out value="${name}"></c:out>
</c:if>

<h2>fn:containsIgnoreCase</h2>
<c:if test="${fn:containsIgnoreCase(name, 'String')}">
    <c:out value="${name}"></c:out><br/>
</c:if>
<c:if test="${fn:containsIgnoreCase(name, 'string')}">
    <c:out value="${name}"></c:out>
</c:if>

<h2>fn:fn:endsWith</h2>
<c:if test="${fn:endsWith(name, 'String')}">
    <c:out value="${name}"></c:out><br/>
</c:if>
<c:if test="${fn:endsWith(name, 'string')}">
    <c:out value="${name}"></c:out>
</c:if>

<h2>fn:fn:escapeXml</h2>
<c:set var="escString" value="<abc>Thie is a String</abc>"/>
${fn:escapeXml(escString)}<br/>
${escString}<br/>

<h2>fn:indexOf</h2>
${fn:indexOf(name, "String")}

<h2>fn:trim</h2>
<c:set var="str1" value="This is      a       String     !!!!!"/>
${fn:trim(str1)}

<h2>fn:startsWith</h2>
<c:if test="${fn:startsWith(name, 'This')}">
    <c:out value="${name}"></c:out><br/>
</c:if>
<c:if test="${fn:startsWith(name, 'This')}">
    <c:out value="${name}"></c:out>
</c:if>

<h2>fn:split</h2>
${name}<br/>
<c:set var="name1" value="${fn:split(name, ' ')}" />
<c:set var="name2" value="${fn:join(name1, '-')}" />
${name2}

<h2>fn:toLowerCase</h2>
${fn:toLowerCase(name)}

<h2>fn:toUpperCase</h2>
${fn:toUpperCase(name)}

<h2>fn:substring</h2>
${fn:substring(name, 3, 7)}

<h2>fn:substringAfter</h2>
${fn:substringAfter(name, "a")}

<h2>fn:substringBefore</h2>
${fn:substringBefore(name, "a")}

<h2>fn:length</h2>
${fn:length(name)}

<h2>fn:replace</h2>
${fn:replace(name, "a", "three")}

</body>
</html>
