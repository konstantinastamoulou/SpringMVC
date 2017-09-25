<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>User Page</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>
<h1>
	Add a User
</h1>

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
			<form:select path="roles">
			    <form:options items="${listRoles}" itemValue="id" itemLabel="name" />
			</form:select>	
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
<br>
<h3>user List</h3>
<c:if test="${!empty listUsers}">
	<table class="tg">
	<tr>
		<th width="80">user ID</th>
		<th width="120">user Name</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listUsers}" var="user">
		<tr>
			<td>${user.id}</td>
			<td>${user.name}</td>
			<td><a href="<c:url value='/user/edit/${user.id}' />" >Edit</a></td>
			<td><a href="<c:url value='/user/remove/${user.id}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>
