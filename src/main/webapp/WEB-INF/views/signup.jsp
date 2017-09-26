<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
  	<meta name="viewport" content="width=device-width, initial-scale=1">
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>SignUp</title>
</head>
<body>

	<nav class="navbar navbar-default">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-brand" href="#">WebSiteName</a>
	    </div>
	    <ul class="nav navbar-nav">
	      <li><a href="/">Home</a></li>
	      <li><a href="/SpringMVCHibernate/users">Users List</a></li>
	      <li><a href="/SpringMVCHibernate/search">Search</a></li>
	      <li><a href="/SpringMVCHibernate/login">Login</a></li>
	      <li class="active"><a href="/SpringMVCHibernate/signup">SignUp</a></li>
	    </ul>
	  </div>
	</nav>

	<div class="container">
		<h3>SignUp</h3>
		
		<div>
		
			<c:url var="addAction" value="/user/add" ></c:url>
			<form:form action="${addAction}" commandName="user">
				<table>
					<c:if test="${!empty user.name}">
					<tr>
						<td>
							<form:label path="id">
								<spring:message text="ID"/>
							</form:label>
						</td>
						<td>
							<form:input path="id" readonly="true" size="8"  disabled="true" />
							<form:hidden path="id" />
						</td> 
					</tr>
					</c:if>
					<tr>
						<td>
							<form:label path="name">
								<spring:message text="Name"/>
							</form:label>
						</td>
						<td>
							<form:input path="name" />
						</td> 
					</tr>
					<tr>
						<td>
							<form:label path="surname">
								<spring:message text="Surname"/>
							</form:label>
						</td>
						<td>
							<form:input path="surname" />
						</td> 
					</tr>	
					<tr>
						<td>
							<form:label path="email">
								<spring:message text="Email"/>
							</form:label>
						</td>
						<td>
							<form:input path="email" />
						</td> 
					</tr>
					<tr>
						<td>
							<form:label path="img_source">
								<spring:message text="IMG SOURCE (TODO: as uploading mechanism)"/>
							</form:label>
						</td>
						<td>
							<form:input path="name" />
						</td>
					</tr>
					
					<tr>
						<td>
							<form:label path="roles">
								<spring:message text="Role(s)"/>
							</form:label>
						</td>
						<td>
							<%--<form:select path="roles">
							    <form:options items="${listSignUpRoles}" itemValue="id" itemLabel="name"/>
							</form:select>--%>
							<%--<form:select path="roles" name="roles">
							    <c:forEach var="item" items="${listSignUpRoles}">
							        <option value="${item.id}">${item.name}</option>
							    </c:forEach>
							</form:select>--%>
							<form:select path="roles" items="${listSignUpRoles}" multiple="true" itemValue="id" itemLabel="name" class="form-control input-sm" />
						</td> 
					</tr>
					
					<tr>
						<td colspan="2">
							<c:if test="${!empty user.name}">
								<input type="submit"
									value="<spring:message text="Edit user"/>" />
							</c:if>
							<c:if test="${empty user.name}">
								<input type="submit"
									value="<spring:message text="Add user"/>" />
							</c:if>
						</td>
					</tr>
				</table>
			</form:form>		
		</div>
		
	</div>

</body>
</html>



