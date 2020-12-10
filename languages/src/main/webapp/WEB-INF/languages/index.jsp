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
					<td><a href="/languages/edit/${ language.id }">Edit</a> | 
					<form action="/languages/delete/${ language.id }" method="post">
						<input type="hidden" name="_method" value="delete" />
						<input type="submit" value="Delete" />
					</form>
					</td>
				</tr>
			</tbody>
		</c:forEach>
	</table>
	<div class="wrapper">
		<form:form action="/languages/create" method="post" modelAttribute="language">
			<p>
				<form:label path="name">Name:</form:label>
				<form:errors path="name"/>
				<form:input path="name"/>
			</p>
			
			<p>
				<form:label path="creator">Creator:</form:label>
				<form:errors path="creator"/>
				<form:input path="creator"/>
			</p>
			
			<p>
				<form:label path="currentVersion">Current Version:</form:label>
				<form:errors path="currentVersion"/>
				<form:input path="currentVersion"/>
			</p>
			<input type="submit" value="Submit" />
		</form:form>
	</div>
</body>
</html>