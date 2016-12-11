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
	<script
	src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
<script
	src="https://cdn.datatables.net/1.10.12/js/dataTables.bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.12/css/dataTables.bootstrap.min.css">
<script type="text/javascript">
	$(document).ready(function() {
		$('#example').dataTable();
	});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <div class="container">
	<div class="col-md-12">
		<h3 style="text-align: center;"><b>PRODUCT LIST</b></h3>
<c:if test="${!empty productList}">
	<div class="table-responsive" style="margin-left: 5%; width: 90%">
		<table id="example"
					class=" display table table-striped table-bordered">
					<thead>
	<tr>
<!-- 		<th>Id</th> -->
	<th>Image</th>
		<th> Name</th>
		<th>Description</th>
		<th>Price</th>
		<th>Details</th>
		<th></th>
	
						
		
	</tr>
	</thead>
	<tbody>
	<c:forEach items="${productList}" var="product">
		<tr>
		<td><img width="100px" height="100px"  alt="${product.pro_id}"
            src="<c:url value="E:\\workspace\\ShoppingCartFrontEnd\\src\\main\\resources\\images\\${product.pro_id}.jpg"></c:url>"/></td>
		
			<%-- <td>${product.pro_id}</td> --%>
			<td>${product.pro_name}</td>
			<td>${product.pro_description}</td>
			<td>${product.pro_price}</td>
	<%-- 		<td>${product.category_id}</td>
			<td>${product.supplier_id} </td> --%>
		<td>	<a href="<c:url value="p/${product.pro_id}"/>" >
		<img  src="E:\PROJECT 1\pics\info.png" width="60px" height="60px"></a></td>
		<td><a href="<c:url  value="/addtocart/${product.pro_id}" />"> 
	<img  src="E:\PROJECT 1\pics\cart.png" width="50px" height="50px"></a></td>
				</tr>
		</c:forEach>
					</tbody>
				</table>
			</div>
		</c:if>
	</div>
	</div>
</body>
</html>