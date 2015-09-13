<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
  <script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/js/bootstrap-datepicker.min.js"></script>
  <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/css/datepicker.min.css" />
<link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/css/datepicker3.min.css" />
<link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" type="text/css" />

<title></title>

</head>
<body >
<nav class="navbar navbar-default" >
	<ul class="nav navbar-nav navbar-left">
	   <li role="presentation" >Welcome <b>${sessionScope.User.getFirstName()} ${sessionScope.User.getLastName()} </b></li>
	   <c:choose>
	   <c:when test="${sessionScope.User.getFirstName() != ('Customer')}">   
	      <li role="presentation"><a href="/todolist/My_Profile"><span class="glyphicon glyphicon-user"></span>Profile</a></li>
	   </c:when>
	   </c:choose>
	   
	   
	  <li role="presentation" class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown"  role="button">
         To-Do List <span class="caret"></span>
         </a>
          <ul class="dropdown-menu">
           <li><a href="/ToDoList/Show">Show to-do list</a></li>
            <li><a href="/ToDoList/Addlist">Add to-do list</a></li>
            <li><a href="/ToDoList/Edit">Edit to-do list</a></li>
            <li><a href="/ToDoList/Remove">Remove to-do list</a></li>
         </ul>
         
         </li>
   
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
