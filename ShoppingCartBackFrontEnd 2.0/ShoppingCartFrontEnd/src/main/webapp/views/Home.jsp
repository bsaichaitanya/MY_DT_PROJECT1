<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body>

${message}
<a href="Login"> login</a>
<a href="Register"> Register</a>

<c:if test="${UserClickedRegisterHere}==true">
<jsp:include page="Registration.jsp"></jsp:include>
</c:if>
<c:if test="${UserClickedLoginHere}==true">
<jsp:include page="Login.jsp"></jsp:include>
</c:if>
</body>
</html>