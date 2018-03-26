<%@page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">	
		<title>SALON SAMOCHODOWY FAJNE AUTO</title>
	</head>
	<body>
		<div class="content">
			<a class="button" href="<spring:url value="/konto/login"/>">LOGOWANIE</a>
			<a class="button" href="<spring:url value="/konto/rejestracja"/>">REJESTRACJA</a>
		</div>			
	</body>
</html>