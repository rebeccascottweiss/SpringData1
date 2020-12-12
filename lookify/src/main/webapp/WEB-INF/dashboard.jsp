<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lookify</title>
</head>
<body>
	<div>
		<a href="/songs/new">Add New</a>  
		<a href="/search/topTen">Top Songs</a>   
		<form action="/search" method="post">
			<input type="text" name="search" />
			<input type="submit" value="Search Artists" />
		</form>
	</div>
	<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Rating</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ songs }" var="song">
			<tr>
				<td><a href="/songs/${ song.id }">${ song.title }</a></td>
				<td>${ song.rating }</td>
				<td>
					<form action="/songs/${ song.id }" method="post">
						<input type="hidden" name="_method" value="delete" />
						<input type="submit" value="delete" />
					</form>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>