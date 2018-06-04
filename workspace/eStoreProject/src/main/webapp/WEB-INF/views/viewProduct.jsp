<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<script src="<c:url value="/resources/js/controller.js"/>"></script>
	
<div class="container-wrapper">
	<div class="container" ng-app="cartApp">
		<h2>Product Detail</h2>
		<br />
		<h4>Here is the detail information of the product!</h4>

		<div class="row" ng-controller="cartCtrl">
			<div class="col-md-6">
				<%-- <c:set var="imageFilename"
					value="/resources/images/${product.id}.jpg" />
				<img src="<c:url value="${imageFilename}"/>" alt="image"
					style="width: 80%" /> --%>
				<img
					src="<c:url value="/resources/images/${product.imageFilename}"/>"
					alt="image" style="width: 80%" />
			</div>

			<div class="col-md-6">
				<h3>${product.name}</h3>
				<p>
					Manufacturer : ${product.manufacturer}<br /> 
					Description :  ${product.description}<br />
					Category : ${product.category}<br />
					${product.price}원<br />
				</p>
				<br />
				<c:if test="${pageContext.request.userPrincipal.name !=null}">
					<p>
						<a href="<c:url value="/products"/>" class="btn btn-danger">Back</a>

						<button class="btn btn-warning btn-large" ng-click="addToCart('${product.id}')">
							<i class="fa fa-shopping-cart"></i>Oreder Now
						</button>

						<a href="<c:url value="/cart" />" class="btn btn-info"> 
							<i class="fa fa-eye"></i>View Cart
						</a>
					</p>
				</c:if>
			</div>

		</div>
	</div>
</div>
