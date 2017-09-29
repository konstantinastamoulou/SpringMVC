	<nav class="navbar navbar-default">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-brand" href="#">WebSiteName</a>
	    </div>
	    <ul class="nav navbar-nav">
	      <li class="active"><a href="/">Home</a></li>
	      <li><a href="<c:url value='/list' />">Users List</a></li>
	      <li><a href="<c:url value='/search' />">Search</a></li>
	      <li><a href="<c:url value='/login' />">Login</a></li>
	      <li><a href="<c:url value='/newuser' />">SignUp</a></li>
	      <li><a href="<c:url value='/add-appartment' />">Add Appartment</a></li>
	      <li><a href="<c:url value='/my-appartments' />">My Appartments</a></li>
	      	      
	      <c:if test="${not empty sessionScope.logged_user}">
		  		<h3>Hello, ${logged_user.username}</h3>   
		  </c:if>
	      
	    </ul>
	  </div>
	</nav>