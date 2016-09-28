<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>

<style>




</style>

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

<h2 align="center">Add Category</h2>
<c:url var="addAction" value="category/add"></c:url>
<form:form action="${addAction}" commandName="category" class="form-responsive">
<table align="center">
	<tr>
			<td><form:label path="cat_id"> <spring:message text="ID"/></form:label></td>
					<c:choose>
							<c:when test="${!empty category.cat_id}">
							<td><form:input path="cat_id" readonly="true" class="form-control"/> </td>
							</c:when>
									
							 <c:otherwise>
							 <td><form:input path="cat_id" pattern="{5,10}" required="true" title="id should be between 5 to 10 characters" class="form-control"/> </td>
							 </c:otherwise>
					</c:choose>
			</tr>
		<tr>
			<td><form:label path="cat_name"> <spring:message text="NAME" /></form:label></td>
			<td><form:input path="cat_name" required="true"  class="form-control"/> </td>
		</tr>
		
		<tr>
			<td><form:label path="cat_description"> <spring:message text="DESCRIPTION"/></form:label></td>
			<td><form:input path="cat_description" required="true" class="form-control" /> </td>
		</tr>
		<tr>
			<td colspan="2">
			<c:if test="${!empty category.cat_name}">
			<input type="submit" class="btn btn-primary" value="<spring:message text="Edit category"/> "> 
			</c:if>
			<c:if test="${empty category.cat_name}">
			<input type="submit" class="btn btn-primary" value="<spring:message text="Add category"/> "> 
			</c:if>
			</td>

		</tr>
</table>
</form:form>
<br>


<h3>Category List</h3>
	<c:if test="${!empty categoryList}">
	<div class="table-responsive">
		<table  class="table table-hover">
		<tr>
				<th width="80">Category Id</th>
				<th	width="120">Category Name</th>
				<th width="120">Category Description</th>
				<th width="60">Edit</th>
				<th width="60">Delete</th>
		</tr>
		<c:forEach items="${categoryList}" var="category">
			<tr>
				<td>${category.cat_id}</td>
				<td>${category.cat_name}</td>
				<td>${category.cat_description}</td>
				<td><a href="<c:url value="category/update/${category.cat_id}"/>">Edit</a></td>
				<td><a href="<c:url value="category/remove/${category.cat_id}"/>">Delete</a></td>
			</tr>
		</c:forEach>
		</table>
		</div>
	</c:if>


</body>
</html>