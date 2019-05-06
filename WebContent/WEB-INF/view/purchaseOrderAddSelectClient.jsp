<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>
<head>
	<title>List Clients</title>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/mainActions.js" ></script>
	<script src="${pageContext.request.contextPath}/resources/js/jquery.js" ></script>
	 <script>$(document).ready(runWhenDocReady());</script>	
	<!-- '${pageContext.request.contextPath}' is the name of the app -->
	<link type="text/css" rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/mainStyle.css" />
</head>

<body>

<!-- Navigation Panel -->
<input type="submit" value=">>>"  onclick="showNavi()" class="showNavi"/>
<div id="naviPanelId" class="naviPanel">
  <a href="javascript:void(0)" class="hideButton" onclick="hideNavi()">&times;</a>
	<table class="naviTable" id="naviTable">
	<tbody>						
		<tr class="naviItem" ><td><a href="${pageContext.request.contextPath}/app/dashboard" onclick="showPleaseWait()">Dashboard</a></td></tr>				
		<tr class="naviItem" ><td><a href="${pageContext.request.contextPath}/client/list" onclick="showPleaseWait()">Clients List</a></td></tr>
		<tr class="naviItem" ><td><a href="${pageContext.request.contextPath}/purchaseOrder/list" onclick="showPleaseWait()">Orders List</a></td></tr>
		<tr class="naviItem" ><td><a href="${pageContext.request.contextPath}/app/goodbye" onclick="showPleaseWait()">Log out</a></td></tr>															
  	</tbody>
  	</table>
</div>
<div id="pleaseWaitId" class="pleaseWait">
	<div class="pleaseWaitText">Please wait...</div>
</div>
<!-- Navigation Panel End -->

<!-- Main Content Page  -->
<div id="mainContentId">

	<div id="wrapper">
		<div id="header0"><p>Purchase Orders Management  -  Java Spring Demo Project by Tomasz Gomoradzki</p></div>
		<div id="header1"><h2>Select Client and Move to Order Details</h2></div>
		<div id="header"><h2></h2></div>
	</div>	
	
<div id="container">
<div id="content">
<div>				    					
	<form name="purchaseOrder" id="formpurchaseOrderAddForm1" action="purchaseOrderAddForm" method="POST"> 
	<%-- <form name="purchaseOrder" id="formpurchaseOrderAddForm" method="POST"> --%>
		
	<%-- Search box --%>
	<%-- Form action="purchaseOrderAddSearchClient" method="POST" --%>
    <input type="text" name="srchName" class="inputtxtbox" placeholder="Enter client's name..." />               
    <input type="button" value="Search" class="button" onclick="return purchaseOrderAddSearchClient();" />           
	
	<%-- Form  Submit action="purchaseOrderAddForm" --%>
	<input type="submit" value="Next" class="button" onclick="return checkSelectedClient();"/>	
	
		
<script>
	$(document).ready(function(){
		$('#formpurchaseOrderAddFrom1').submit(function() {			
		return checkSelectedClient();
	});
	}); 
</script>
		   		   	  
<table>
	<tr><%-- table headers --%>								
		<th>Client ID</th>
		<th>First Name</th>
		<th>Last Name</th>
		<th>City</th>			
	</tr>		
		
	<!-- loop over and print our clients -->
	<c:forEach var="tempClient" items="${clients}">	
		<tr>		
			<td> 
				<input type="radio" class="radio" name="clientId" id="idclientId" value=${tempClient.client_id}> ${tempClient.client_id} <BR>
			</td>
								
			<td> ${tempClient.firstName} </td>
			<td> ${tempClient.lastName} </td>
			<td> ${tempClient.city} </td>		 			
		</tr>			
	</c:forEach>						
	
	</table>
	
	</form> 				
	</div>
	</div>
	</div>
	</div>
</body>
</html>









