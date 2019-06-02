<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>
<head>
	<title>Welcome</title>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/mainActions.js" ></script>
	<!-- linking CSS; '${pageContext.request.contextPath}' the name of the app-->
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/welcome.css" />
</head>

<body>
<div id="pleaseWaitId" class="pleaseWait">
	<div class="pleaseWaitText">Please wait...</div>
</div>
		<div id="header0">		
			<br><br>
			<h2>Login or password is incorrect.</h2>		
			<br><br>
		<input type="button" value="Log in again"
				onclick="showPleaseWait(); window.location.href='welcome'; return false;"
				class="button"/>
							
</div>	
</body>
</html>
