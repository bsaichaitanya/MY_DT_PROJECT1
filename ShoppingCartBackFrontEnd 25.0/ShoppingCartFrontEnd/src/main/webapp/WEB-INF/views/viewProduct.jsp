<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<script type="text/javascript">
	document.getElementById("disabled").onclick = function() {
		this.disabled = true
	}
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
	padding-bottom: 230px;
	margin-top: 50px;
}
</style>
</head>
<body>
	<div class="container">
		<div id="single" class="jumbotron">
			<div class="col-md-12">

				<div class="col-md-6">
					<img
						src="<c:url value="${contextPath}/resources/images/${product.pro_id}.jpg"  />"
						alt="image" width="200px" height="150px">
				</div>

				<div class="col-md-6">
					<ul class="list-unstyled">
						<li><em>Product: ${product.pro_name}</em></li>
						<li><em>Description: ${product.pro_description}</em></li>
						<li><em>Price: Rs. ${product.pro_price}</em></li>
						<c:choose>
							<c:when test="${product.pro_quantity > 0}">
								<li><em>Quantity: ${product.pro_quantity}</em></li>
							</c:when>
							<c:otherwise>
								<li><em>Quantity:</em><em id="outOfStock">Out of Stock</em> </li>
							</c:otherwise>
						</c:choose>
						<li><em>Category: ${product.category.cat_name}</em></li>
						<li><em>Supplier: ${product.supplier.sup_name}</em></li>
						<c:choose>
							<c:when test="${product.pro_quantity > 0}">
								<li><a
									href="<c:url  value="${contextPath}/addtocart/${product.pro_id}" />">
										<img src="E:\PROJECT 1\pics\addtocart-orange.png"
										width="200px" height="60px">
								</a></li>
							</c:when>
							<c:otherwise>
								<li><a href="/" onclick="return false;"><img
										src="E:\PROJECT 1\pics\addtocart-orange.png" width="200px"
										height="60px"></a></li>
							</c:otherwise>
						</c:choose>
					</ul>
				</div>
			</div>
		</div>

	</div>

</body>
</html>