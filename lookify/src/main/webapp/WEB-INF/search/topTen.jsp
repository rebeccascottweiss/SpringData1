<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search</title>
</head>
<body>
	<p>Top Ten Songs:  <a href="/dashboard">Dashboard</a></p>
	<div class="wrapper">
		<c:forEach items="${ songs }" var="song">
			<p>${ song.rating }- <a href="/songs/${ song.id }">${ song.title }</a> - ${ song.artist }</p>
		</c:forEach>
	</div>
</body>
</html>