<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<script type="text/javascript">
</script>
<style>
ul li {
	padding: 5px;
}

#outOfStock{
color: red;
}
#single {
	padding-top: 60px;
	padding-bottom: 280px;
	margin-top: 50px;
}
</style>
</head>
<body>
	<div class="container">
	<div style="color: #ff0000;">
		<c:if test="${productOutOfStock==true}">
			<h5 style="padding-right: 20px; text-align: center;">
				<i>SORRY! PRODUCT EXCEEDS MORE THAN  AVAILABLE QUANTITY IN YOUR CART</i>
			</h5>
		</c:if>
		<c:if test="${OutOfStock==true}">
			<h5 style="padding-right: 20px; text-align: center;">
				<i>SORRY! Product is out of stock!!! </i>
				
			</h5>
		</c:if>
	</div>
		<div id="single" class="jumbotron">
		
			<div class="col-md-12">

				<div class="col-md-6">
					<img
						src="<c:url value="${contextPath}/resources/images/${product.pro_id}.jpg"  />"
						alt="image" width="200px" height="150px">
				</div>

				<div class="col-md-6">
					<ul class="list-unstyled">
						<li><em>Product:</em><em style="color:  blue"> ${product.pro_name}</em></li>
						<li><em>Description:</em><em style="color:#990000"> ${product.pro_description}</em></li>
						<li><em>Price:</em><em style="color: orange"> Rs. ${product.pro_price}</em></li>
						<c:choose>
							<c:when test="${product.pro_quantity > 0}">
								<li><em>Quantity:</em><em style="color: #FF1493">${product.pro_quantity}</em></li>
							</c:when>
							<c:otherwise>
								<li><em>Quantity:</em><em id="outOfStock">Out of Stock</em> </li>
							</c:otherwise>
						</c:choose>
						<li><em>Category:</em><em style="color: #9966CC"> ${product.category.cat_name}</em></li>
						<li><em>Supplier:</em> <em style="color: #00C4B0"> ${product.supplier.sup_name}</em></li>
								<li><a
									href="<c:url  value="${contextPath}/addtocart/${product.pro_id}" />">
										<img src="<c:url value="${contextPath}/resources/images/buttons/addtocart-orange.png" ></c:url>"
										width="200px" height="60px">
								</a></li>
					</ul>
				</div>
			</div>
		</div>

	</div>

</body>
</html>