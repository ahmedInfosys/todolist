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
<body >
<jsp:include page="Navbar.jsp"/>

 

<div class="panel panel-primary col-sm-5 col-sm-offset-4">
		<div class= "panel-heading">
                 
			Person Detail
		</div>	
		<div class ="panel-body">
	  		<p><span class="glyphicon glyphicon-user"></span><b> Name:  </b> ${sessionScope.User.getFirstName()} ${sessionScope.User.getLastName()}</p> 
    		<p><span class="glyphicon glyphicon-envelope"> </span><b> Email Address: </b>${sessionScope.User.getEmail()}  </p>
    		
	</div>
</div>

  
</body>
</html>