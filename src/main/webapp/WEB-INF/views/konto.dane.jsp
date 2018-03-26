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
			<div class="elementBox">
				<p>${currentUser.getName()} ${currentUser.getSurname()}</p>
			</div>
			<div class="elementBox">
				<p class="description">DANE ADRESOWE:</p>
				<p>${currentUser.getAddressStreet()}</p>
				<p>${currentUser.getAddressPostCode()} ${currentUser.getAddressCity()}</p>
			</div>
			<div class="elementBox">
				<p class="description">KONTAKT:</p>
				<p>${currentUser.getPhone()}</p>
				<p>${currentUser.getEmail()}</p>
			</div>
			<div class="btnBox">
				<a class="button" href="<c:url value="/konto/dane/edytuj"/>">EDYTUJ DANE</a>
				<a class="button" href="<c:url value="/konto/dane/haslo"/>">ZMIEŃ HASŁO</a>
			</div>
				
		</div>			
	</body>
</html>