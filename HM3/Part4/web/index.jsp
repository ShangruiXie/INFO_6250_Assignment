<%--
  Created by IntelliJ IDEA.
  User: Xie
  Date: 2/9/2019
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <title>Part 4</title>
  </head>
  <body>
  <h1>Part 4</h1>
  <form action="displayServlet" method="post">
      <input type="hidden" value="ctag" name="option">
      <button type="submit">ctag</button>
  </form>
  <form action="displayServlet" method="post">
      <input type="hidden" value="fmttag" name="option">
      <button type="submit">fmttag</button>
  </form>
  <form action="displayServlet" method="post">
      <input type="hidden" value="fntag" name="option">
      <button type="submit">fntag</button>
  </form>
  <form action="displayServlet" method="post">
      <input type="hidden" value="sqltag" name="option">
      <button type="submit">sqltag</button>
  </form>
  <form action="displayServlet" method="post">
      <input type="hidden" value="xtag" name="option">
      <button type="submit">xtag</button>
  </form>
  </body>
</html>
