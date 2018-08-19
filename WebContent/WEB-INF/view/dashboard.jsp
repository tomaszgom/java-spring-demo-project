<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>
<head>
	<title>Purchase Orders</title>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/mainActions.js" ></script>
	<link type="text/css" rel="stylesheet"
			href="${pageContext.request.contextPath}/resources/css/dashboard.css" />	
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

<div>
<div>
	<div id="wrapper">
		<div id="header0"><p>Java Spring Demo Project by Tomasz Gomoradzki</p></div>
		<div id="header1"><h2>Purchase Orders Management - Dashboard</h2></div>
		<div id="header"><h2></h2></div>
	</div>	
	<div id="container">
		<div id="content">			
			<table class="dashboardTable">
				<tr id="trdashboard">				
					<th>
						<input type="button" value="Review Clients"
							onclick="showPleaseWait();window.location.href='${pageContext.request.contextPath}/client/list'; return false;"
							class="dashboardButton"
						/>			
					</th>					
					<th>
						<input type="button" value="Add Client"
							onclick="showPleaseWait();window.location.href='${pageContext.request.contextPath}/client/formAddClient'; return false;"
							class="dashboardButton"
						/>
					</th>
					<th>
						<input type="button" value="Show Statistics"
							onclick="showStats(); return false;"
							class="dashboardButton"
						/>
					</th>
				</tr>
				<tr>				
					<th>
						<input type="button" value="Review Orders"
							onclick="showPleaseWait();window.location.href='${pageContext.request.contextPath}/porder/list'; return false;"
							class="dashboardButton"
						/>			
					</th>					
					<th>
						<input type="button" value="Add Order"
							onclick="showPleaseWait();window.location.href='${pageContext.request.contextPath}/porder/pOrderAddSelectClient'; return false;"
							class="dashboardButton"
						/>
					</th>
					<th>
						<input type="button" value="Exit"
							onclick="showPleaseWait();window.location.href='goodbye'; return false;"
							class="dashboardButton"
						/>
					</th>
				</tr>
				
			</table>	
	</div>				
	</div>
	</div>
	<div><h2></h2></div>
														
			<table class="statsTable" id="statsTable" style="display:none;">
				
				<tr class="stats" >				
					<th>Total Number of Clients</th>
					<th>${stats['totalClients']}</th>	
				</tr>			
				<tr class="stats" >
					<th>Total Number of Orders</th>
					<th>${stats['totalOrders']}</th>									
				</tr>		
				<tr class="stats" >
					<th>Avg Order Value</th>
					<th>${stats['avgOrderValue']}</th>							
				</tr>	
				<tr class="stats" >
					<th>Max Client Points</th>
					<th>${stats['maxClientsPoints']}</th>							
				</tr>		
							
			</table>		
</div>	
</div>			
</body>
</html>









