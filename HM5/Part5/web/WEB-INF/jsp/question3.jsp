<%--
  Created by IntelliJ IDEA.
  User: Xie
  Date: 3/4/2019
  Time: 22:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Question 3</title>
</head>
<body>
<h2>Question 3: Which interface contain servlet life-cycle methods?</h2>
<form:form action="question.htm" method="post" commandName="quiz" >
    <%--<input type="radio" name="answer3" value="A">HttpServlet<br/>--%>
    <%--<input type="radio" name="answer3" value="B">GenericServlet<br/>--%>
    <%--<input type="radio" name="answer3" value="C">Service<br/>--%>
    <%--<input type="radio" name="answer3" value="D">Servlet<br/>--%>
    <form:radiobutton path="answer3" value="A"/>HttpServlet<br/>
    <form:radiobutton path="answer3" value="B"/>GenericServlet<br/>
    <form:radiobutton path="answer3" value="C"/>Service<br/>
    <form:radiobutton path="answer3" value="D"/>Servlet<br/>
    <input type="hidden" name="correctAnswer3" value="D"/>

    <form:errors path="answer3" cssStyle="color: red;"/><br/>

    <input type="submit" value="Previous" name="_target2"/>
    <input type="submit" value="Next" name="_target4"/>
    <input type="submit" value="Cancel" name="_cancel"/>

</form:form>
</body>
</html>
