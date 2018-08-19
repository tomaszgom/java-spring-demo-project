<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
<head>
	<title>Welcome</title>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/mainActions.js" ></script>
	<!-- linking CSS; '${pageContext.request.contextPath}' the name of the app-->
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/welcome.css" />
</head>

<body>
<div id="pleaseWaitId" class="pleaseWait">
	<div class="pleaseWaitText">Please wait...</div>
</div>
		<div id="header0">
			<h2>Welcome to Java Spring Demo Project</h2>
			<h2>by Tomasz Gomoradzki</h2>
			
			<table>
				<tr>				
					<th>
						<input type="button" value="Continue"
							onclick="showPleaseWait(); window.location.href='dashboard'; return false;"
							class="button"
						/>			
					</th>					
					<th>
						<input type="button" value="Exit"
							onclick="showPleaseWait(); window.location.href='goodbye'; return false;"
							class="button"
						/>
					</th>
				</tr>
			</table>			
			
	</div>	
</body>
</html>
