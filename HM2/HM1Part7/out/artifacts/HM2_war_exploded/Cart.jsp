<%--
  Created by IntelliJ IDEA.
  User: Xie
  Date: 2/4/2019
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript" src="HM2.js"></script>
    <link rel="stylesheet" type="text/css" href="HM2.css">
    <title>HM1 Part7</title>
</head>
<body>
<div id="header">
    <h1 id="tit">Shop</h1>
</div>
<div id="nav">
    <li><a href="javascript:redirectBooks();">Books</a></li>
    <li><a href="javascript:redirectMusic();">Music</a></li>
    <li><a href="javascript:redirectComputers();">Computers</a></li>
</div>
<div id="itemList">
    <div>
        <label>The Following item has been added to your shopping cart successfully</label>
    </div>

    <form method="post" id="itemForm" action="CartServlet">

        <div id="viewCart">
            <button type="submit">Remove</button>
        </div>
        <% String[] items = (String[]) session.getAttribute("items");  %>
        <%
            if(items.length == 0){
               out.println("Your cart is empty");
            }else {
                for (int i = 0; i < items.length; i++) {
                    out.println("<input type=\"checkbox\" name=\"item\" value=\"" + items[i] + "\">");
                    out.println("<label>" + items[i] + "</label>");
                    out.println("<br>");
                }
            }
        %>

    </form>

    <div>
        <label>[<a href="javascript:redirectBooks();">Go to Books Page</a>]</label>
        <label>[<a href="javascript:redirectMusic();">Go to Music Page</a>]</label>
        <label>[<a href="javascript:redirectComputers();">Go to Computers Page</a>]</label>
    </div>

</div>
</body>
<script>
    function redirectBooks() {
        window.location.href = "index.html?type=Books";
    }
    function redirectMusic() {
        window.location.href = "index.html?type=Music";

    }
    function redirectComputers() {
        window.location.href = "index.html?type=Computers";
    }
</script>
</html>
