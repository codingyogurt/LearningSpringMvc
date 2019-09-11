<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
	<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
	<meta charset="UTF-8">
	<title>ADD TODO</title>
</head>
	<body>
		<div class="container">
	
			<h1>Add your new Todo</h1>
			
			<form:form method="post" commandName="todoItem">
				<form:hidden path="id"/>
				<fieldset class="form-group"> 
					<form:label path="desc">Description: </form:label>
					<form:input path="desc" class="form-control" type="text" required="required"></form:input>
				</fieldset>
				<form:errors path="desc" cssClass="text-warning"/><br>
				<button class="btn btn-success" type="submit">Submit</button>
				<a class="btn btn-danger" href="/todos" >Cancel</a>
				
			</form:form>
		
		</div>
		
		<script src="webjars/jquery/1.9.1/jquery.min.js"></script>	
	    <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	</body>
</html>