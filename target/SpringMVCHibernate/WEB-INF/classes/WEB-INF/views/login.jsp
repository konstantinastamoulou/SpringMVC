<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
	<title>Login</title>
</head>
<body>

	<%@include file="/WEB-INF/templates/menu.jsp" %>
	<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
	<div class="container">

	    <form method="POST" action="loginProcess" class="form-signin" modelAttribute="luser" >
	        <h2 class="form-heading">Log in</h2>	
	        <div class="form-group ${error != null ? 'has-error' : ''}">
	            <span>${message}</span>
	            <input path="username" name="username" type="text" class="form-control" placeholder="Username"
	                   autofocus="true"/>
	            <input path="password" name="password" type="password" class="form-control" placeholder="Password"/>
	            <span>${error}</span>
	
	            <button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button>
	            <h4 class="text-center"><a href="<c:url value='/newuser' />">Create an account</a></h4>
	        </div>	
	    </form>
	
	</div>


</body>
</html>