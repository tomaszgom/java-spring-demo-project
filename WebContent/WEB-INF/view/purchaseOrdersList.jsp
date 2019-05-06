<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>
<head>
	<title>List Orders</title>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/mainActions.js" ></script>
	<script src="${pageContext.request.contextPath}/resources/js/jquery.js" ></script>
	<script src="${pageContext.request.contextPath}/resources/js/jquery-ui.js" ></script>	
	
	<!-- '${pageContext.request.contextPath}' is the name of the app-->
	<link type="text/css" rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/mainStyle.css" />
</head>

<body>
<%-- Navigation Panel --%>
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
		<div id="header1"><h2>Orders</h2></div>
		<div id="header"><h2></h2></div>
	</div>	
	<div id="container">
		<div id="content">
			
			<!-- this call Spring controller mapping 'showForm...' -->
		<input type="button" value="Add Order"
			onclick="showPleaseWait();window.location.href='${pageContext.request.contextPath}/purchaseOrder/purchaseOrderAddSelectClient'; return false;"
			class="button"/>
			
		<input type="button" value="Refresh List"
			onclick="showPleaseWait();window.location.href='${pageContext.request.contextPath}/purchaseOrder/list'; return false;"
			class="button"/>
			
		<input type="button" value="Clients List" 
			onclick="showPleaseWait();window.location.href='${pageContext.request.contextPath}/client/list'; return false;"
			class="button"/>	
							
			<!--  html table -->		
			<table>
				<tr>				
					<th>Order ID</th>
					<th>Value</th>
					<th>Product Name</th>
					<th>Order Date</th>				
					<th>Client ID</th>
					<th></th>
				</tr>			
				<!-- loop over and print our clients 'clients' is the attribute name from MVC Model -->
				<c:forEach var="tempOrder" items="${purchaseOrders}">	
									
					<c:url var="modifyLink" value="/client/formEditClient">
						<c:param name="clientId" value="${tempOrder.clientID}"/>
					</c:url>
														
					<tr>				
						<td> ${tempOrder.order_id} </td>	
						<td> ${tempOrder.orderValue} </td>
						<td> ${tempOrder.productName} </td>	
						<td> ${tempOrder.orderDate} </td>	
						<td> ${tempOrder.clientID} </td>	
						<td><a href="${modifyLink}">View Client Details</a></td>													
					</tr>
				
				</c:forEach>						
			</table>				
		</div>
	</div>
	</div>
</body>
</html>









