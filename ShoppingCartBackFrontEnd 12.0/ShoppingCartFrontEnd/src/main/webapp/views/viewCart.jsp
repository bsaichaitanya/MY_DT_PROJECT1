<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style >

</style>
</head>
<body>
<img src="E:\pics\error.jpg"  align="center">
<%-- <div id ="displayCart">
	<c:if test="${displayCart==true}">
	       
			<table>
				<tr>
					<th align="left" width="80">Cart ID</th>
					<th align="left" width="120">Product Name</th>
					<th align="left" width="200">Quantity</th>
					<th align="left" width="80">Price</th>
					<th align="left" width="60">Delete from Cart</th>

				</tr>
				<c:forEach items="${cartList}" var="cart">
				<tr>
					<td align="left" >${cart.id}</td>
					<td align="left" >${cart.productName}</td>
					<td align="left" >${cart.quantity}</td>
					<td align="left" >${cart.price}</td>
					<td align="left" ><a
						href="<c:url value='/cart/delete/${cart.id}'  />">Delete</a></td>
						<td align="left" ><a
						href="<c:url value='pay/${cart.id}' />"> Proceed</a> </td>
				</tr>
				</c:forEach>
					
			</table>
			
			<h2>  Total cost : ${totalAmount}</h2>
			<a href="<c:url value='/pay/${cart.userID}'/>">Proceed</a> 
			<a href="<c:url value='/pay/${cart.id}'/>">Proceed</a> 
		</c:if>
	
	
	
	</div>
 --%>

</body>
</html>