<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<title>Save Client</title>
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/mainStyle.css">
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/addClient.css">
</head>
<body>
	<div id="wrapper">
		<div id="header0">
			<h2>Java Spring Demo Project by Tomasz Gomorardzki </h2>
		</div>
		<div id="header1">
		<h3> </h3>
		</div>
		<div id="header">
			<h2>Modify Client</h2>
		</div>
	</div>
		<p>
			<a href="${pageContext.request.contextPath}/client/list">Go to List</a>
		</p>	
	<div id="container">	
		<form:form action="saveClient" modelAttribute="client" method="POST">
		<!-- match data with client ID hidden form field, it will use get from Client -->
		<form:hidden path="client_id"/>
		
			<table>
				<tbody>
					
					<!--  <tr>
						<td><label>ID</label></td>
						<td><form:input path="client_id" readonly="readonly"/></td>
						<td><label>(read only) </label></td>
					</tr>
					-->
		
					<tr>
						<td><label>First name:</label></td>
						<td><form:input path="firstName" /></td>
					</tr>				
					<tr>
						<td><label>Last name:</label></td>
						<td><form:input path="lastName" /></td>
					</tr>
					<tr>
						<td><label>City:</label></td>
						<td><form:input path="city" /></td>
					</tr>
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>				
				</tbody>
			</table>				
		</form:form>
	
		<div style="clear; both;"></div>		
	</div>
</body>
</html>










