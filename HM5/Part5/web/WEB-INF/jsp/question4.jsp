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
    <title>Question 4</title>
</head>
<body>
<h2>Question 4: Which tag of DD maps internal name of servlet to public URL pattern?</h2>
<form:form action="question.htm" method="post" commandName="quiz" >
    <%--<input type="radio" name="answer4" value="A">servlet<br/>--%>
    <%--<input type="radio" name="answer4" value="B">servlet-mapping<br/>--%>
    <%--<input type="radio" name="answer4" value="C">web-app<br/>--%>
    <%--<input type="radio" name="answer4" value="D">servlet-mappings<br/>--%>
    <form:radiobutton path="answer4" value="A"/>servlet<br/>
    <form:radiobutton path="answer4" value="B"/>servlet-mapping<br/>
    <form:radiobutton path="answer4" value="C"/>web-app<br/>
    <form:radiobutton path="answer4" value="D"/>servlet-mappings<br/>
    <input type="hidden" name="correctAnswer4" value="D"/>

    <form:errors path="answer4" cssStyle="color: red;"/><br/>

    <input type="submit" value="Previous" name="_target3"/>
    <input type="submit" value="Next" name="_target5"/>
    <input type="submit" value="Cancel" name="_cancel"/>

</form:form>
</body>
</html>
