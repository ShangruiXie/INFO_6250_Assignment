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
    <title>Question 3</title>
</head>
<body>
<h2>Question 3: Which interface contain servlet life-cycle methods?</h2>
<form action="question.htm" method="post">
    <input type="radio" name="answer3" value="A">HttpServlet<br/>
    <input type="radio" name="answer3" value="B">GenericServlet<br/>
    <input type="radio" name="answer3" value="C">Service<br/>
    <input type="radio" name="answer3" value="D">Servlet<br/>
    <input type="hidden" name="correctAnswer3" value="D"/>

    <input type="submit" value="Previous" name="_target1"/>
    <input type="submit" value="Next" name="_target3"/>
    <input type="submit" value="Cancel" name="_cancel"/>

</form>
</body>
</html>
