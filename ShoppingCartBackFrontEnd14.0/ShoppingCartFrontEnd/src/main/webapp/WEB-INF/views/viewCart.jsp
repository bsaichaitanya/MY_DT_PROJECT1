<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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

	<div class="table-responsive" style="margin-left: 5%; width: 90%">
		<table id="example"
					class=" display table table-striped table-bordered">
					<thead>
				<tr>
					<th align="left" width="120">Product Name</th>
					<th align="left" width="200">Quantity</th>
					<th align="left" width="80">Price</th>
					<th align="left" width="60"> </th>

				</tr>
				</thead>
				<tbody>
				<c:forEach items="${cartList}" var="cart">
				<tr>
					<td align="left" >${cart.productName}</td>
					<td align="left" >${cart.quantity}</td>
					<td align="left" >${cart.productPrice}</td>
					<td align="left" >
					<a href="<c:url value="/cart/remove/${cart.cart_id}"  />">Delete</a></td>
						<%-- <td align="left" ><a
						href="<c:url value='pay/${cart.cart_id}' />"> Proceed</a> </td> --%>
				</tr>
				</c:forEach>
					</tbody>
			</table>
		<%-- 	
			<h2>  Total cost : ${totalAmount}</h2>
			<a href="<c:url value='/pay/${cart.userID}'/>">Proceed</a> 
			<a href="<c:url value='/pay/${cart.id}'/>">Proceed</a>  --%>
	
 	
	</div>
 </div>
 </div>


</body>
</html>