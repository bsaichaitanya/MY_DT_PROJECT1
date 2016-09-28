 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
  <h3>Product List</h3>
<c:if test="${!empty productList}">
	<div class="table-responsive">
		<table  class="table table-hover">
	<tr>
		<th>Id</th>
		<th> Name</th>
		<th>Description</th>
		<th>Price</th>
		<th>Category</th>
		<th>Supplier</th>
						<!-- <th width="120">Image</th> -->
		
	</tr>
	<c:forEach items="${productList}" var="product">
		<tr>
			<td>${product.pro_id}</td>
			<td>${product.pro_name}</td>
			<td>${product.pro_description}</td>
			<td>${product.pro_price}</td>
			<td>${product.category_id}<td>
			<td>${product.supplier_id} </td>
			</tr>
	</c:forEach>
	</table>
	</div>
</c:if>
</body>
</html>