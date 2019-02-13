<%--
  Created by IntelliJ IDEA.
  User: Xie
  Date: 2/10/2019
  Time: 19:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="style/css/style.css">
    <script type="text/javascript" src="style/js/createList.js"></script>
    <script>
        window.onload = function() {

            let url = window.location.href;
            if (url.indexOf("type") != -1) {
                let start = url.indexOf("type");
                let type = url.substring(start + "type".length+1);
                if(type === "Books"){
                    createBooks();
                }else if(type === "Music"){
                    createMusic();
                }else if(type === "Computers"){
                    createComputers();
                }
            }
        }
    </script>
    <title>HM3 Part5</title>
</head>
<body>
<div id="header">
    <h1 id="tit">Shop</h1>
</div>
<div id="nav">
    <li><a href="javascript:createBooks();">Books</a></li>
    <li><a href="javascript:createMusic();">Music</a></li>
    <li><a href="javascript:createComputers();">Computers</a></li>
</div>
<div id="itemList">
    <div id="viewCart">
        <label>[<a href="javascript:window.location.href='Cart.jsp'">View Cart</a>]</label>
    </div>

    <form method="post" id="itemForm" action="CartServlet">

    </form>

</div>
</body>
</html>
