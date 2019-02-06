<%--
  Created by IntelliJ IDEA.
  User: Xie
  Date: 1/26/2019
  Time: 00:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Assignment 1</title>


  </head>
  <body>
  <form method="get" action="Part2Servlet">
      <input type="submit" value="Part2"><br/>

  </form>
  <%--<form action="Part3.jsp">--%>
      <%--<input type="submit" value="Part3" name="Part3">--%>
  <%--</form>--%>
  <input type="button" name="Part3" onclick="goPart3()" value="Part3"><br/><br/>
  <input type="button" name="Part4" onclick="goPart4()" value="Part4"><br/><br/>
  <input type="button" name="Part5" onclick="goPart5()" value="Part5"><br/><br/>
  <input type="button" name="Part6" onclick="goPart6()" value="Part6"><br/><br/>


  <script>
      function goPart3(){
          window.location.href="Part3.jsp";
      }
      function goPart4(){
          window.location.href="Part4.jsp";
      }
      function goPart5(){
          window.location.href="Part5.jsp";
      }
      function goPart6(){
          window.location.href="Part6.jsp";
      }
  </script>

  </body>
</html>



