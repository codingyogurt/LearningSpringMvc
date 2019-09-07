<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
<meta charset="UTF-8">
<title>TODOS</title>
</head>
	<body>
		<div class="container">	
			<table class="table table-striped">
				<caption>Your todos ${username }</caption>
				<thead>
					<tr>
						<th>ID</th>
						<th>User</th>
						<th>Description</th>
						<th>Target Date</th>
						<th>is Done?</th>
					<tr>
				</thead>
				<tbody>
					<j:forEach items="${todos }" var="todoitem">
					<tr>
						<td>${todoitem.id } </td>
						<td>${todoitem.user } </td>
						<td>${todoitem.desc }</td>
						<td>${todoitem.targetDate }</td>
						<td> ${todoitem.done }</td>
						<td><a class="btn btn-danger" href="/deletetodo?id=${todoitem.id }">Delete</a></td>
				
					</tr>	
					</j:forEach>
				</tbody>
			</table>
				
	
				
			<a class="btn btn-success" href="/addtodo">Add new</a>
			
		</div>	
		
		<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	    <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	</body>
</html>