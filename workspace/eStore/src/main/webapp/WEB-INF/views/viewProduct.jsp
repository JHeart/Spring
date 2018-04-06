<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>
		Product Detail
	</h1>
	<h4>Here is the detail information of the prduct!</h4>
	<div class="row">

		<div class="col-md-6">
			<c:set var="imageFilename"
				value="/resources/images/${product.id}.png" />
			
			<img src="<c:url value="${imageFilename}" />" alt="image" style="width: 70%" />
			<div class="col-md-6">
				<h3>${product.name}</h3>
				<p>${product.description}</p>
				<p><strong>Category:</strong> ${product.category}</p>
				<p>${product.price}원</p>
			</div>

		</div>
		</div>
</body>
</html>