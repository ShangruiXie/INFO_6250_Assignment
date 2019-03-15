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
    <title>Question 1</title>
</head>
<body>

<h2>Question 1: Which life cycle method is  called  once in servlet life?</h2>
<form:form action="question.htm" method="post" commandName="quiz" >
    <%--<input type="radio" name="answer1" value="A">class loading<br/>--%>
    <%--<input type="radio" name="answer1" value="B">init()<br/>--%>
    <%--<input type="radio" name="answer1" value="C">service()<br/>--%>
    <%--<input type="radio" name="answer1" value="D">destroy<br/>--%>
    <input type="hidden" name="correctAnswer1" value="B"/>

    <form:radiobutton path="answer1" value="A" label="class loading"/><br/>
    <form:radiobutton path="answer1" value="B" label="init()"/><br/>
    <form:radiobutton path="answer1" value="C" label="service()"/><br/>
    <form:radiobutton path="answer1" value="D" label="destroy"/><br/>



    <form:errors path="answer1" cssStyle="color: red"/><br/>

    <input type="submit" value="Next" name="_target1"/>
    <input type="submit" value="Cancel" name="_cancel"/>

</form:form>
</body>
</html>
