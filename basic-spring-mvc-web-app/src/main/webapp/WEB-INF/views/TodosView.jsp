<%@include file="common/header.jspf" %>
<%@include file="common/navigation.jspf" %>

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
				<td><fmt:formatDate pattern="dd/MM/yyyy" value="${todoitem.targetDate }"/></td>
				<td> ${todoitem.done }</td>
				<td>
					<a class="btn btn-success" href="/updatetodo?id=${todoitem.id }">Update</a>
					<a class="btn btn-danger" href="/deletetodo?id=${todoitem.id }">Delete</a>
				</td>
		
			</tr>	
			</j:forEach>
		</tbody>
	</table>
		

		
	<a class="btn btn-success" href="/addtodo">Add new</a>
	
</div>	

<%@ include file="common/footer.jspf" %>	
		