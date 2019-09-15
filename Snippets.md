# Snippets for Java EE Maven Project setup

File: pom.xml
For; 
Dependencies: Java EE Web API 6.0
Plugins: Maven Compiler config Java 1.8

```xml

<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<groupId>com.codingyogurt</groupId>
	<artifactId>codingyogurt-first-webapp</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<packaging>war</packaging>

	<dependencies>
		<dependency>
			<groupId>javax</groupId>
			<artifactId>javaee-web-api</artifactId>
			<version>6.0</version>
			<scope>provided</scope>
		</dependency>
	</dependencies>

	<build>
		<pluginManagement>
			<plugins>
				<plugin>
					<groupId>org.apache.maven.plugins</groupId>
					<artifactId>maven-compiler-plugin</artifactId>
					<version>3.2</version>
					<configuration>
						<verbose>true</verbose>
						<source>1.8</source>
						<target>1.8</target>
						<showWarnings>true</showWarnings>
					</configuration>
				</plugin>
				<plugin>
					<groupId>org.apache.tomcat.maven</groupId>
					<artifactId>tomcat7-maven-plugin</artifactId>
					<version>2.2</version>
					<configuration>
						<path>/</path>
						<contextReloadable>true</contextReloadable>
					</configuration>
				</plugin>
			</plugins>
		</pluginManagement>
	</build>
</project>
```

File: web.xml
For: index file for the website
Note: first create folder WEB_INF 

```xml
<!-- webapp/WEB-INF/web.xml -->
<web-app xmlns="http://java.sun.com/xml/ns/javaee" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd"
	version="3.0">

	<display-name>To do List</display-name>

	<welcome-file-list>
		<welcome-file>login.do</welcome-file>
	</welcome-file-list>
</web-app>

```
# Snippets for Spring MVC Setup

### Spring MVC dispatcher (front controller)

File: pom.xml, under dependencies
For: to add the Spring framework dependency. 
```xml
	<dependency>
		<groupId>org.springframework</groupId>
		<artifactId>spring-webmvc</artifactId>
		<version>4.2.2.RELEASE</version>
	</dependency> 
```
File: dispatcher.xml
For: for the Spring beans
```xml
<beans xmlns="http://www.springframework.org/schema/beans"
	    xmlns:context="http://www.springframework.org/schema/context"
	    xmlns:mvc="http://www.springframework.org/schema/mvc"
	    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	    xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
	    http://www.springframework.org/schema/mvc http://www.springframework.org/schema/mvc/spring-mvc.xsd
	    http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd">
	
	    <context:component-scan base-package="com.codingyogurt" />
	    <mvc:annotation-driven />
	    
</beans>
```
File: web.xml
For: create and link the dispatcher servlet class to the dispatcher.xml. Also to create a mapping of the url that will catch all request having "/ryan-mvc/"
```xml
	<servlet>
	        <servlet-name>spring-dispatcher</servlet-name>
	        <servlet-class>
	            org.springframework.web.servlet.DispatcherServlet
	        </servlet-class>
	        <init-param>
	            <param-name>contextConfigLocation</param-name>
	            <param-value>/WEB-INF/index-servlet-context.xml</param-value>
	        </init-param>
	        <load-on-startup>1</load-on-startup>
	    </servlet>
	
	    <servlet-mapping>
	        <servlet-name>spring-dispatcher</servlet-name>
	        <url-pattern>/ryan-mvc/*</url-pattern>
	    </servlet-mapping>
```
### Spring MVC Controllers

File: IndexLoginController.java
For: Will be annotated as a Spring Controller. Will be included in the controllers the dispatcher will automatically look on.
```java
package com.codingyogurt;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexLoginController {
	@RequestMapping(value="/bukasan") // if this is found in the url with the created mapping /ryan-mvc/ map will be 							redirected here
	@ResponseBody // this annotation will say that the response is the body itself remove if the response is a jsp view
	public String goToBukasan(){
		return "IndexView";
	}

}
 

```
### Spring MVC View Resolvers

