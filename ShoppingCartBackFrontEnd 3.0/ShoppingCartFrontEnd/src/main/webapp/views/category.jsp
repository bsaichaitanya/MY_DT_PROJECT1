<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<h1>Add Category</h1>
<c:url var="addAction" value="category/add"></c:url>
<form:form action="${addAction}" commandName="category">
<table>
	<tr>
			<td><form:label path="id"> <spring:message text="ID"/></form:label></td>
					<c:choose>
							<c:when test="${!empty category.id}">
							<td><form:input path="id" disabled="true" readonly="true"/> </td>
							</c:when>
									
							 <c:otherwise>
							 <td><form:input path="id" pattern="{5,10}" required="true" title="id should be between 5 to 10 characters"/> </td>
							 </c:otherwise>
					</c:choose>
			</tr>
		<tr>
			<td><form:label path="name"> <spring:message text="name"/></form:label></td>
			<td><form:input path="name" required="true"/> </td>
		</tr>
		
		<tr>
			<td><form:label path="description"> <spring:message text="description"/></form:label></td>
			<td><form:input path="description" required="true"/> </td>
		</tr>
		<tr>
			<td colspan="2">
			<c:if test="${!empty category.name}">
			<input type="submit" value="<spring:message text="Edit category"/> "> 
			</c:if>
			<c:if test="${empty category.name}">
			<input type="submit" value="<spring:message text="Add category"/> "> 
			</c:if>
			</td>

		</tr>
</table>
</form:form>
<br>


<h3>Category List</h3>
	<c:if test="${!empty categoryList}">
		<table class="tg">
		<tr>
				<th width="80">Category Id</th>
				<th	width="120">Category Name</th>
				<th width="120">Category Description</th>
				<th width="60">Edit</th>
				<th width="60">Delete</th>
		</tr>
		<c:forEach items="${categoryList}" var="category">
			<tr>
				<td>${category.id}</td>
				<td>${category.name}</td>
				<td>${category.description}</td>
				<td><a href="<c:url value="categoryUpdate/${category.id}"/>">Edit</a></td>
				<td><a href="<c:url value="categoryRemove/${category.id}"/>">Delete</a></td>
			</tr>
		</c:forEach>
		</table>
	</c:if>


</body>
</html>