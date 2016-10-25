<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>

<title>Insert title here</title>
</head>
<body>
<%-- <div class="col-md-5">
                  <img src="<c:url value="/resources/images/${product.pro_id}.png" />" alt="image" style="width:100%"/>
                </div> --%>
                <div class="col-md-12">
			<table>
				<tr>
				
	<!-- 				<th align="left" width="80">Product ID</th> -->
					<th align="left" width="120">Product Name</th>
					<th align="left" width="200">Product Description</th>
					<th align="left" width="80">Price</th>
					<th align="left" width="200">Product Category</th>
					<th align="left" width="200">Product Supplier</th>
					
				</tr>
				<tr>
					<%--  <td align="left" >${product.pro_id}</td>  --%>
					<td align="left" >${product.pro_name}</td>
					<td align="left" >${product.pro_description}</td>
					<td align="left" >${product.pro_price}</td>
					<td align="left" >${product.category.cat_name}</td>
					<td align="left" >${product.supplier.sup_name}</td>
          		<td><c:url var="action" value="/addtocart/${product.pro_id}"></c:url>
			<form:form action="${action}" modelAttribute="cart">
			<input type="submit" class="btn btn-primary" value="Add To Cart" />
			</form:form></td>
          		 </tr>
        	</table> 
</div>
	     
</body>
</html>