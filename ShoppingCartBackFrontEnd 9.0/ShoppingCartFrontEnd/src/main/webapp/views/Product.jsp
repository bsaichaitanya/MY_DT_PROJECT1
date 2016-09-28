 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<link rel="stylesheet"href="<c:url value="/resources/admin.css"/>">
<html>
<head>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Product Page</title>
</head>
<body>
${msg}
<h2 align="center"> Add product</h2>
<c:url var="addAction" value="product/add"></c:url>
<form:form action="${addAction}" class="form-responsive" commandName="product" enctype="multipart/form.data" method="POST">
<table align="center">
	<tr>
			<td><form:label path="pro_id"> <spring:message text="ID"/></form:label></td>
					<c:choose>
							<c:when test="${!empty product.pro_id}">
							<td><form:input path="pro_id" readonly="true" class="form-control" /> </td>
							</c:when>
									
							 <c:otherwise>
							 <td><form:input path="pro_id" pattern="{5,10}" required="true" title="id should be between 5 to 10 characters" class="form-control" /> </td>
							 </c:otherwise>
					</c:choose>
			</tr>
		<tr>
			<td><form:label path="pro_name"> <spring:message text="NAME"/></form:label></td>
			<td><form:input path="pro_name" required="true" class="form-control" /> </td>
		</tr>
		
		<tr>
			<td><form:label path="pro_description"> <spring:message text="DESCRIPTION"/></form:label></td>
			<td><form:input path="pro_description" required="true" class="form-control" /> </td>
		</tr>
		
		<tr>
			<td><form:label path="pro_price"> <spring:message text="PRICE"/></form:label></td>
			<td><form:input path="pro_price" required="true" class="form-control" /> </td>
		</tr>
							
	       <tr>
	  <td><form:label path="supplier"><spring:message text="Supplier"/></form:label></td>
	  
	  <td><form:select path="supplier_id">
	           <c:forEach items="${supplierList}" var="supplier">
								<form:option value="${supplier.sup_id}">${supplier.sup_name}</form:option>
							</c:forEach>
							</form:select>
							</td>
	           </tr>
	           
	       <tr>
	  <td><form:label path="category"><spring:message text="Category"/></form:label></td>
	  <td><form:select path="category_id"  >
	           <c:forEach items="${categoryList}" var="category">
								<form:option  value="${category.cat_id}">${category.cat_name}</form:option>
							</c:forEach>
							</form:select>
							</td>
	           </tr> 
	         <%--   <tr>
	              <td align="left"><form:label path="image"><spring:message text="Image"/>
	                </form:label></td>
	                <td align="left"><form:input type="file" name="image" path="image"/></td>
	                </tr>	 --%>
		<tr>
			<td colspan="2">
			<c:if test="${!empty product.pro_name}">
			<input type="submit" class="btn btn-primary" value="<spring:message text="Edit product"/> "> 
			</c:if>
			<c:if test="${empty product.pro_name}">
			<input type="submit" class="btn btn-primary" value="<spring:message text="Add product"/> "> 
			</c:if>
			</td>

		</tr>
</table>
</form:form>
<br>

	              
	             
	            <h3>Product List</h3>
<c:if test="${!empty productList}">
	<div class="table-responsive">
		<table  class="table table-hover">
	<tr>
		<th>Id</th>
		<th> Name</th>
		<th>Description</th>
				<th>Price</th>
					<th>Category</th>
						<th>Supplier</th>
						<!-- <th width="120">Image</th> -->
		<th>Edit</th>
		<th>Delete</th>
	</tr>
	<c:forEach items="${productList}" var="product">
		<tr>
			<td>${product.pro_id}</td>
			<td>${product.pro_name}</td>
			<td>${product.pro_description}</td>
			<td>${product.pro_price}</td>
			<td>${product.category_id}<td>
			<td>${product.supplier_id} </td>
			<%-- <td><div class="thumbnail">
								<img height="100px" width="100px" alt="${product.pro_id }"
									src="<c:url value="D:\images/${product.pro_id }.jpg"></c:url>"> --%>
			<td><a href="<c:url value="product/edit/${product.pro_id}"/>" >Edit</a></td>
			<td><a href="<c:url value="product/remove/${product.pro_id}"/>" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
	</div>
</c:if>
</body>
</html> 