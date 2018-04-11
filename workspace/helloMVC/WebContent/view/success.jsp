<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%--JSP Expression Language --%>
	<ul>
		<li>Id: ${customer.id }</li>
		<li>Name: ${customer.id }</li>
		<li>Email: ${customer.email }</li>
	</ul>
	
	<%--JSTL --%>
	<table>
		<c:forEach var="customer" items="${customers}">
			<tr>
				<td>${customer.id}</td>
				<td>${customer.name}</td>
				<td>${customer.email}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>