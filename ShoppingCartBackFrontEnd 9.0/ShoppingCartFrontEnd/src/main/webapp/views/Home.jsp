
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
<title>fabGift</title>
<style>
h1 {
	vertical-align: baseline;
	font-weight: 900;
	font-size: 53px;
	font-family: fantasy;
}

.carousel {
	background-color: 2f4357;
}

.container-fluid {
	background-color: #2f4357;
}

#logo {
	color: #2f4357;
}
</style>

</head>
<body style="background-color: #f7f7f7;">


	<div data-role="header" data-position="fixed">
		<h1>
			<span style="margin-right: 5px;"><img alt="logo"
				style="vertical-align: baseline;" src="E:\pics\logo.jpg"></span>FabGift
		</h1>
		
		
		${SuccessMessage} ${errorMessage}
		<table>
			<tr>
				<c:if test="${loggedout==true}">
					<td>${logoutMsg}</td>
				</c:if>
			</tr>
			<tr>
				<c:if test="${not empty loggedInUser}">
					<td>Welcome ${loggedInUser}</td>
				</c:if>

			</tr>
		</table>
		
		
		
		<!-- menu starts -->
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<ul class="nav navbar-nav">
					<li><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
					<li><a href="#">GIFTS</a></li>
					<li><a href="#">CARDS</a></li>
					<li><a href="#">CHOCOLATES</a></li>
					<li><a href="#"><span class="glyphicon glyphicon-search"></span></a></li>
					<li><i class="icon-gift"></i></li>

				</ul>
				<ul class="nav navbar-nav navbar-right">

					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">CONTACT<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#">Hyderabad</a></li>
							<li><a href="#">Delhi</a></li>
							<li><a href="#">Jaipur</a></li>
						</ul></li>
					<li><a href="#">ABOUT US</a></li>

					<c:choose>
						<c:when test="${empty loggedInUser}">
							<li><a href="Login">LOGIN</a></li>
							<li><a href="Registration">REGISTER</a></li>

						</c:when>

						<c:when test="${not empty loggedInUser}">

							<li><a href="logout">LOGOUT</a></li>
						</c:when>


					</c:choose>


				</ul>
			</div>
		</nav>
		<!-- menu  ends-->


	</div>


	<%-- <tr>
					<c:if test="${not empty cartSize}">
						<td align="right"><a href="myCart">My cart</a>(${cartSize})</td>
					</c:if>
				</tr> --%>

	<%-- 
		<div >
			<ul id=menu>
				<c:if test="${not empty List}">
					<c:forEach items="${categoryList}" var="category ">
						<li><a href="${category.cat_name}">${category.cat_name}</a>
						
							
					</c:forEach>
				</c:if>
			</ul>
			<br> <br> <br>
	
			<div>
				<c:if test="${!empty selectedProduct.name}">
					<table>
						<tr>
							<th align="left" width="80">Product ID</th>
							<th align="left" width="120">Product Name</th>
							<th align="left" width="200">Product Description</th>
							<th align="left" width="80">Price</th>
							<th align="left" width="200">Product Category</th>
							<th align="left" width="200">Product Supplier</th>
						</tr>
						<tr>
							<td align="left">${SelectedProduct.id}</td>
							<td align="left">${SelectedProduct.name}</td>
							<td align="left">${SelectedProduct.description}</td>
							<td align="left">${SelectedProduct.price}</td>
							<td align="left">${SelectedProduct.category.name}</td>
							<td align="left">${SelectedProduct.supplier.name}</td>
						</tr>
					</table>
				</c:if>
			</div> --%>

	<%-- <!-- Carousel images -->
	<div data-role="body" data-position="fixed">
	<c:choose>
		<c:when test="${not empty loggedInUser}">
			<div class="container">
				<br>
				<div id="myCarousel" class="carousel slide" data-ride="carousel">
					<!-- 	Indicators -->
					<ol class="carousel-indicators">
						<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
						<li data-target="#myCarousel" data-slide-to="1"></li>
						<li data-target="#myCarousel" data-slide-to="2"></li>

					</ol>

					<!-- 	Wrapper for slides -->
					<div class="carousel-inner" role="listbox">

						<div class="item active">
							<img align="center" src="E:\pics\choc.jpg" alt="#" width="460"
								height="345">
							<div class="carousel-caption">
								<h3>Valentines Day</h3>
								<p>Lovely gifts for your boyfriends/girlfriends</p>
							</div>
						</div>

						<div class="item">
							<img align="center" src="E:\pics\gift.jpg" alt="#" width="460"
								height="345">
							<div class="carousel-caption">
								<h3>Friendship day</h3>
								<p>Wanna gift your friend</p>
							</div>
						</div>


						<div class="item">
							<img align="center" src="E:\pics\card.jpg" alt="#" width="460"
								height="345">
							<div class="carousel-caption">
								<h3>Greeting Cards</h3>
								<p>Wish your beloved ones on Special occasions
								<p>
							</div>
						</div>

					</div>

					<!-- 	Left and right controls -->
					<a class="left carousel-control" href="#myCarousel" role="button"
						data-slide="prev"> <span
						class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
						<span class="sr-only">Previous</span>
					</a> <a class="right carousel-control" href="#myCarousel" role="button"
						data-slide="next"> <span
						class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
						<span class="sr-only">Next</span>
					</a>
				</div>
			</div>
			<!-- End of carousel images -->
 --%>


	
			<div id="Registration">

				<c:if test="${userClickedRegisterHere==true}">
					<jsp:include page="Registration.jsp"></jsp:include>
				</c:if>
			</div>



			<div id="Login">

				<c:if test="${userClickedLoginHere==true}">
					<jsp:include page="Login.jsp"></jsp:include>
				</c:if>
			</div>


			<div id="admin">
				<c:if test="${isAdmin==true}">
					<jsp:include page="adminHome.jsp"></jsp:include>

				</c:if>
				<div id="categories">
					<c:if test="${isAdminClickedCategories==true}">
						<jsp:include page="adminHome.jsp"></jsp:include>
						<%@ include file="/views/category.jsp"%>
					</c:if>
				</div>

				<div id="product">
					<c:if test="${isAdminClickedproducts==true}">
						<jsp:include page="adminHome.jsp"></jsp:include>
						<%@ include file="/views/Product.jsp"%>
					</c:if>
				</div>

				<div id="suppliers">
					<c:if test="${isAdminClickedsuppliers==true}">
						<jsp:include page="adminHome.jsp"></jsp:include>
						<%@ include file="/views/supplier.jsp"%>
					</c:if>
				</div>

			</div>



</body>
</html>