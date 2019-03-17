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
    <title>Question 5</title>
</head>
<body>
<h2>Question 5: Which method does not exists in HttpServlet Class?</h2>
<form:form action="question.htm" method="post" commandName="quiz" >
    <%--<input type="radio" name="answer5" value="A">service<br/>--%>
    <%--<input type="radio" name="answer5" value="B">init<br/>--%>
    <%--<input type="radio" name="answer5" value="C">doGet<br/>--%>
    <%--<input type="radio" name="answer5" value="D">doPost<br/>--%>
    <form:radiobutton path="answer5" value="A"/>service<br/>
    <form:radiobutton path="answer5" value="B"/>init<br/>
    <form:radiobutton path="answer5" value="C"/>doGet<br/>
    <form:radiobutton path="answer5" value="D"/>doPost<br/>
    <input type="hidden" name="correctAnswer5" value="B"/>

    <form:errors path="answer5" cssStyle="color: red;"/><br/>

    <input type="submit" value="Previous" name="_target4"/>
    <input type="submit" value="Submit" name="_finish"/>
    <input type="submit" value="Cancel" name="_cancel"/>

</form:form>
</body>
</html>
