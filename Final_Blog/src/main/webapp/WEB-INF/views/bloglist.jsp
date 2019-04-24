<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome ${owner.username}</title>
</head>
<body>
<div >
		<a href="/blog/bloglist?user=${owner.username}&page=1">
    		<button>Index</button>
		</a>
		<a href="/blog">
    		<button>Logout</button>
		</a>
</div><br/>

<h1>Welcome to ${blogUsername}'s blog </h1><br/>

	<div>
		<form action="/blog/create" method="get">
			<button type="submit">New Blog</button>
		</form>
	</div><br/>

	<div style="width: 30%; float: left">
		<label>Blog Users</label>
		<ul>
		<c:if test="${not empty users }">
			<c:forEach var="user" items="${users}">
				<li style="list-style: none"><a href="/blog/bloglist?user=${user.username}&page=1">${user.username}</a></li>
			</c:forEach>
		</c:if>
		</ul>
	</div>
	<div style="width: 69%; float: left;">
		<label>${blogUsername}'s Blogs</label>
		<c:if test="${not empty articles}">
			<c:forEach var="article" items="${articles}">
				<table>
					<td>|----<a href="/blog/article?writer=${article.user.username}&title=${article.title}">${article.title}</a></td>
					<td>
						<c:if test="${blogUserId eq sessionScope.userId}">
							<a href="/blog/delete?writer=${article.user.username}&title=${article.title}">
					    		<button>Delete</button>
							</a>
						</c:if>
					</td>
					<td>
						<c:if test="${blogUserId eq sessionScope.userId}">
							<a href="/blog/edit?writer=${article.user.username}&title=${article.title}">
					    		<button>Edit</button>
							</a>
						</c:if>
					</td>
				</table>
				
			</c:forEach>
		</c:if>
		</ul>
	</div>

</body>
</html>