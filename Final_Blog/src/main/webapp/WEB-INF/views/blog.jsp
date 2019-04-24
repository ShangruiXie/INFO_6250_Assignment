<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${article.title}</title>
</head>
<body>
<a href="/blog/bloglist?user=${article.user.username}&page=1">
    		<button>Back</button>
</a>
<h1>${article.title}</h1>
by ${article.user.username}<br/>
--------------------------------------------------------------------------------------------------------------------
<div>
<p>${article.content}</p>

</div>
--------------------------------------------------------------------------------------------------------------------<br/>
${article.date}

<h4>Comments:</h4>
<form action="/blog/comment/add" method="GET" name="commentForm">
<div>
	
		<table>
			<tr>
				<input type="hidden" name="writer" value="${article.user.username}" />
				<input type="hidden" name="title" value="${article.title}" />
				<td><textarea rows="4" cols="50" name="commentContent" placeholder="Write Your Comment Here."></textarea></td>
				<td><label style="color: red;">${message}</label></td>
			</tr>
			<tr>
				<td><button type="submit" >Submit</button></td>
			</tr>
		</table>
	
</div>
</form>
--------------------------------------------------------------------------------------------------------------------<br/>
<table>
	<c:if test="${not empty comments}">
		<c:forEach var="comment" items="${comments}">
			<tr>
				<td style="font-size: 15px">
					<label>Writer: ${comment.user.username }</label><br/>
					<label>${comment.date}</label>
				</td>
				<td>                </td>
				<td style="font-size: 18px">${comment.content}</td>
				<td>
					<c:if test="${sessionScope.userId eq comment.user.userId }">						
					
						<a href="/blog/comment/delete?commentContent=${comment.content}&writer=${article.user.username}&title=${article.title}">
				    		<button>Delete</button>
						</a>
					</c:if>
				</td>
			</tr>
		</c:forEach>
	</c:if>
</table>




</body>
</html>