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
			<form:form modelAttribute="period">
				<form:input path="idRentalPeriod" type="hidden"/>
				<p>NAZWA:</p>
				<div>
					<form:input class="inputField" path="periodName" type="text"/>
				</div>
				<p>MINIMALNA LICZBA DNI:</p>
				<div>
					<form:input class="inputField" path="daysMin" type="number"/>
				</div>
				<p>MAKSYMALNA LICZBA DNI:</p>
				<div>
					<form:input class="inputField" path="daysMax" type="number"/>
				</div>
				<p>MNOŻNIK STAWKI DZIENNEJ:</p>
				<div>
					<form:input class="inputField" path="priceModifier" type="number"/>
				</div>
				<input type="submit" class="button" value="ZMIEŃ">
			</form:form>
		</div>			
	</body>
</html>