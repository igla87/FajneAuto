<%@page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="<c:url value="/resources/css/subtitle.css" />" rel="stylesheet">
		<title>SALON SAMOCHODOWY FAJNE AUTO</title>
	</head>
	<body>
			<p>${newAccount.getPassword()}</p>
			<br>
			<p>${newAccount.getPassword2()}</p>

			

			
	</body>
</html>