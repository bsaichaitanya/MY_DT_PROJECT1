<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Login</title>
<style>

   
}
</style>
</head>
<body>


	<div class=container>
	<form:form class="form-responsive" action="login" commandName="userDetails" method="post">

		<div class="panel panel-default">
		
			<div class="panel-heading">	<span class="glyphicon glyphicon-off"></span>${LoginMsg}</div>
			<div class="panel-body">
			
					<form:label path="id">
						<span class="glyphicon glyphicon-user"></span>
						<spring:message text="USER ID"></spring:message>
					</form:label>
					<form:input path="id" class="form-control" required="true"  placeholder="USER ID" />


					<form:label path="password">
						<span class="glyphicon glyphicon-eye-open"></span>
						<spring:message text="PASSWORD"></spring:message>
					</form:label>
					<form:password path="password" class="form-control"
						placeholder="PASSWORD" required="true" />
						
				<span> </span>
						</div>
						<div class="panel-footer">
						<input type="submit" value="Login" class="btn btn-primary btn-block">
						</div>
						
					</div>
					</form:form>	
			</div>
	
	











</body>
</html>