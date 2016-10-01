<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div>
	
			<table>
				<tr>
					<th align="left" width="80">Product ID</th>
					<th align="left" width="120">Product Name</th>
					<th align="left" width="200">Product Description</th>
					<th align="left" width="80">Price</th>
				<!-- 	<th align="left" width="200">Product Category</th>
					<th align="left" width="200">Product Supplier</th> -->
				</tr>
				<tr>
					<td align="left">${selectedProduct.pro_id}</td>
					<td align="left">${selectedProduct.pro_name}</td>
					<td align="left">${selectedProduct.pro_description}</td>
					<td align="left">${selectedProduct.pro_price}</td>
					<%-- <td align="left">${SelectedProduct.category.name}</td>
					<td align="left">${SelectedProduct.supplier.name}</td> --%>
				</tr>
			</table>

	</div>
</body>
</html>