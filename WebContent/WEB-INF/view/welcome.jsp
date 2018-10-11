<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>
<head>
	<title>Welcome</title>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/mainActions.js" ></script>
	<!-- linking CSS; '${pageContext.request.contextPath}' the name of the app-->
	<link type="text/css" rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/welcome.css" />
</head>

<body>
<div id="pleaseWaitId" class="pleaseWait">
	<div class="pleaseWaitText">Please wait...</div>
</div>
		<div id="header0">
		
			<h2>Welcome to Java Spring Demo Project by Tomasz Gomoradzki</h2>	
			<h2>Purchase Orders Management</h2>		
			
<form:form action="porderSave" modelAttribute="porder" method="POST">
	<table>
	
	<td><br><br><br></td>
	<tr>				
		<td><label>Login</label></td>
		<td>
		<input type="text" name="login" class="inputtxtbox" value="DemoUser" /> 
		<%-- <td><form:input class="inputtxtbox" value="DemoUser" style="background: #d8d8d8;"/></td> --%>
		</td>
		<td><label>(DemoUser)</label></td>
	</tr>
	<tr>
		<td><label>Password</label></td>
		<td>
		<input type="password" name="password" class="inputtxtbox" value="Password" /> 
		<%-- <td><form:input class="inputtxtbox" value="password" /></td>	 --%>
		</td>
		<td><label>(Password)</label></td>
	</tr>
	<tr>	
	<td><br><br><br></td>
	</tr>
	<tr>				
		<th>
			<input type="button" value="Continue"
				onclick="showPleaseWait(); window.location.href='dashboard'; return false;"
				class="button"/>			
		</th>					
		<th>
			<input type="button" value="Exit"
				onclick="showPleaseWait(); window.location.href='goodbye'; return false;"
				class="button"/>
		</th>
	</tr>
	
</table>	
		
</form:form>				
</div>	
</body>
</html>
