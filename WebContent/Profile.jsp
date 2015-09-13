<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<title>My Profile</title>

</head>
<body >
<jsp:include page="Navbar.jsp"/>
<br><br><br><br>
<div class="panel panel-primary col-sm-5 col-sm-offset-4">
		<div class= "panel-heading">
                 
			Person Detail
		</div>	
		<div class ="panel-body">
	  		<p><span class="glyphicon glyphicon-user"></span><b> Name:  </b> ${sessionScope.User.getFirstName()} ${sessionScope.User.getLastName()}</p> 
    		<p><span class="glyphicon glyphicon-envelope"> </span><b> Email Address: </b>${sessionScope.User.getEmail()}  </p>
    		<p><span class="glyphicon glyphicon-calendar"> </span><b> Join Date: </b>${sessionScope.User.getJoinDate()}  </p>
	</div>
</div>

<br><br><br><br><br><br><br><br><br><br>
<div class="container">

  <c:if test="${not empty my_finished_list}">
  <label style="color:green;"> Finished duties</label>           
  <table class="table table-bordered">
    <thead>
      <tr>
        <th>Description</th>
        <th>Completed date</th>
        <th>Due Date</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach var="list_item" items="${my_finished_list}">
     <tr>
        <td>${list_item.getDescription() }</td>
        <td>${list_item.getCompletedDate() }</td>
        <td>${list_item.getDueDate() }</td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
  </c:if>
   <c:if test="${not empty my_required_list}">
    <label style="color:red;"> Needed to work on</label>           
  <table class="table table-bordered">
    <thead>
      <tr>
        <th>Description</th>
        <th>Completed date</th>
        <th>Due Date</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach var="list_item" items="${my_required_list}">
     <tr>
        <td>${list_item.getDescription() }</td>
        <td>${list_item.getCompletedDate() }</td>
        <td>${list_item.getDueDate() }</td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
  </c:if>
</div>

  
</body>
</html>