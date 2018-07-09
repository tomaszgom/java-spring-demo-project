<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>
<head>
	<title>List Clients</title>
	
	<!-- linking CSS; '${pageContext.request.contextPath}' is the name of the app-->
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/mainStyle.css" />
</head>

<body>
	<div id="wrapper">
		<div id="header0">
			<h2>Java Spring Demo Project by Tomasz Gomorardzki</h2>
		</div>
		<div id="header1"><h3> </h3></div>
		<div id="header">
			<h2>Clients</h2>
		</div>
	</div>	
	<div id="container">
		<div id="content">
			
			<!-- this call Spring controller mapping 'showForm...' -->
		<input type="button" value="Add Client"
			onclick="window.location.href='formAddClient'; return false;"
			class="add-button"
		/>
		<input type="button" value="Show statistics"
			onclick="window.location.href='formAddClient'; return false;"
			class="add-button"
		/>
		<input type="button" value="Help"
			onclick="window.location.href='formAddClient'; return false;"
			class="add-button"
		/>
		<input type="button" value="Exit"
			onclick="window.location.href='goodbye'; return false;"
			class="add-button"
		/>
		
		<div>	
		            <!--  search box -->
            <form:form action="search" method="POST">
                Search by name: <input type="text" name="srchName" />               
                <input type="submit" value="Search" class="add-button" />
            </form:form>
		</div>		
		
			<!--  add our html table here -->		
			<table>
				<tr>				
					<th>[Edit]</th>
					<th>Client ID</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>City</th>
					<th>[Delete]</th>					
				</tr>			
				<!-- loop over and print our clients 'clients' is the attribute name from MVC Model -->
				<c:forEach var="tempClient" items="${clients}">	
				
					<c:url var="modifyLink" value="/client/formEditClient">
						<c:param name="clientId" value="${tempClient.client_id}"/>
					</c:url>
					
					<c:url var="deleteLink" value="/client/delete">
						<c:param name="clientId" value="${tempClient.client_id}"/>
					</c:url>
					
					
					<tr>				
						<td> 
						<a href="${modifyLink}">[...]</a>
						 </td>
						<td> ${tempClient.client_id} </td>					
						<td> ${tempClient.firstName} </td>
						<td> ${tempClient.lastName} </td>
						<td> ${tempClient.city} </td>
						 <td> 
						<a href="${deleteLink}"
						onclick="if(!(confirm('Are you sure you want to delete the client?'))) return false">[X]
						</a>
						 </td>					
					</tr>
				
				</c:forEach>						
			</table>				
		</div>
	</div>
</body>
</html>









