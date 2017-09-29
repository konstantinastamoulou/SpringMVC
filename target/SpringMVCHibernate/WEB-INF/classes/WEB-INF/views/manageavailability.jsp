<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Upload/Download/Delete Documents</title>
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>
	
	<%@include file="/WEB-INF/templates/menu.jsp" %>

	<div class="generic-container">
		<div class="panel panel-default">
			  <!-- Default panel contents -->
		  	<div class="panel-heading"><span class="lead">Availability for ${appartment.id} </span></div>
		  	<div class="tablecontainer">
				<table class="table table-hover">
		    		<thead>
			      		<tr>
					        <th>from</th>
					        <th>to</th>
						</tr>
			    	</thead>
		    		<tbody>
					<c:forEach items="${avs}" var="av" varStatus="counter">
						<tr>
							<td>${av.date_from}</td>
							<td>${av.date_to}</td>
							<td><a href="<c:url value='/delete-availability/${av.id}' />" class="btn btn-danger custom-width">delete</a></td>
						</tr>
					</c:forEach>
		    		</tbody>
		    	</table>
		    </div>
		</div>
		<div class="panel panel-default">
			
			<div class="panel-heading"><span class="lead">Upload New Availability</span></div>
			<div class="uploadcontainer">
				<form:form method="POST" modelAttribute="newavailability" class="form-horizontal">
			
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-3 control-lable" for="date_from">date_from</label>
							<div class="col-md-7">
								<form:input type="text" path="date_from" id="date_from" class="form-control input-sm"/>
							</div>							
						</div>
					</div>			
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-3 control-lable" for="date_to">date_to</label>
							<div class="col-md-7">
								<form:input type="text" path="date_to" id="date_to" class="form-control input-sm"/>
							</div>							
						</div>
					</div>
			
					<div class="row">
						<div class="form-actions floatRight">
							<input type="submit" value="Upload" class="btn btn-primary btn-sm">
						</div>
					</div>
	
				</form:form>
				</div>
		</div>
	 	<div class="well">
	 		Go to <a href="<c:url value='/list' />">Users List</a>
	 	</div>
   	</div>
</body>
</html>



