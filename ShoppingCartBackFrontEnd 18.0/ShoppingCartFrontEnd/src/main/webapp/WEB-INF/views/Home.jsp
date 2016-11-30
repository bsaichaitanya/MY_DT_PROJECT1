<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ page isELIgnored="false"%>
<html>
<head>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="css/demo.css">
<link rel="stylesheet"
	href="css/footer-distributed-with-address-and-phones.css">

<link href="http://fonts.googleapis.com/css?family=Cookie"
	rel="stylesheet" type="text/css">
<title>fabGift</title>
<style>


h1 {
	vertical-align: baseline;
	font-weight: 900;
	font-size: 53px;
	font-family: serif;
	color: #000000 !important;
	text-align: center;
}

/* .carousel {
	background-color: 2f4357;
} */

 .container-fluid {
	background-color: #2f4357;
} 

 
 #myCarousel {
	padding-top: 0px;
} 
 
#logo {
	color: #2f4357;
}

.btn-primary {
	color: #fff;
	background-color: #2f4357;
	border-color: #2e6da4;
}

/* ================================= */
footer {
	position: fixed;
	bottom: 0;
}

@media ( max-height :800px) {
	footer {
		position: static;
	}
	header {
		padding-top: 40px;
	}
}

.footer-distributed {
	background-color: #292c2f;
	box-shadow: 0 1px 1px 0 rgba(0, 0, 0, 0.12);
	box-sizing: border-box;
	width: 100%;
	text-align: left;
	font: bold 16px sans-serif;
	padding: 55px 50px;
	margin-top: 80px;
}

.footer-distributed .footer-left, .footer-distributed .footer-center,
	.footer-distributed .footer-right {
	display: inline-block;
	vertical-align: top;
}

/* Footer left */
.footer-distributed .footer-left {
	width: 40%;
}

/* The company logo */
.footer-distributed h3 {
	color: #ffffff;
	font: normal 36px 'Cookie', cursive;
	margin: 0;
}

.footer-distributed h3 span {
	color: #5383d3;
}

/* Footer links */
.footer-distributed .footer-links {
	color: #ffffff;
	margin: 20px 0 12px;
	padding: 0;
}

.footer-distributed .footer-links a {
	display: inline-block;
	line-height: 1.8;
	text-decoration: none;
	color: inherit;
}

.footer-distributed .footer-company-name {
	color: #8f9296;
	font-size: 14px;
	font-weight: normal;
	margin: 0;
}

/* Footer Center */
.footer-distributed .footer-center {
	width: 35%;
}

.footer-distributed .footer-center i {
	background-color: #33383b;
	color: #ffffff;
	font-size: 25px;
	width: 38px;
	height: 38px;
	border-radius: 50%;
	text-align: center;
	line-height: 42px;
	margin: 10px 15px;
	vertical-align: middle;
}

.footer-distributed .footer-center i.fa-envelope {
	font-size: 17px;
	line-height: 38px;
}

.footer-distributed .footer-center p {
	display: inline-block;
	color: #ffffff;
	vertical-align: middle;
	margin: 0;
}

.footer-distributed .footer-center p span {
	display: block;
	font-weight: normal;
	font-size: 14px;
	line-height: 2;
}

.footer-distributed .footer-center p a {
	color: #5383d3;
	text-decoration: none;;
}

/* Footer Right */
.footer-distributed .footer-right {
	width: 20%;
}

.footer-distributed .footer-company-about {
	line-height: 20px;
	color: #92999f;
	font-size: 13px;
	font-weight: normal;
	margin: 0;
}

.footer-distributed .footer-company-about span {
	display: block;
	color: #ffffff;
	font-size: 14px;
	font-weight: bold;
	margin-bottom: 20px;
}

.footer-distributed .footer-icons {
	margin-top: 25px;
}

.footer-distributed .footer-icons a {
	display: inline-block;
	width: 35px;
	height: 35px;
	cursor: pointer;
	background-color: #33383b;
	border-radius: 2px;
	font-size: 20px;
	color: #ffffff;
	text-align: center;
	line-height: 35px;
	margin-right: 3px;
	margin-bottom: 5px;
}

/* If you don't want the footer to be responsive, remove these media queries */
@media ( max-width : 880px) {
	.footer-distributed {
		font: bold 14px sans-serif;
	}
	.footer-distributed .footer-left, .footer-distributed .footer-center,
		.footer-distributed .footer-right {
		display: block;
		width: 100%;
		margin-bottom: 40px;
		text-align: center;
	}
	.footer-distributed .footer-center i {
		margin-left: 0;
	}
}
</style>

</head>


