<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<div class="container-wrapper">
	<div class="container">
		<h2>Product Inventory</h2>
		
		<p>제품 재고 현황입니다.</p>
		<table class="table table-striped">
			<thead>
				<tr class="bg-success">
					<th>Photo Thumb</th>
					<th>Name</th>
					<th>Category</th>
					<th>Price</th>
					<th>Manufacturer</th>
					<th>UnitInStock</th>
					<th>Description</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="product" items="${products}">
					<tr>
					<td><img src="<c:url value="/resources/images/${product.imageFilename}"/>"
							alt="image" style="width:100%"/></td>
						<td>${product.name}</td>
						<td>${product.category}</td>
						<td>${product.price}</td>
						<td>${product.manufacturer}</td>
						<td>${product.unitInStock}</td>
						<td>${product.description}</td>
						<td>
							<a href="<c:url value="/admin/productInventory/deleteProduct/${product.id}"/>"><i class="fa fa-times"></i></a>
							<a href="<c:url value="/admin/productInventory/updateProduct/${product.id}"/>"><i class="fa fa-edit"></i></a>
							<a href="<c:url value="/admin/productInventory/products/${product.id}"/>"><i class="fa fa-info-circle"></i></a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<a href="<c:url value="/admin/productInventory/addProduct"/>" class="btn btn-primary" >Add Product</a>
		
	</div>

</div>



<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>



<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>

</body>
</html>
