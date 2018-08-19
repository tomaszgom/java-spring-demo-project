<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>
<head>
	<title>Save Client</title>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/mainActions.js" ></script>
	<link type="text/css" rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/addClient.css">
</head>
<body>

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

<!-- Main Content Page  -->
<div id="mainContentId">

	<div id="wrapper">		
		<div id="header0"><p>Java Spring Demo Project by Tomasz Gomoradzki</p></div>
		<div id="header1"><h2>Purchase Orders Management - Client Details</h2></div>
		<div id="header"><h2></h2></div>
	</div>
	<div><br></div>
	<div id="container">	
		<form:form action="saveClient" modelAttribute="client" method="POST">
		<!-- match data with client ID hidden form field, get from Client -->
		<form:hidden path="client_id"/>

		<div id="buttons">
		<input type="submit" value="Back to List" 
			onclick="showPleaseWait();window.location.href='${pageContext.request.contextPath}/client/list'; return false;"
			class="button"
		 />
		<input type="submit" value="Save" class="button" onclick="showPleaseWait()"/>
		<div><br></div>
		</div>
		
			<table>	
				<tbody>				
					  <tr>
						<td><label>Client ID</label></td>
						<td><form:input class="inputtxtbox" path="client_id"
						readOnly="true" style="background: #d8d8d8;"/></td>
					</tr>
					<tr>
						<td><label><br></label></td>
					</tr>
					<tr>
						<td><label>First Name</label></td>
						<td><form:input class="inputtxtbox" path="firstName" /></td>
						<td><label>Last Name</label></td>
						<td><form:input class="inputtxtbox" path="lastName" /></td>					
					</tr>				
					<tr>
						<td><label><br></label></td>
					</tr>
					<tr>
						<td><label>City</label></td>
						<td><form:input class="inputtxtbox" path="city" /></td>
						<td><label>Points</label></td>
						<td><form:input class="inputtxtbox" path="points" /></td>					
						<td><label><br></label></td>
					</tr>
					<%--  <tr style="display:none;"> --%>
					  <tr > 				
						<td><label>Last Login Date</label></td>
						<td><form:input class="inputtxtbox" path="lastLoginDate" /></td>

					</tr>
		
				</tbody>
			</table>				
		</form:form>
	
		<div style="clear; both;"></div>		
	</div>
	</div>
</body>
</html>










