<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<strong>test</strong>
	<ul>
		<strong><li>test <%=new java.util.Date()%></li></strong>
		<%! private int accessCount =0; %>
		
		<%= ++accessCount %>
	</ul>
	<h3>test1</h3>
	<%=session.getId() %>
	
	<h4>test2</h4>
	<%=request.getHeader("User-Agent") %>
	
	<%-- JSP 1.2(old) --%>
  <c:forEach var="i" begin="1" end="10" step="1">
      <c:out value="${i}" />
      <br />
   </c:forEach>
  
	
</body>
</html>