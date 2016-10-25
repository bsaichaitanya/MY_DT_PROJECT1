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
<style>
.container {
	padding-top:200px;
    padding-right: 270px;
    padding-left: 270px;
}
.panel-default>.panel-heading {
background-color: #2f4357;
      color:white !important;
      text-align: center;
      font-size: 30px;
}
.btn-primary {
    color: #fff;
    background-color:  #2f4357;
    border-color: #2e6da4;

</style>

</head>
<body>




	<div class="container">
	<form:form action="register" method="post" commandName="userDetails">
		
		<div class="panel panel-default">
		
			<div class="panel-heading"  style="padding:35px 50px">	
			<h3><span class="glyphicon glyphicon-lock"></span> REGISTER</h3></div>
			<div class="panel-body">
					
					     
                                <div style="margin-bottom: 25px" class="input-group">
                                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                                       	<form:input path="id" class="form-control" required="true"  placeholder="USER ID"  />
                                    </div>
                                    
                                    <div style="margin-bottom: 25px" class="input-group">
                                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                       <form:input path="name" class="form-control" required="true"  placeholder="USER NAME"  />
                                    </div>
                                    
                                    <div style="margin-bottom: 25px" class="input-group">
                                        <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
                                        	<form:input path="mail" class="form-control"  required="true" placeholder="EMAIL"  />
                                    </div>
                                    
                                    <div style="margin-bottom: 25px" class="input-group">
                                        <span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
                                      	<form:input path="address" class="form-control"  required="true" placeholder="ADDRESS"   />
                                    </div>
                                    
                                     <div style="margin-bottom: 25px" class="input-group">
                                        <span class="input-group-addon"><i class="glyphicon glyphicon-earphone"></i></span>
                                    	<form:input path="contact" class="form-control" required="true" placeholder="CONTACT"   />
                                    </div>
                                    
                                    
                                    <div style="margin-bottom: 25px" class="input-group">
                                        <span class="input-group-addon"><i class="glyphicon glyphicon-eye-open"></i></span>
                                        	<form:password path="password" class="form-control" placeholder="PASSWORD" required="true"    />
                                    </div>
                                    

						
				
						</div>
						<div class="panel-footer">
						<input type="submit" value="Register" class="btn btn-primary btn-block">
						</div>
						
					</div>
	</form:form>

</div>
</body>
</html>