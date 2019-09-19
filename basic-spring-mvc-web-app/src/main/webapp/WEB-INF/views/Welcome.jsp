<%@include file="common/header.jspf" %>
<%@include file="common/navigation.jspf" %>

<div class="container">
	<h1>
		<spring:message code="welcome.message"/> ${username}!		 
	</h1>
	<label>Manage your Todos <a href="/todos">here</a></label>
</div>

<%@ include file="common/footer.jspf" %>