<body  >
 <!-- style="background-color: #f7f7f7;"  background="E:\PROJECT 1\pics\carousel\1.gif "-->

	<div data-role="header" data-position="fixed">
		<h1>
			<b>FabGift</b>
		</h1></div>
		<%-- 	<div style="text-align: right;">
			<c:choose>

				<c:when test="${loggedout==true}">
					<h4 style="padding-right: 20px">
						<em>${logoutMsg}</em>
					</h4>
				</c:when>
			</c:choose>
		</div> --%>

		<!-- 	================================================================================================================== -->
		<!-- menu starts -->
		<nav class="navbar navbar-inverse ">

			<div class="container-fluid">

				<ul class="nav navbar-nav">
					<li><a href="Home"><span><img alt="logo"
								style="vertical-align: baseline;" src="E:\PROJECT 1\pics\fg.jpg"
								width="25px" height="20px"></span></a></li>
					<c:forEach items="${categoryList}" var="category"><!-- category and product retrieving -->
						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" href="${category.cat_name}">${category.cat_name}<span
								class="caret"></span></a>
							<ul class="dropdown-menu">
								<c:forEach items="${category.products}" var="product">
									<li><a href="<c:url value="viewProduct/${product.pro_id}"/>" >${product.pro_name}</a></li> 
								</c:forEach>
							</ul></li>
					</c:forEach><!-- end of category and product retrieving -->
					<li><a href="ProductList">PRODUCTS</a></li>
					<li><a href="#"><span class="glyphicon glyphicon-search"></span></a></li>
				</ul>
				
				
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">CONTACT<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#">Hyderabad</a></li>
							<li><a href="#">Delhi</a></li>
							<li><a href="#">Jaipur</a></li>
						</ul></li>
					<li><a href="about">ABOUT US</a></li>

					<c:choose>
						<c:when test="${pageContext.request.userPrincipal.name==null}">
							<li><a href="login">LOGIN</a></li>
							<li><a href="memberShip.obj">REGISTER</a></li>
						</c:when>

						<c:when test="${pageContext.request.userPrincipal.name!=null}" >
							<li><a href="myCart"> <i class="fa fa-shopping-cart"
									aria-hidden="true"></i> CART
							</a></li>
							<li class="dropdown"><a class="dropdown-toggle"
								data-toggle="dropdown" href="#"><i class="fa fa-user fa-fw"></i>Hi<em>
									${pageContext.request.userPrincipal.name }!</em><span class="caret"></span></a>
								<ul class="dropdown-menu">
									<li><a href="#"><i class="fa fa-pencil fa-fw"></i><em>Profile</em></a></li>
									<li class="divider"></li>
									<li><a href="<c:url value="/j_spring_security_logout" />"></><i class="fa fa-unlock"></i><em>LogOut</em></a></li>
								</ul></li>
						</c:when>
					</c:choose>
				</ul>
			</div>
		</nav>
		<!-- menu  ends-->

		<!-- 	================================================================================================================= -->
<div>
<div style="text-align: center;">
			<c:if test="${InvalidCredentials==true}">
				<h4 style="padding-right: 10px">
					<em>${errorMessage}</em>
				</h4>
			</c:if>

			<c:if test="${successRegister==true}">
				<h4 style="padding-right: 10px">
					<em>${SuccessMessage}</em>
				</h4>
			</c:if>

			<c:if test="${userExist==true}">
				<h4 style="padding-right: 10px">
					<em>${failureMessage}</em>
				</h4>
			</c:if>
		</div>
		
		
		<!-- Carousel images -->
		<div >
			<c:if test="${(carousel==true)}">
		
				<!-- Full Page Image Background Carousel Header -->
  	<header id="myCarousel" class="carousel slide"> <!-- Indicators -->

  	<ol class="carousel-indicators">
  		<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
  		<li data-target="#myCarousel" data-slide-to="1"></li>
  		<li data-target="#myCarousel" data-slide-to="2"></li>
  		<li data-target="#myCarousel" data-slide-to="3"></li>
  		<li data-target="#myCarousel" data-slide-to="4"></li>
  	</ol>

  	<!-- Wrapper for Slides -->
  	<div class="carousel-inner">
  	
  	 	<div class="item active">
  			<!-- Set the third background image using inline CSS below. -->
  			<div class="fill"> <img  src="E:\PROJECT 1\pics\carousel\diw.gif"alt="#" width="100%"
								height="75%"></div>					
  		</div> 
  		
  			<div class="item ">
  			<!-- Set the first background image using inline CSS below. -->
  			<div class="fill" ><img  src="E:\PROJECT 1\pics\carousel\a.gif" alt="#" width="100%"
								height="75%"></div>
  		</div>
  		
  		<div class="item ">
  			<!-- Set the first background image using inline CSS below. -->
  			<div class="fill" ><img  src="E:\PROJECT 1\pics\carousel\di4.jpg" alt="#" width="100%"
								height="75%"></div>
  		</div>
  		
  		
  		<div class="item">
  			<!-- Set the second background image using inline CSS below.  -->
  			<div class="fill"> <img  src="E:\PROJECT 1\pics\carousel\yes.PNG" alt="#" width="100%"
								height="75%"></div>
							
  		</div>
  		
  		
  			<div class="item ">
  			<!-- Set the first background image using inline CSS below. -->
  			<div class="fill" ><img  src="E:\PROJECT 1\pics\carousel\ama.jpg" alt="#" width="100%"
								height="75%"></div>
  		</div>
  		<div class="item">
  			<!-- Set the second background image using inline CSS below.  -->
  			<div class="fill"> <img  src="E:\PROJECT 1\pics\carousel\2016.jpg" alt="#" width="100%"
								height="75%"></div>
							
  		</div>
  <!-- 		<div class="item">
  			Set the third background image using inline CSS below.
  			<div class="fill"> <img  src="E:\PROJECT 1\pics\carousel\di3.PNG"alt="#" width="100%"
								height="75%"></div>			
  		</div> -->
  		
  		<div class="item">
  			<!-- Set the fourth background image using inline CSS below. -->
  				<div class="fill"> <img  src="E:\PROJECT 1\pics\carousel\di3.PNG" alt="#" width="100%"
								height="75%"></div>			
  		</div>
  		
  	<div class="item">
  			<!-- Set the fifth background image using inline CSS below. -->
  		<div class="fill"> <img  src="E:\PROJECT 1\pics\carousel\Raksh.jpg" alt="#" width="100%"
								height="75%"></div>
  	</div>
  	
