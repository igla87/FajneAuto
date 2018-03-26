<%@page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="<c:url value="/resources/css/subtitleGreen.css" />" rel="stylesheet">
		<title>SALON SAMOCHODOWY FAJNE AUTO</title>
	</head>
	<body>
		<div class="content">
			<a class="button" href="<c:url value="/admin/wynajem/auta"/>">KLASY AUT DO WYNAJĘCIA</a>
			<a class="button" href="<c:url value="/admin/wynajem/miejsca"/>">MIEJSCA ODBIORU</a>
			<a class="button" href="<c:url value="/admin/wynajem/okresy_wynajmu"/>">OKRESY WYNAJMU</a>
		</div>
			
	</body>
</html>