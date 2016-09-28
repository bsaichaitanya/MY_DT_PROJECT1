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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<h1 align="center">Add Supplier</h1>
<c:url var="addAction" value="supplier/add"></c:url>
<form:form action="${addAction}" commandName="supplier" class="form-responsive">
<table align="center">
	<tr>
			<td><form:label path="sup_id"> <spring:message text="ID"/></form:label></td>
					<c:choose>
							<c:when test="${!empty supplier.sup_id}">
							<td><form:input path="sup_id" readonly="true" class="form-control" /> </td>
							</c:when>
									
							 <c:otherwise>
							 <td><form:input path="sup_id" pattern="{5,10}" required="true" title="id should be between 5 to 10 characters" class="form-control" /> </td>
							 </c:otherwise>
					</c:choose>
			</tr>
		<tr>
			<td><form:label path="sup_name"> <spring:message text="name"/></form:label></td>
			<td><form:input path="sup_name" required="true" class="form-control" /> </td>
		</tr>
		
		<tr>
			<td><form:label path="sup_address"> <spring:message text="address"/></form:label></td>
			<td><form:input path="sup_address" required="true" class="form-control" /> </td>
		</tr>
		<tr>
			<td colspan="2">
			<c:if test="${!empty supplier.sup_name}">
			<input type="submit" class="btn btn-primary"  value="<spring:message text="Edit supplier"/> "> 
			</c:if>
			<c:if test="${empty supplier.sup_name}">
			<input type="submit" class="btn btn-primary" 	value="<spring:message text="Add supplier"/> "> 
			</c:if>
			</td>

		</tr>
</table>
</form:form>
<br>


<h3>Supplier List</h3>
	<c:if test="${!empty supplierList}">
		<div class="table-responsive">
		<table  class="table table-hover">
		<tr>
				<th width="80"> Id</th>
				<th	width="120"> Name</th>
				<th width="120"> Address</th>
				<th width="60">Edit</th>
				<th width="60">Delete</th>
		</tr>
		<c:forEach items="${supplierList}" var="supplier">
			<tr>
				<td>${supplier.sup_id}</td>
				<td>${supplier.sup_name}</td>
				<td>${supplier.sup_address}</td>
				<td><a href="<c:url value="supplier/update/${supplier.sup_id}"/>">Edit</a></td>
				<td><a href="<c:url value="supplier/remove/${supplier.sup_id}"/>">Delete</a></td>
			</tr>
		</c:forEach>
		</table>
		</div>
	</c:if>


</body>
</html>