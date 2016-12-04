<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<style>
ul li{

    padding: 5px;
}

.jumbotron {
padding-top: 60px;
    padding-bottom: 230px;
    margin-top: 50px;
}
}

</style>
</head>
<body>
<div class="container">
				<div class="jumbotron">
					  <div class="col-md-12">
			                                <div class="col-md-6">
               <img src="<c:url value="E:\\workspace\\ShoppingCartFrontEnd\\src\\main\\resources\\images\\${product.pro_id}.jpg"/>" alt="image" style="width:50%">   
                  
              
        							</div>
                <div class="col-md-6">
			<ul class="list-unstyled">
			
					<li ><em>Product: ${product.pro_name}</em></li>
					<li > <em>Description: ${product.pro_description}</em></li>
					<li><em>Price: Rs. ${product.pro_price}</em></li>
					<li ><em>Category: ${product.category.cat_name}</em></li>
					<li > <em>Supplier: ${product.supplier.sup_name}</em></li>
<li><a href="<c:url  value="/addtocart/${product.pro_id}" />"> 
	<img  src="E:\PROJECT 1\pics\addtocart-orange.png" width="200px" height="60px"></a></li> 
			
        	</ul> 
</div>
	    </div> 

				
				</div>


			</div>

</body>
</html>