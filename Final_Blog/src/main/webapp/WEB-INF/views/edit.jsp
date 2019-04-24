<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${article.title }</title>
</head>
<body>
	<a href="/blog/bloglist?user=${sessionScope.username}&page=1">
	    		<button>Back</button>
	</a>
	<form action="/blog/edit" method="post">
		

		<input type="hidden" value="${article.articleId }" name="articleId"/>

		<table>
			<tr>
				<td>Title : </td>
				<td>
					<input type="text" name="title" value="${article.title}"/>
					
					
					
				</td>
			</tr>
			<tr>
				<td>Content : </td>
				<td>
					<textarea rows="4" cols="50" name="content" placeholder="Write Your Blog here." >${article.content}</textarea>
				</td>
			</tr>
			<tr>
				<td></td>
				<td><button type="submit">Submit</button><label style="color: red">${message }</label></td>
			</tr>
		</table>
	</form>
</body>
</html>