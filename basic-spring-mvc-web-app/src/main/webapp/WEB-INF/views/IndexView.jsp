<%@include file="common/header.jspf" %>

<form action="/bukasan" method="post">
	<div class="container">
		<h1>Login to Todo Web App</h1>
		<fieldset class="form-group">
			<label>Username</label>
			<input type="text" name="txtUsername"/>
		</fieldset>
		<fieldset class="form-group">
			<label>Password</label>
			<input type="password" name="txtPassword"/>
		</fieldset>
		<label class="text-warning">${indexMessage}</label><br>
		<input class="btn btn-success" type="submit" value="Submit"/>
	</div>
</form>

<%@ include file="common/footer.jspf" %>
