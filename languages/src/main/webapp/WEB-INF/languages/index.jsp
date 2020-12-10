<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Languages</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Creator</th>
				<th>Current Version</th>
				<th>Actions</th>
			</tr>
		</thead>
		<c:forEach items="${ languages }" var="language">
			<tbody>
				<tr>
					<td><a href="/languages/${ language.id }">${ language.name }</a></td>
					<td>${ language.creator }</td>
					<td>${ language.currentVersion }</td>
					<td><a href="/languages/edit/${ language.id }">Edit</a> | <a href="/languages/delete">Delete</a></td>
				</tr>
			</tbody>
		</c:forEach>
	</table>
</body>
</html>