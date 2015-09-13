<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>


</head>
<body >
<jsp:include page="Navbar.jsp"/>
<br><br><br><br>




<div class="container">

  <c:if test="${! all_list.isEmpty()}">
  <label style="color:green;"> all duties</label>           
  <table class="table table-bordered">
    <thead>
      <tr>
        <th>Description</th>
        <th>Completed date</th>
        <th>Due Date</th>
        <th>Status</th>
        <th>Priority</th>
        <th></th>
      </tr>
    </thead>
    <tbody>
    <c:forEach var="list_item" items="${all_list}">

     <tr>
        <td>${list_item.getDescription() }</td>
        <td>${list_item.getDateCompleted() }</td>
        <td>${list_item.getDuetDate() }</td>
        <td>${list_item.getStatus() }</td>
        <td>${list_item.getProirity() } </td>   
	
      </tr>
    </c:forEach>
    </tbody>
  </table>
  </c:if>
  <c:if test="${empty all_list}">
     <p>You have nothing to do</p>
  </c:if>
 
  </div>





  
</body>
</html>