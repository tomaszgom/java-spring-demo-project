<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>
<head>
	<title>List Clients</title>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/mainActions.js" ></script>
	<script src="${pageContext.request.contextPath}/resources/js/jquery.js" ></script>
	<!-- <script>$(document).ready(runWhenDocReady());</script>	-->
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
		<tr class="naviItem" ><td><a href="${pageContext.request.contextPath}/porder/list" onclick="showPleaseWait()">Orders List</a></td></tr>
		<tr class="naviItem" ><td><a href="${pageContext.request.contextPath}/app/goodbye" onclick="showPleaseWait()">Exit</a></td></tr>															
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
		<div id="header0"><p>Java Spring Demo Project by Tomasz Gomoradzki</p></div>
		<div id="header1"><h2>Purchase Orders Management</h2></div>
		<div id="header1"><h2>Select client and add order details</h2></div>
		<div id="header"><h2></h2></div>
	</div>	
	<div id="container">
	<div id="content">
	<div>		
	
	
		    <!-- Search box -->
       <%--  <form:form action="pOrderAddSearchClient" method="POST">   	--%>
        <%--
        <form:form method="POST">     
            <input type="text" name="srchName" class="inputtxtbox" value="Enter client's name..." />               
            <input type="submit" value="Search" class="button" onclick="showPleaseWait();" />           
			<input type="button" value="Enter Order" onclick="showPleaseWait();window.location.href='formAddClient'; return false;" class="button"/>                  
        </form:form>
        --%>
        					
	<%-- <div id="header1"><h2></h2></div> --%>
	
		 <form name="pOrder" id="formpOrderAddDetails" action="pOrderAddDetails" method="POST"> 
		<%-- <form name="pOrder" id="formpOrderAddDetails" method="POST"> --%>
		
		<%-- Search box --%>
		<%-- Form action="pOrderAddSearchClient" method="POST" --%>
        <input type="text" name="srchName" class="inputtxtbox" value="Enter client's name..." />               
        <input type="button" value="Search" class="button" onclick="return pOrderAddSearchClient();" />           
	
		<%-- Form  Submit action="pOrderAddDetails" --%>
		<input type="submit" value="Add Details" class="button"/>	
		<script>
		$(document).ready(function(){
			 $('#formpOrderAddDetails').submit(function() {			
			 return checkSelectedClient();
			});
		}); 
		</script>
		   
		   
		<%--
		<script>
		$('#formpOrderAddDetails').submit(checkSelectedClient());
		</script>
		--%>
		   	  
		<table>
				<tr><%-- table headers --%>								
					<th>Client ID</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>City</th>			
				</tr>			
				<!-- loop over and print our clients 'clients' is the attribute name from MVC Model -->
				<c:forEach var="tempClient" items="${clients}">	
				
					<c:url var="modifyLink" value="/client/formEditClient">
						<c:param name="clientId" value="${tempClient.client_id}"/>
					</c:url>
					
					<c:url var="deleteLink" value="/client/delete">
						<c:param name="clientId" value="${tempClient.client_id}"/>
					</c:url>
					
					<c:url var="pOrder" value="/client/pOrders">
						<c:param name="clientId" value="${tempClient.client_id}"/>
					</c:url>
					
					<%--
					<c:url var="pOrderClient" value="/porder/pOrderAddSelectClient">
						<c:param name="clientId" value="aaabbb"/>
					</c:url>
					
					<tr>	
					--%>
					
					<%--				 
						 <td> 
							<input type="button" value="Edit"
							onclick="showPleaseWait();window.location.href='${modifyLink}'; return false;"
							class="buttonDetails"
							/>
						 </td>
					--%>	
						<td> 
							<input type="radio" class="radio" name="clientId" id="idclientId" value=${tempClient.client_id}> ${tempClient.client_id} <BR>
						 </td>
								
						<td> ${tempClient.firstName} </td>
						<td> ${tempClient.lastName} </td>
						<td> ${tempClient.city} </td>
					
					<%--
							<c:choose>
		  						<c:when test="${tempClient.points == 0}">
		   						<td>NA</td>
		 						</c:when>
		  						<c:otherwise>
		    					<td>${tempClient.points}</td>
		  						</c:otherwise>
							</c:choose>
					--%>
						
						<%--									 
						 <td> 
							<a href="showPleaseWait();${deleteLink}"
							onclick="if(!(confirm('Are you sure you want to delete the client? Note that all client's orders will be deleted as well.'))) return false">
							<img id="controlIcon" src="${pageContext.request.contextPath}/resources/images/delete.jpg";
							class="controlIcon"
							>
							</a>
						 </td>
						 --%>
						 
						<%--
						 <td> 
							<input type="button" value="Purchase Orders"
							onclick="showPleaseWait();window.location.href='${pOrder}'; return false;"
							class="buttonDetails"
							/>
						 </td>
						 --%>
						 			
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