</div>
  	<!-- Controls -->
  	<a class="left carousel-control" href="#myCarousel" data-slide="prev"> <span class="icon-prev"></span> </a>
  	<a class="right carousel-control" href="#myCarousel" data-slide="next"> <span class="icon-next"></span>	</a>
  	</header>
  		
			</c:if>
		
		</div>
		
		
		<!-- ====================================================================================================================== -->
		<!-- 	Including pages in Home page  -->
		
		
		<div id=viewProduct>
			<c:if test="${clickedIndividualProduct==true}">
				<jsp:include page="viewProduct.jsp"></jsp:include>
			</c:if>
		</div>

	<div id="about">
		<c:if test="${clickedAbout==true}">
			<jsp:include page="About.jsp"></jsp:include>
		</c:if>
	</div>

	<div id="cart">
		<c:if test="${userclickedcart==true}">
			<jsp:include page="viewCart.jsp"></jsp:include>
		</c:if>
	</div>


	<div id="product">
		<c:if test="${IsClickedProduct==true}">
			<jsp:include page="ProductList.jsp"></jsp:include>
		</c:if>
	</div>


	<div id="Registration">
		<c:if test="${userClickedRegisterHere==true}">
			<jsp:include page="Registration.jsp"></jsp:include>
		</c:if>
	</div>


	<div id="Login">
		<c:if test="${userClickedLoginHere==true}">
			<jsp:include page="login.jsp"></jsp:include>
		</c:if>
	</div>


	<div id="admin">
		<c:if test="${isAdmin==true}">
			<jsp:include page="adminHome.jsp"></jsp:include>
		</c:if>
		<div id="categories">
			<c:if test="${isAdminClickedCategories==true}">
				<jsp:include page="adminHome.jsp"></jsp:include>
				<%@ include file="category.jsp"%>
			</c:if>
		</div>
		<div id="product">
			<c:if test="${isAdminClickedproducts==true}">
				<jsp:include page="adminHome.jsp"></jsp:include>
				<%@ include file="Product.jsp"%>
			</c:if>
		</div>
		<div id="suppliers">
			<c:if test="${isAdminClickedsuppliers==true}">
				<jsp:include page="adminHome.jsp"></jsp:include>
				<%@ include file="supplier.jsp"%>
			</c:if>
		</div>
	</div>

</div>
		
		<!-- ==================================================================================================================== -->

		


</body>

<!-- 	====================================================================================================================== -->
<!-- 	footer -->
<footer class="footer-distributed">

	<div class="footer-left">
		<h3>
			<span>FabGift</span>
		</h3>
		<p class="footer-links">
			<a href="Home">Home</a> · <a href="about">About</a> · <a href="#">Faq</a>
			· <a href="#">Contact</a>
		</p>
		<p class="footer-company-name">FabGift&copy; 2016</p>
	</div>


	<div class="footer-center">
		<div>
			<i class="fa fa-map-marker"></i>
			<p>
				<span>Hyderabad</span> Telangana, India
			</p>
		</div>
		<div>
			<i class="fa fa-phone"></i>
			<p>040-2756428</p>
		</div>
		<div>
			<i class="fa fa-envelope"></i>
			<p>
				<a href="fabgift:support@company.com">fabGift.support@company.com</a>
			</p>
		</div>
	</div>


	<div class="footer-right">
		<p class="footer-company-about">
			<span>About the company</span> Fabgift is India's fastest emerging
			online gift shopping website launched in 2016
		</p>
		<div class="footer-icons">
			<a href="#"><i class="fa fa-facebook"></i></a> <a href="#"><i
				class="fa fa-twitter"></i></a> <a href="#"><i class="fa fa-linkedin"></i></a>
			<a href="#"><i class="fa fa-github"></i></a>
		</div>
	</div>

</footer>
</html>