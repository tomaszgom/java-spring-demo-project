<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>
<head>
	<title>List Clients</title>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/mainActions.js" ></script>
	<!-- '${pageContext.request.contextPath}' is the name of the app-->
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
		<div id="header1"><h2>Purchase Orders Management - Clients</h2></div>
		<div id="header"><h2></h2></div>
	</div>	
	<div id="container">
	<div id="content">
	<div>		
		    <!--  search box -->
        <form:form action="search" method="POST">
            <input type="text" name="srchName" class="inputtxtbox" value="Enter client's name..." />               
            <input type="submit" value="Search" class="button" onclick="showPleaseWait();" />
            
			<!-- this call Spring controller mapping 'showForm' -->
			<input type="button" value="Add Client"
				onclick="showPleaseWait();window.location.href='formAddClient'; return false;"
				class="button"/>
			<input type="button" value="Help"
				onclick="showPleaseWait();window.location.href='formAddClient'; return false;"
				class="button"/>         
        </form:form>						
	</div>		
	<div id="header1"><h2></h2></div>
	<table>
				<tr>				
					<th></th>
					<th>Client ID</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>City</th>
					<th>Points</th>
					<th>Last Login Date</th>
					<th>[Delete]</th>	
					<th></th>				
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
					
					<tr>					 
						 <td> 
							<input type="button" value="Edit"
							onclick="showPleaseWait();window.location.href='${modifyLink}'; return false;"
							class="buttonDetails"
							/>
						 </td>
						 
						<td> ${tempClient.client_id} </td>					
						<td> ${tempClient.firstName} </td>
						<td> ${tempClient.lastName} </td>
						<td> ${tempClient.city} </td>
					
							<c:choose>
		  						<c:when test="${tempClient.points == 0}">
		   						<td>NA</td>
		 						</c:when>
		  						<c:otherwise>
		    					<td>${tempClient.points}</td>
		  						</c:otherwise>
							</c:choose>
						
						<td> ${tempClient.lastLoginDate} </td>
									 
						 <td> 
							<a href="showPleaseWait();${deleteLink}"
							onclick="if(!(confirm('Are you sure you want to delete the client? Note that all client's orders will be deleted as well.'))) return false">
							<img id="controlIcon" src="${pageContext.request.contextPath}/resources/images/delete.jpg";
							class="controlIcon"
							>
							</a>
						 </td>
						 
						 
						 <td> 
							<input type="button" value="Purchase Orders"
							onclick="showPleaseWait();window.location.href='${pOrder}'; return false;"
							class="buttonDetails"
							/>
						 </td>			
					</tr>
				
				</c:forEach>						
			</table>				
		</div>
	</div>
	</div>
</body>
</html>