File: dispatcher.xml
For: Add bean for the viewer resolver. The dispatcher will automatically go to this after it receives a text from a controller (not annotated as a body). Then will go to the file with the text received (e.g. /WEB-INF/views/)
```xml
<beans xmlns="http://www.springframework.org/schema/beans"
	    xmlns:context="http://www.springframework.org/schema/context"
	    xmlns:mvc="http://www.springframework.org/schema/mvc"
	    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	    xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
	    http://www.springframework.org/schema/mvc http://www.springframework.org/schema/mvc/spring-mvc.xsd
	    http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd">
	
	    <context:component-scan base-package="com.codingyogurt" />
	
		<bean 
	       class="org.springframework.web.servlet.view.InternalResourceViewResolver">
	       <property name="prefix"> // this parameter will be added at the beginning of the response from the controller
	           <value>/WEB-INF/views/</value>
	       </property>
	       <property name="suffix"> // this parameter will also be added at the end of the response of the controller
	           <value>.jsp</value>
	       </property>
		</bean>
		
	    <mvc:annotation-driven />
	    
</beans>
```
File: IndexLoginController.java
For: Edited so that it will only return a text. This text is now will be sent to the dispatcher, dispatcher will then consult the view resolver and add the prefix and suffix.
```java
package com.codingyogurt;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexLoginController {
	@RequestMapping(value="/bukasan") 
	public String goToBukasan(){
		return "IndexView";
	}

}
 

```
### Adding logging framework for easier debugging. Adding log4j.
File: pom.xml
For: Adding the dependency in Maven so it will be automaticall downloaded. Under dependencies.
```xml
	<dependency>
		<groupId>log4j</groupId>
		<artifactId>log4j</artifactId>
		<version>1.2.17</version>
	</dependency>
```
File: main/resources/log4j.properties (to create)
For: The properties file for log4j.
```
log4j.rootLogger=ERROR, Appender1, Appender2
 
log4j.appender.Appender1=org.apache.log4j.ConsoleAppender
log4j.appender.Appender1.layout=org.apache.log4j.PatternLayout
log4j.appender.Appender1.layout.ConversionPattern=%-7p %d [%t] %c %x - %m%n
```
### JSTL Tags for JSPs
File: .jsp
For: adding logic in a jsp view file
```html
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:forEach items="${todoslist}" var="todo">
	${todo.id} ${todo.desc} ${todo.user}
<c:forEach>
```
File: pom.xml
For: Dependency
```xml
	<dependency>
	    <groupId>javax.servlet</groupId>
	    <artifactId>jstl</artifactId>
	    <version>1.2</version>
	</dependency>
```
### Webjars for the UI, adding Bootstrap and Jquery (Required by bootstrap)
File: pom.xml
For: Depedency
```xml
	<dependency>
            <groupId>org.webjars</groupId>
            <artifactId>bootstrap</artifactId>
            <version>3.3.6</version>
        </dependency>
        <dependency>
            <groupId>org.webjars</groupId>
            <artifactId>jquery</artifactId>
            <version>1.9.1</version>
        </dependency>
	
```
File: dispatcher.xml
For: mapping all webjars request from jsp to webjars
```xml
<mvc:resources mapping="/webjars/**" location="/webjars/"/>
```
File: the JSP view file
For: adding the css and the scripts
```html
<head>
	<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
	<meta charset="UTF-8">
	<title>TODOS</title>
</head>

	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
    	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
```
### Adding Entry Validations using Bean Binding (Server) and Hibernate Validor (Web)

File: Object to validate
For: Validation, add javax validation on the object that needs validation on a parameter before acceptance
```java
@Size(min = 10, message = "Enter atleast 10 Characters.")
private static desc;
```

File: The JSP View
For: Binding the object class to the form in jsp, this command is will be required everytime the page is loaded. So always add the attribute in the commandName the first you access this page.
```html
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<form:form action="/add-todo" method="post" commandName="todo">
	<fieldset class="form-group">
		<form:label path="desc">Description</form:label>
		<form:input path="desc" type="text" class="form-control" required="required"/>
	</fieldset>
	<form:errors path="desc" cssClass="text-warning" />
</form:form>

```

File: controller with the post mapping
For: Initializing the validation in the server
```java
@Valid Todo todo, BindingResult result
```

File: pom.xml
For: Adding same functionality to the client. Adding Hibernate validator

```xml
<dependency>
	<groupId>org.hibernate</groupId>
	<artifactId>hibernate-validator</artifactId>
	<version>5.0.2.Final</version>
</dependency>
```
### Using JSP Fragments for header, footer and navigation bar

File: common/header.jspf
For: Place here code part of the header in each JSP file. You can user this header file for every jsp files using include lib.

```xml
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
	<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
	<meta charset="UTF-8">
	<title>Todo Web App</title>
</head>
<body>
```
File: IndexView.jsp
```xml
<%@include file="common/header.jspf" %>

<form action="/bukasan" method="post">
	<div class="container">
		<h1>Login to Todo Web App</h1>
		<fieldset class="form-group">
			<label>Username</label>
			<input type="text" name="txtUsername"/>
		</fieldset>
		<fieldset class="form-group">
			<label>Password</label>
			<input type="password" name="txtPassword"/>
		</fieldset>
		<label class="text-warning">${indexMessage}</label><br>
		<input class="btn btn-success" type="submit" value="Submit"/>
	</div>
</form>

<%@ include file="common/footer.jspf" %>
```
