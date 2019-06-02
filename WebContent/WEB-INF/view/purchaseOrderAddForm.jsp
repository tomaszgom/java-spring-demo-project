<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>
<head>
	<title>Save Client</title>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/mainActions.js" ></script>
	<script src="${pageContext.request.contextPath}/resources/js/jquery.js" ></script>
	<script src="${pageContext.request.contextPath}/resources/js/jquery-ui.js" ></script>
	<link type="text/css" rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/entityForm.css">
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

<!-- Main Content Page  -->
<div id="mainContentId">

	<div id="wrapper">		
		<div id="header0"><p>Purchase Orders Management  -  Java Spring Demo Project by Tomasz Gomoradzki</p></div>
		<div id="header1"><h2>Order Details</h2></div>
		<div id="header"><h2></h2></div>
	</div>
	<div><br></div>
	<div id="container">	
		 <form:form action="purchaseOrderSave" modelAttribute="purchaseOrder" method="POST">
		 <!-- match data with client ID hidden form field, get from Client -->
		 <form:hidden path="order_id"/> 
		 <form:hidden path="client.client_id"/>


		<div id="buttons">
		<input type="submit" value="Back to List" 
			onclick="showPleaseWait();window.location.href='${pageContext.request.contextPath}/purchaseOrder/list'; return false;"
			class="button"/>
		<input type="submit" value="Save" class="button" onclick="showPleaseWait()"/>
		<div><br></div>
		</div>
		
			<table>	
				<tbody>				
					<%--  <tr>
						<td><label>ID</label></td>
						<td><form:input path="client_id" readonly="readonly"/></td>
						<td><label>(read only) </label></td>
					</tr>
					--%>
					<tr>
						<td><label>Client ID:</label></td>				
						<td>
							<form:input class="inputtxtbox" path="client.client_id" value="${client.client_id}"
							readOnly="true" style="background: #d8d8d8;"/>
						</td>
						<td></td>
						<td></td>								
					</tr>
					<tr>
					
						<td><label>Client Name:</label></td>				
						<td>
							<form:input class="inputtxtbox" path="client.firstName" value="${client.firstName}"
							readOnly="true" style="background: #d8d8d8;"/>
						</td>
						<td><label>Client Last Name</label></td>
						<td>
							<form:input class="inputtxtbox" path="client.lastName" 
							readOnly="true" style="background: #d8d8d8;"/>
						</td>
									
						<td><form:input style="display:none;" path="client.city"/></td>
						<td><form:input style="display:none;" type="number" path="client.points"/></td>						
						<td><form:input style="display:none;" type="date" path="client.lastLoginDate"/></td>
								
					</tr>	
								
					<tr>
						<td><label><br></label></td>
					</tr>
				
					<tr>
					
						<td><label>Order Value</label></td>
						<td><form:input class="inputtxtbox" path="orderValue" /></td>
						<td><label>Product Name</label></td>
						<td><form:input class="inputtxtbox" path="productName" /></td>	
														
						<td><label><br></label></td>
					</tr>
					 <tr> 				
						<td><label>Order Date</label></td>
						<td>
						
					<script>
  						$( function() {
    					$( "#datepicker" ).datepicker();
  						} );
  					</script>
					 <%-- <p><form:input type="text" id="datepicker" class="inputtxtbox" path="orderDate" /></p> --%>
					 <p>
					 <%--<fmt:formatDate pattern = "yyyy/MM/dd" value = "${now}"/>--%>
					<form:input type="text" id="datepicker" class="inputtxtbox" path="orderDate" /> 
					 </p>		
					</td>
					</tr>
					<tr> 				
						<td>
						<%--
						<fmt:formatDate value="${yourObject.date}" var="dateString" pattern="dd/MM/yyyy" />
						<form:input type="date" path="orderDate" value="${dateString}"/>
 						--%>
						</td>
					</tr>
				</tbody>
			</table>				
		</form:form>	
<div style="clear; both;"></div>		
</div>
</div>

</body>
</html>










