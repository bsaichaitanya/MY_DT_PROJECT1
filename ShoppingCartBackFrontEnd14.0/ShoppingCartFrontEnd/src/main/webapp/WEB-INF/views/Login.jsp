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
.container {
	padding-top:100px;
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


	<div class=container>
	<form:form class="form-responsive" action="login" commandName="userDetails" method="post">

		<div class="panel panel-default" >
		
			<div class="panel-heading" style="padding:35px 50px"> 
		 <h3><span class="glyphicon glyphicon-lock"></span> LOGIN</h3>
			 </div>
			 
			 
			<div class="panel-body" style="padding:40px 50px;">
			
						<div>
					<form:label path="id"><spring:message text="USER ID"></spring:message> </form:label>
					<div style="margin-bottom: 25px" class="input-group">
                                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                                       	<form:input path="id" class="form-control" required="true"  placeholder="PLEASE ENTER YOUR USER ID"  />
                      </div>
					</div>

					<div>
					<form:label path="password"><spring:message text="PASSWORD"></spring:message></form:label>
					<div style="margin-bottom: 25px" class="input-group">
                                        	<span class="input-group-addon"><i class="glyphicon glyphicon-eye-open"></i></span>
                                        	<form:password path="password" class="form-control" placeholder="PLEASE ENTER YOUR PASSWORD" required="true"    />
                                    </div>
						</div>
						
						</div>
						
						<div class="panel-footer">
						<input type="submit" value="Login" class="btn btn-primary btn-block">
						</div>
						
					</div>
					</form:form>	
			</div>
	

</body>
</html>