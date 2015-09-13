<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<link href="http://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/css/datepicker.css" rel="stylesheet" type="text/css" />
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="http://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/js/bootstrap-datepicker.js"></script>
<script type="text/javascript" src="/bower_components/jquery/jquery.min.js"></script>
  <script type="text/javascript" src="/bower_components/moment/min/moment.min.js"></script>
  <script type="text/javascript" src="/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="/bower_components/eonasdan-bootstrap-datetimepicker/build/js/bootstrap-datetimepicker.min.js"></script>
  <link rel="stylesheet" href="/bower_components/bootstrap/dist/css/bootstrap.min.css" />
  <link rel="stylesheet" href="/bower_components/eonasdan-bootstrap-datetimepicker/build/css/bootstrap-datetimepicker.min.css" />
  <script src="bootstrap-datepicker.js"> </script>
  
  
  <meta charset="utf-8">
  <title>jQuery UI Datepicker - Default functionality</title>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script>
  $(function() {
    $( "#datepicker" ).datepicker();
  });
  </script>
<title>Edit</title>

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
      </tr>
    </thead>
    <tbody>
    <c:forEach var="list_item" items="${all_list}">
     <form action="Edit" method="get">
     <tr>
        <td>${list_item.getDescription() }</td>
        <td>${list_item.getDateCompleted() }</td>
        
        <div class="col-sm-4">
        <td><input class="form-control " type="text"  name="datepicker" id="datepicker" value="${list_item.getDuetDate() }"></td>
        </div>
        <td>
       
        <div class="form-group ">               
               <select class="form-control" name="status" value="${list_item.getStatus() }">
               
				<c:if test="${list_item.getStatus().equalsIgnoreCase('completed')}">  
				  <option selected="selected" >Completed</option>
				  <option >In progress</option>
				  <option >On hold</option></c:if>
				<c:if test="${list_item.getStatus().equalsIgnoreCase('in progress')}">  
				  <option  >Completed</option>
				  <option selected="selected" >In progress</option>
				  <option >On hold</option></c:if>
				<c:if test="${list_item.getStatus().equalsIgnoreCase('on hold')}">  
				  <option  >Completed</option>
				  <option  >In progress</option>
				  <option selected="selected">On hold</option></c:if>

				</select>
				</div>
        </td>
        
        <td>
        <div class="form-group">               
                <select class="form-control" name="priority" value="${list_item.getProirity() }" >
                <c:if test="${list_item.getProirity().equalsIgnoreCase('very high')}">  
				  <option selected="selected">Very high</option>
				  <option>High</option>
				  <option >Low</option>
				  <option >Very low</option></c:if>
				  
				<c:if test="${list_item.getProirity().equalsIgnoreCase('high')}">  
				  <option >Very high</option>
				  <option selected="selected">High</option>
				  <option >Low</option>
				  <option >Very low</option></c:if>
				  
				<c:if test="${list_item.getProirity().equalsIgnoreCase('Low')}">  
				  <option >Very high</option>
				  <option >High</option>
				  <option selected="selected">Low</option>
				  <option >Very low</option></c:if>
				  
				  
				<c:if test="${list_item.getProirity().equalsIgnoreCase('Very low')}">  
				  <option >Very high</option>
				  <option >High</option>
				  <option >Low</option>
				  <option selected="selected">Very low</option></c:if>
				</select>
					
	          
	            <input type="hidden" name="list_id" value="${list_item.getId()}">
	           	<button type="submit"  value = "submit" class= "button btn-primary form-control" style="width:40%;">Edit</button>
	           	</div>
	          
  				
  
		</td>
	
      </tr>
      </form>
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