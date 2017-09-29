<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Add Appartment</title>
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
	<script src="https://maps.googleapis.com/maps/api/js?v=3.exp&key=AIzaSyBb1RNXUCykfyMGVwB65glSywK6T3pHAXg"></script>
	<script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
	
	<script>
		var map;
		var marker;
		function initialize() {
		  var mapOptions = {
		    zoom: 8,
		    center: new google.maps.LatLng(-34.397, 150.644)
		  };
		  map = new google.maps.Map(document.getElementById('map-canvas'),
		      mapOptions);
		  
		  google.maps.event.addListener(map, 'click', function(event) {
			   placeMarker(event.latLng);
			});

			
		}
		
		google.maps.event.addDomListener(window, 'load', initialize);
				
		function placeMarker(location) {
			
			if(marker!=null)
				marker.setMap(null);
			
		    marker = new google.maps.Marker({
		        position: location, 
		        map: map
		    });
		    
		    console.log(marker);
		    $("#latitude").val(marker.position.lat);
		    $("#longitude").val(marker.position.lng);
		}
	</script>
	
</head>

<body>

	<%@include file="/WEB-INF/templates/menu.jsp" %>

 	<div class="generic-container">
	<div class="well lead">Add Appartment</div>
 	<form:form method="POST" modelAttribute="appartment" class="form-horizontal" name="regform">
		<form:input type="hidden" path="id" id="id"/>
		
		<div class="row">		
			<div class="form-group col-md-12">
				<div id="map-canvas" style="height:300px; width:500px"></div>
			</div>		
		</div>
		
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="latitude">Latitude</label>
				<div class="col-md-7">
					<form:input type="text" path="latitude" id="latitude" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="latitude" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="longitude">Longitude</label>
				<div class="col-md-7">
					<form:input type="text" path="longitude" id="longitude" class="form-control input-sm" />
					<div class="has-error">
						<form:errors path="longitude" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="description">Description</label>
				<div class="col-md-7">
					<form:input type="text" path="description" id="description" class="form-control input-sm" />
					<div class="has-error">
						<form:errors path="description" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="address">Address</label>
				<div class="col-md-7">
					<form:input type="text" path="address" id="address" class="form-control input-sm" />
					<div class="has-error">
						<form:errors path="address" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="access_through_pt">access_through_pt</label>
				<div class="col-md-7">
					<form:input type="text" path="access_through_pt" id="access_through_pt" class="form-control input-sm" />
					<div class="has-error">
						<form:errors path="access_through_pt" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="description">max_no_renters</label>
				<div class="col-md-7">
					<form:input type="number" path="max_no_renters" id="max_no_renters" class="form-control input-sm" />
					<div class="has-error">
						<form:errors path="max_no_renters" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="base_rate">base_rate</label>
				<div class="col-md-7">
					<form:input type="number" path="base_rate" id="base_rate" class="form-control input-sm" />
					<div class="has-error">
						<form:errors path="base_rate" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="base_rate_no_renters">base_rate_no_renters</label>
				<div class="col-md-7">
					<form:input type="number" path="base_rate_no_renters" id="base_rate_no_renters" class="form-control input-sm" />
					<div class="has-error">
						<form:errors path="base_rate_no_renters" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="extra_cost_per_renter">extra_cost_per_renter</label>
				<div class="col-md-7">
					<form:input type="number" path="extra_cost_per_renter" id="extra_cost_per_renter" class="form-control input-sm" />
					<div class="has-error">
						<form:errors path="extra_cost_per_renter" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="general_rules">general_rules</label>
				<div class="col-md-7">
					<form:input type="text" path="general_rules" id="general_rules" class="form-control input-sm" />
					<div class="has-error">
						<form:errors path="general_rules" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="no_beds">no_beds</label>
				<div class="col-md-7">
					<form:input type="number" path="no_beds" id="description" class="form-control input-sm" />
					<div class="has-error">
						<form:errors path="no_beds" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="no_baths">no_baths</label>
				<div class="col-md-7">
					<form:input type="number" path="no_baths" id="no_baths" class="form-control input-sm" />
					<div class="has-error">
						<form:errors path="no_baths" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="no_bedrooms">no_bedrooms</label>
				<div class="col-md-7">
					<form:input type="number" path="no_bedrooms" id="no_bedrooms" class="form-control input-sm" />
					<div class="has-error">
						<form:errors path="no_bedrooms" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="living_room">living_room</label>
				<div class="col-md-7">
					<form:checkbox path="living_room"/>
					<div class="has-error">
						<form:errors path="living_room" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="size">size</label>
				<div class="col-md-7">
					<form:input type="number" path="size" id="size" class="form-control input-sm" />
					<div class="has-error">
						<form:errors path="size" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="form-actions floatRight">
				<c:choose>
					<c:when test="${edit}">
						<input type="submit" value="Update" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/' />">Cancel</a>
					</c:when>
					<c:otherwise>
						<input type="submit" value="Register" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/' />">Cancel</a>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
		<c:if test="${edit}">
            <span class="well pull-left">
                <a href="<c:url value='/add-document/${user.id}' />">Click here to upload/manage your documents</a>   
            </span>
        </c:if>
	</form:form>
	</div>
</body>
</html>