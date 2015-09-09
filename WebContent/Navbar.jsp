<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.14.0/jquery.validate.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.14.0/jquery.validate.min.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.14.0/additional-methods.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.14.0/additional-methods.min.js"></script>
<title>Comments area</title>
<style>h1{background: black; text:white}</style>
<style>
img{
    position: relative;
    width: 100px;
    height: 100px;
    float: right;
    border: 3px solid #8AC007;

}

p.navbar-text{
position: relative;
float: right;
right: 0px;
}

</style>

</head>
<body background="http://www.freewallpaperfullhd.com/wp-content/uploads/2015/02/Nature-Wallpaper-HD-1920x1080.jpg">
<nav class="navbar navbar-default" >
	<ul class="nav navbar-nav navbar-left">
	   <li role="presentation" >Welcome <b>${sessionScope.User.getFirstName()} ${sessionScope.User.getLastName()} </b></li>
	   <c:choose>
	   <c:when test="${sessionScope.User.getFirstName() != ('Customer')}">   
	      <li role="presentation"><a href="/Shopping_cart/My_Profile"><span class="glyphicon glyphicon-user"></span>Profile</a></li>
	   </c:when>
	   </c:choose>
	   

		  <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
		    ToDoList
		    <span class="caret"></span>
		  </button>
		  <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
		    <li><a href="#">Add to do list</a></li>
		    <li><a href="#">Edit to do list</a></li>
		    <li><a href="#">Delete to do list</a></li>

		  </ul>

	   
	</ul>
	<ul class="nav navbar-nav navbar-right">
	<c:choose>
	<c:when test="${sessionScope.User.getFirstName() == ('Customer')}">
	    <li role="presentation"><a  href="/Shopping_cart/SignIn.jsp">Sign in</a></li>
	    <li role="presentation"><a  href="/Shopping_cart/SignUp.jsp">Create account</a></li>
	 </c:when>
	 <c:otherwise>
	   <li role="presentation"><a  href="/Shopping_cart/Logout?click=1">Sign out</a></li>
	 </c:otherwise>
	 </c:choose>
	 
    </ul>
</nav>

</body>
</html>
