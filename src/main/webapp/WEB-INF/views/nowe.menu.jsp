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
			<a class="button" href="<c:url value="/nowe/modele"/>">PRZEGLĄD MODELI</a>
			<a class="button" href="<c:url value="/nowe/konfigurator"/>">KONFIGURATOR</a>
			<a class="button" href="<c:url value="/nowe/cenniki"/>">CENNIKI</a>
		</div>			
	</body>
</html>