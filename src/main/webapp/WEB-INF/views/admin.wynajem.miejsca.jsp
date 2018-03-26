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
			<form:form modelAttribute="list">
				<div class="btnBox">
					<a class="button" href="<c:url value="/admin/wynajem/miejsca/dodaj"/>">DODAJ NOWE MIEJSCE ODBIORU</a>
				</div>
				<hr class="line">
				<c:forEach var="item" items="${list}">
			  		<div class="row">
						<div class="element">
							<div class="name">${item.name}</div>
							<a class="button2" href="<c:url value="/admin/wynajem/miejsca/edytuj/${item.idRentalPlace}"/>">EDYTUJ</a>
							<a class="button2" href="<c:url value="/admin/wynajem/miejsca/usun/${item.idRentalPlace}"/>">USUŃ</a>
						</div>
						<hr class="line">
					</div>
				</c:forEach>
			</form:form>
		</div>			
	</body>
</html>