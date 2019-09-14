<%@include file="common/header.jspf" %>
<%@include file="common/navigation.jspf" %>
		<div class="container">
	
			<h1>Add your new Todo</h1>
			
			<form:form method="post" commandName="todoItem">
				<form:hidden path="id"/>
				
				<fieldset class="form-group"> 
					<form:label path="desc">Description: </form:label>
					<form:input path="desc" class="form-control" type="text" required="required"></form:input>
				</fieldset>
				
				<fieldset class="form-group"> 
					<form:label path="targetDate">Target Date: </form:label>
					<form:input path="targetDate" class="form-control" type="text" required="required"></form:input>
				</fieldset>
				
				<form:errors path="desc" cssClass="text-warning"/><br>
				<button class="btn btn-success" type="submit">Submit</button>
				<a class="btn btn-danger" href="/todos" >Cancel</a>
				
			</form:form>
		
		</div>
<%@ include file="common/footer.jspf" %>	