<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<div class="container-wrapper">
	<div class="container">
		<h2>Login with username and password</h2>
		
		<c:if test="${not empty errorMsg }">
			<div style="color:#ff0000;"><h3>${errorMsg }</h3></div>
		</c:if>
		
		
		<c:if test="${not empty logoutMsg}">
			<div style="color:#0000ff;"><h3>${logoutMsg}</h3></div>
		</c:if>
		
		
		<form action="<c:url value="/login"/>" method="post"><!--html form을 사용하면 csrf를 전송해야 한다. -->
			<div class="form-group">
				<label for="username">Username:</label> <input type="text"
					class="form-control" id="username" placeholder="Enter username"
					name="username" style="width: 50%">
			</div>

			<div class="form-group">
				<label for="pwd">Password:</label> <input type="password"
					class="form-control" id="pwd" placeholder="Enter password"
					name="password" style="width: 50%">
			</div>


			<!-- <div class="form-check">
				<label class="form-check-label"> <input
					class="form-check-input" type="checkbox" name="remember">
					Remember me
				</label>
			</div> -->

			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
</div>



