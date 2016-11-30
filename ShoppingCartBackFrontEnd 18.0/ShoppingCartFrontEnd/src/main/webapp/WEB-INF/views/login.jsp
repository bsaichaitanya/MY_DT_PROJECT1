<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ page isELIgnored="false"%>

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

.mypanel {
    height: 100px;
    overflow-y: scroll;
}
</style>
</head>
<body>


	<div class=container>
	        <c:if test="${not empty logout}">
                <div class="error" style="color: #ff0000;">${logout}</div>
            </c:if>
        <form name="loginForm" action="<c:url value="/j_spring_security_check" />" method="post">
         <c:if test="${not empty error}">
                    <div class="error" style="color: #ff0000;">${error}</div>
                </c:if>
		<div class="panel panel-default" >
		
			<div class="panel-heading" style="padding:35px 50px"> 
		 <h3><span class="glyphicon glyphicon-lock"></span> LOGIN</h3>
			 </div>
			 
			 
			<div class="panel-body mypanel" style="padding:40px 50px;">
			
						<div>
					<label><spring:message text="USERNAME"></spring:message> </label>
					<div style="margin-bottom: 25px" class="input-group">
                                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                                       	<input  name="j_username" type="text" class="form-control" required="true"  placeholder="PLEASE ENTER YOUR USER ID"  />
                      </div>
					</div>

					<div>
					<label><spring:message text="PASSWORD"></spring:message></label>
					<div style="margin-bottom: 25px" class="input-group">
                                        	<span class="input-group-addon"><i class="glyphicon glyphicon-eye-open"></i></span>
                                        	<input type="password" name="j_password" class="form-control" placeholder="PLEASE ENTER YOUR PASSWORD" required="true"   />
                                    </div>
						</div>
						
						</div>
						
						<div class="panel-footer">
						<input type="submit" value="Login" class="btn btn-primary btn-block">
						</div>
						
					</div>
					</form>	   
			</div>  

</body>
</html>