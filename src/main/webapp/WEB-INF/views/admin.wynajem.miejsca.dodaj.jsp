<%@page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">	
		<title>SALON SAMOCHODOWY FAJNE AUTO</title>
	</head>
	<body>
		<div class="content">
			<form:form modelAttribute="place">
				<p>NAZWA:</p>
				<div>
					<form:input class="inputField" path="name" type="text"/>
				</div>
				<p>ADRES:</p>
				<div>
					<form:input class="inputField" path="address" type="text"/>
				</div>
				<input type="submit" class="button" value="DODAJ">
			</form:form>
		</div>			
	</body>
</html>