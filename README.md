# Java Spring Demo Project by Tomasz Gomoradzki

Java Spring Demo Project is web application. It is based on Spring framework, concepts of CRUD (Create, Read, Update, Delete), Model View Controller and works with Oracle RDBMS.

Application is a tool for storing and modifying client's data and purchase orders. In particular it allows to review, add, remove, edit and search for clients and their purchase orders, display summary statistics and move around using navigation panel.

Application has been developed with Eclipse Java EE IDE Oxygen v. 4.7 and Java 8. Works on application server once implemented and launched with running database. Please find below some more information on implemented technologies.

Technologies used and some of the concepts deployed:

- Java 8
- Spring Framework Release 5.0.1.
- Hibernate Release 5.2.12.
- Apache Tomcat 8.0 Application Server
- JSP, HTML, CSS, XML
- Maven
- Javascript, jQuery JavaScript Library v3.3.1
- Logger log4j
- JUnit Test Classes
- Oracle Database XE 11.2 - SQL DDL code necessary to re-create the database with all components (Tables, sequences, triggers)  
  is available within below project directory: JavaSpringDemoProject\WebContent\resources\sql\fullDatabaseExport.sql
- Hibernate Annotations and Mappings, Hibernate Object Class, HQL
- Model View Controller architectural pattern
- Inversion of Control with Java Annotations
- Dependency Injection with Java Annotations (Field and Constructor Injection)
- Bean Scopes and Life-cycle Methods
- DAO (Data Access Object)
- Service Layer between Controller and DAO (Facade Design pattern) (Intermediate layer for business logic, can be used to integrate data with multiple sources)
- Spring Boot (coming soon)
- AOP (Aspect Oriented Programming) (coming soon)


