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
			<form:form modelAttribute="currentUser">
				<p>STARE HASŁO:</p>
				<div>
					<form:input class="inputField" path="password_old" type="text"/>
				</div>
				<p>NOWE HASŁO:</p>
				<div>
					<form:input class="inputField" path="password" type="text"/>
				</div>
				<p>POWTÓRZ NOWE HASŁO:</p>
				<div>
					<form:input class="inputField" path="password2" type="text"/>
				</div>
				<input type="submit" class="button" value="ZMIEŃ">
			</form:form>
		</div>			
	</body>
</html>