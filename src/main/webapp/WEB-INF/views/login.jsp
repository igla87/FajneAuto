<%@page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">	
		<title>SALON SAMOCHODOWY FAJNE AUTO</title>
	</head>
	<body>
		<div class="content">
		
				<c:set var="loginUrl"><c:url value="/j_spring_security_check"/></c:set>
				<form method="POST" action="${loginUrl}">
						<p>LOGIN:</p>
						<div class="">
							<input class="inputField" name="Login" type="text">
						</div>
						<p>HASŁO:</p>
						<div class="">
							<input class="inputField" name="Password" type="password" value="">
						</div>
						<input class="button" type="submit" value="ZALOGUJ">
				</form>
				<br>
				<p>
					<span>Nie masz konta? </span>
					<a href="<c:url value="/konto/rejestracja" />">ZAREJSTERUJ SIĘ</a>
				</p>
		</div>			
	</body>
</html>