<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><c:out value="${ language.name }" /></title>
</head>
<body>
	<a href="/languages" class="nav">Dashboard</a>
	<p><c:out value="${ language.name }" /></p>
	<p><c:out value="${ language.creator }" /></p>
	<p><c:out value="${ language.currentVersion }" /></p>
	<p><a href="/languages/edit/${ language.id }">Edit</a></p>
	<p><a href="/languages/delete/${ language.id }">Delete</a></p>
	
</body>
</html>