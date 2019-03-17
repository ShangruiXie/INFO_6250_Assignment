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
    <title>Question 2</title>
</head>
<body>
<h2>Question 2: Which of these life-cycle method you can over-ride in your class?</h2>
<form:form action="question.htm" method="post" commandName="quiz">

    <form:radiobutton path="answer2" value="A"/>init()<br/>
    <form:radiobutton path="answer2" value="B"/>service()<br/>
    <form:radiobutton path="answer2" value="C"/>doGet()<br/>
    <form:radiobutton path="answer2" value="D"/>All of these<br/>
    <input type="hidden" name="correctAnswer2" value="D"/>

    <form:errors path="answer2" cssStyle="color: red;"/><br/>


    <input type="submit" value="Previous" name="_target1"/>
    <input type="submit" value="Next" name="_target3"/>
    <input type="submit" value="Cancel" name="_cancel"/>

</form:form>
</body>
</html>
