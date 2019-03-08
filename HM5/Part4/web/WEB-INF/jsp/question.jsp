<%--
  Created by IntelliJ IDEA.
  User: Xie
  Date: 3/4/2019
  Time: 22:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Question <c:out value="${requestScope.question.number}" /></title>
</head>
<body>
<h2>Question <c:out value="${requestScope.question.number}"/>: <c:out value="${requestScope.question.question}"/></h2>
<form action="" method="post">
    <input type="radio" name="answer" value="A"><c:out value="${requestScope.question.answer1}"/><br/>
    <input type="radio" name="answer" value="B"><c:out value="${requestScope.question.answer2}"/><br/>
    <input type="radio" name="answer" value="C"><c:out value="${requestScope.question.answer3}"/><br/>
    <input type="radio" name="answer" value="D"><c:out value="${requestScope.question.answer4}"/><br/>
    <input type="hidden" name="qnum" value="${requestScope.question.number}">

    <button type="submit">submit</button>
    <%--<c:if test="${requestScope.question.number != 5}">--%>
        <%--<a href="q${requestScope.question.number + 1}.htm">Next</a>--%>
    <%--</c:if>--%>
    <%--<c:if test="${requestScope.question.number == 5}">--%>
        <%--<a href="qview.htm">Next</a>--%>
    <%--</c:if>--%>

</form>
</body>
</html>
