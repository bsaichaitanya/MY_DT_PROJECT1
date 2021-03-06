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
<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css"
	rel="stylesheet">
	<link href="E:\workspace\ShoppingCartFrontEnd\src\main\resources\css" rel="stylesheet">
<title>Registration</title>
<style>
img{
    padding-left: 70px;
    padding-top: 70px;
}

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


	<div >
	<a href="Home" ><img src="<c:url value="${contextPath}/resources/images/buttons/dock_icon_home_button_by_moa_isa_jediknight.png" ></c:url>"
										width="150px" height="150px"></a>
</div>

	<div class="container">
	<form:form modelAttribute="userDetails">
		
		<div class="panel panel-default">
		
			<div class="panel-heading"  style="padding:35px 50px">	
			<h3><span class="glyphicon glyphicon-lock"></span> REGISTER</h3></div>
			<div class="panel-body">
					
						<div>
						<c:forEach
								items="${flowRequestContext.messageContext.getMessagesBySource('id')}" var="err">
								<div class="usertxterror">
									<span>${err.text}</span>
								</div>
							</c:forEach>
					  <div style="margin-bottom: 25px" class="input-group">
                                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                                       	<form:input path="id"   required="true" class="form-control"   placeholder="USER ID"   pattern=".{6,15}"  title="please enter 6 to 15 characters"  />
                                    </div>
					</div>
					     
                              
                                    <div>
                                         <c:forEach
								items="${flowRequestContext.messageContext.getMessagesBySource('name')}"
								var="err">
								<div class="usertxterror">
									<span>${err.text}</span>
								</div>
							</c:forEach>
                                    <div style="margin-bottom: 25px" class="input-group">
                                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                       <form:input path="username" pattern=".{5,15}" class="form-control"  placeholder="USER NAME"  />                                        	
                                    </div>
                                    </div>
                                    
                                    <div>
                                    <c:forEach
								items="${flowRequestContext.messageContext.getMessagesBySource('mail')}"
								var="err">
								<div class="usertxterror">
									<span>${err.text}</span>
								</div>
							</c:forEach>
                                    <div style="margin-bottom: 25px" class="input-group">
                                    	  	
                                        <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
                                        	<form:input path="mail"   pattern=".{5,15}" class="form-control"   placeholder="EMAIL"  />
                                    </div>
                                    </div>
                                    
                                    <div>
                                    <c:forEach
								items="${flowRequestContext.messageContext.getMessagesBySource('address')}"
								var="err">
								<div class="usertxterror">
									<span>${err.text}</span>
								</div>
							</c:forEach>
                                    <div style="margin-bottom: 25px" class="input-group">
                                        <span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
                                      	<form:input path="address"  pattern=".{5,40}" class="form-control"   placeholder="ADDRESS"   />                                     	
                                    </div>
                                    </div>
                                    
                                    <div>
                                             	<c:forEach
								items="${flowRequestContext.messageContext.getMessagesBySource('contact')}"
								var="err">
								<div class="usertxterror">
									<span>${err.text}</span>
								</div>
							</c:forEach>
                                     <div style="margin-bottom: 25px" class="input-group">
                                        <span class="input-group-addon"><i class="glyphicon glyphicon-earphone"></i></span>
                                    	<form:input path="contact"  pattern=".{10}" class="form-control"  placeholder="CONTACT"  title="please enter only numbers"   />                                    	 
                                    </div>
                                    </div>
                                    
                                    <div>
                                    	<c:forEach
								items="${flowRequestContext.messageContext.getMessagesBySource('password')}"
								var="err">
								<div class="usertxterror">
									<span>${err.text}</span>
								</div>
							</c:forEach>
                                    <div style="margin-bottom: 25px" class="input-group">
                                        <span class="input-group-addon"><i class="glyphicon glyphicon-eye-open"></i></span>
                                        	<form:password path="password"  pattern=".{4,15}" class="form-control" placeholder="PASSWORD"  />
                                    </div>
                                    </div>
                                    

						
				
						</div>
						<div class="panel-footer">
					 	<input name="_eventId_submit" type="submit" value="Register" class="btn btn-primary btn-block"> 
						</div>
					
		
						
					</div>
	</form:form>

</div>
</body>
</html>