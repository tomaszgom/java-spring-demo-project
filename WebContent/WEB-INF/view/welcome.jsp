<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
<head>
	<title>Welcome</title>
	
	<!-- linking CSS; '${pageContext.request.contextPath}' the name of the app-->
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/welcome.css" />
</head>

<body>
	<div id="wrapper">
		<div id="header0">
			<h2>Welcome to Java Spring Demo Project</h2>
			<h2>by Tomasz Gomorardzki</h2>
			
			<table>
				<tr>				
					<th>
						<input type="button" value="Continue"
							onclick="window.location.href='list'; return false;"
							class="buttContinue"
						/>			
					</th>					
					<th>
						<input type="button" value="Exit"
							onclick="window.location.href='goodbye'; return false;"
							class="buttExit"
						/>
					</th>
				</tr>
			</table>			
			
	</div>	
	</div>	
	<div id="container">
<br>
Application info:<br>
<br>
Java Spring Demo Project is web application and should be considered as demo,<br>
part of the programming portfolio. It is based on Spring framework, concepts<br>
of CRUD (Create, Read, Update, Delete), Model View Controller and works with <br>
Oracle Database. Application allows to store, review and modify client's data.<br>
<br>
Application has been developed with Eclipse Java EE IDE Oxygen v. 4.7 and Java 8.<br>
Please find below some more information on implemented technologies.<br>
<br>
Technologies used:<br>
<br>
- Java 8<br>
- Spring Framework Release 5.0.1.<br>
- Hibernate Release 5.2.12.<br>
- Apache Tomcat 8.0 Application Server<br>
- CSS<br>
- JSP<br>
- XML<br>
- Oracle Database XE 11.2 - SQL DDL code necessary to re-create the database with<br>
all components (Tables, sequences, triggers) is available within below project directory:<br>
	JavaSpringDemoProject\WebContent\resources\sql\fullDatabaseExport.sql<br>
<br>
Some of the concepts used:<br>
<br>
- CRUD Concept Application (Create, Read, Update, Delete)<br>
- Hibernate Annotations and Mappings<br>
- Model View Controller<br>
- Inversion of Control<br>
- Dependency Injection<br>
- Bean Scopes and Life-cycle Methods<br>
- Service Layer between Controller and DAO (Facade Design pattern)<br>
(Intermediate layer for business logic, can be used to integrate data<br>
for multiple sources)<br>
- DAO Data Access Object<br>
- Hibernate Object Class<br>
						
		</div>	

</body>
</html>
