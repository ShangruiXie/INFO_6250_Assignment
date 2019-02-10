<%--
  Created by IntelliJ IDEA.
  User: Xie
  Date: 2/9/2019
  Time: 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<html>
<head>
    <title>XML tags</title>
</head>
<body>

<c:set var="animals">
    <animals>
        <animal>
            <name>cat</name>
            <price>200</price>
        </animal>
        <animal>
            <name>dog</name>
            <price>100</price>
        </animal>
        <animal>
            <name>bird</name>
            <price>50</price>
        </animal>
    </animals>
</c:set>

<h2>x:out</h2>
<x:parse xml="${animals}" var="output"></x:parse>
<b>Name of the animal is</b>:
<x:out select="$output/animals/animal[1]/name"></x:out><br>
<b>Price of the dog is</b>:
<x:out select="$output/animals/animal[2]/price"></x:out>

<h2>x:parse</h2>
<c:import var="bookInfo" url="novel.xml"/>
<x:parse xml="${bookInfo}" var="output"></x:parse>
<x:out select="$output/books/book[1]/name"></x:out>

<h2>x:set</h2>
<x:parse xml="${animals}" var="output"></x:parse>
<x:set var="price" select="$output//animal/price"></x:set>
<x:out select="$price"></x:out>

<h2>x:choose x:when x:otherwise</h2>
<x:parse xml="${animals}" var="output"></x:parse>
<x:choose>
    <x:when select="$output//animal/name = 'cat'">
        cat
    </x:when>
    <x:when select="$output//animal/name = 'dog'">
        dog
    </x:when>
    <x:otherwise>
        unknown
    </x:otherwise>
</x:choose>


<h2>x:if</h2>
<x:if select="$output/animals/animal[2]/price < 500">
    price is lower than 500
</x:if>






</body>
</html>
