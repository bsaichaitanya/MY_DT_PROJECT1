<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Registration</title>
</head>
<body>




	<div class="container">
	<form:form action="register" method="post" commandName="userDetails">
		
		<div class="panel panel-default">
		
			<div class="panel-heading">	<span class="glyphicon glyphicon-off"></span>${RegisterMsg}</div>
			<div class="panel-body">
			
					
					<form:input path="id" class="form-control" required="true"  placeholder="USER ID"  />
				
						
					<form:input path="name" class="form-control" required="true"  placeholder="USER NAME"  />
					
					<form:input path="contact" class="form-control" required="true" placeholder="CONTACT"   />
					
					<form:input path="mail" class="form-control"  required="true" placeholder="EMAIL"  />
					
					<form:input path="address" class="form-control"  required="true" placeholder="ADDRESS"   />

					<form:password path="password" class="form-control" placeholder="PASSWORD" required="true"    />
						
				
						</div>
						<div class="panel-footer">
						<input type="submit" value="Register" class="btn btn-primary btn-block">
						</div>
						
					</div>
	</form:form>

</div>
</body>
</html>