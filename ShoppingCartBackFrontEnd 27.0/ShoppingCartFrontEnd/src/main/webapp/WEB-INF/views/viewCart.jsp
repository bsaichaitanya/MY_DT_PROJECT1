<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css"
	rel="stylesheet">

<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CART</title>
<style>
#cart {
    padding-top: 30px;
    padding-bottom: 30px;
    margin-bottom: 30px;
    margin-top: 30px;
    }
.container{
padding-top:50px;
}
#buy{
padding-right:70px;
}

#id{

}
</style>
<script>
function myFunction() {
    window.alert("Product successfully removed from cart!");
}
</script>
</head>
<body>
<c:choose>
<c:when test="${cartList==null}">
<div class="container">
				<div id="cart" class="jumbotron">
		<a href="Home"><img alt="empty" src="E:\PROJECT 1\pics\cart-empty.png"></a>	
				</div>
			</div>
</c:when>
<c:otherwise>
	<div class="container">
		<div class="col-md-12">

			<div class="table-responsive" >
				<table class=" display table table-striped table-hover">
					<thead>
						<tr>
							<th width="120">Image</th>
							<th width="150">Product Name</th> 
							<th width="80">Quantity</th>
							<th width="80">Price</th>
							<th width="120">Total Price</th>
							<th width="60"></th>

						</tr>
					</thead>
					<tbody>
						<c:forEach items="${cartList}" var="cart">
					
				<c:if test="${cart.product.pro_quantity==0}">
						<tr >
								<td><img width="100px" height="100px"
									alt="${cart.productID}"
									src="<c:url value="${contextPath}/resources/images/${cart.productID}.jpg"></c:url>" /></td>
							 <td>${cart.product.pro_name}</td>  
								<td  style="color: red">out of stock</td>
								<td>${cart.product.pro_price}</td>
								<td>${cart.total}</td>
								<td>
							<a class="btn btn-danger"
									href="<c:url value="/cart/remove/${cart.cart_id}"  />" onclick="myFunction()">
									 <i class="fa fa-trash-o" ></i></a></td>
							</tr>
						</c:if> 
						<c:if test="${cart.product.pro_quantity!=0}">
							<tr>
								<td><img width="100px" height="100px"
									alt="${cart.productID}"
									src="<c:url value="${contextPath}/resources/images/${cart.productID}.jpg"></c:url>" /></td>
							 <td>${cart.product.pro_name}</td>  
								<td>${cart.quantity}</td>
								<td>${cart.product.pro_price}</td>
								<td>${cart.total}</td>
								<td>
							<a class="btn btn-danger"
									href="<c:url value="/cart/remove/${cart.cart_id}"  />" onclick="myFunction()">
									 <i class="fa fa-trash-o" ></i></a></td>
							</tr>
							</c:if>
							
						</c:forEach>
					</tbody>
				</table>


				<div class="col-md-12">
					<h3 style="text-align: center">
						 Grand Total: <span><i class="fa fa-inr" aria-hidden="true"></i>${sum}</span>
					</h3>
					<div class="col-md-10">
						<a href="Home">
										<img src="<c:url value="${contextPath}/resources/images/buttons/Continue Shopping Button.png" ></c:url>"
										width="200px" height="60px"></a>
					</div>
					<div class="col-md-2">
						<a 
							href="checkoutDetails.obj"><img id="buy" src="<c:url value="${contextPath}/resources/images/buttons/Buy-Now-Button.png" ></c:url>"
										width="250px" height="80px"></a>
					</div>
				</div>
			</div>
		</div>
	</div>
	</c:otherwise>
</c:choose>

</body>
</html>