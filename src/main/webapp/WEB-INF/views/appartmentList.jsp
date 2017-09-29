<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>My Appartments</title>
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>
	
	<%@include file="/WEB-INF/templates/menu.jsp" %>

	<div class="generic-container">
		<div class="panel panel-default">
			  <!-- Default panel contents -->
		  	<div class="panel-heading"><span class="lead">My Appartments </span></div>
			<table class="table table-hover">
	    		<thead>
		      		<tr>
				        <th>description</th>
				        <th>latitude</th>
				        <th>longitude</th>
				        <th width="100"></th>
				        <th width="100"></th>
					</tr>
		    	</thead>
	    		<tbody>
				<c:forEach items="${appartments}" var="appartment">
					<tr>
						<td>${appartment.description}</td>
						<td>${appartment.latitude}</td>
						<td>${appartment.longitude}</td>
						<td><a href="<c:url value='/edit-appartment/${appartment.id}' />" class="btn btn-success custom-width">edit</a></td>
						<td><a href="<c:url value='/delete-appartment/${appartment.id}' />" class="btn btn-danger custom-width">delete</a></td>
					</tr>
				</c:forEach>
	    		</tbody>
	    	</table>
		</div>
	 	<div class="well">
	 		<a href="<c:url value='/add-appartment' />">Add New Appartment</a>
	 	</div>
   	</div>
</body>
</html>