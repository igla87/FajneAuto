<%@page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">	
		<title>SALON SAMOCHODOWY FAJNE AUTO</title>
	</head>
	<body>
		<div class="content">
			<form:form modelAttribute="newOrder">
			<div class="topColumns">
				<div class="column">
					<p class="columnTitle">POCZATEK WYNAJMU</p>
					<div class="row">
						<div class="btnPlusMinus" id="btnStartDataMinus">-</div>
						<div class="btnValue">
							<form:label path="startDate" id="startDate"><fmt:formatDate value="${newOrder.startDay}" pattern="dd/MM/yyyy" /></form:label>
						</div>
						<div class="btnPlusMinus" id="btnStartDataPlus">+</div>
					</div>
					<div class="row">
						<div class="btnPlusMinus" id="btnStartGodzinaMinus">-</div>
						<div class="labelValue">
							<form:label path="startHours" id="startHours">${newOrder.startHours} </form:label>
						</div>
						<div class="labelValue">
							<form:label path="startMinutes" id="startMinutes">${newOrder.startMinutes}</form:label>
						</div>
						<div class="btnPlusMinus" id="btnStartGodzinaPlus">+</div>
					</div>
					<div class="row">
						<select name="startPlace">
							<option value="0">LOKALIZACJA</option>
							<c:forEach items="${StartPlaces}" var="place">
								<option value="${place.idRentalPlace}">${place.name}</option>	
							</c:forEach>
						</select>
					</div>
				</div>	
				<div class="column">
					<p class="columnTitle">KONIEC WYNAJMU</p>
					<div class="row">
						<div class="btnPlusMinus" id="btnEndDataMinus">-</div>
						<div class="btnValue">
							<form:label path="endDate" id="endDate"><fmt:formatDate value="${newOrder.endDay}" pattern="dd/MM/yyyy" /></form:label>
						</div>
						<div class="btnPlusMinus" id="btnEndDataPlus">+</div>
					</div>
					<div class="row">
						<div class="btnPlusMinus" id="btnEndGodzinaMinus">-</div>
						<div class="labelValue">
							<form:label path="endHours" id="endHours">${newOrder.endHours}</form:label>
						</div>
						<div class="labelValue">
							<form:label path="endMinutes" id="endMinutes">${newOrder.endMinutes}</form:label>
						</div>
						<div class="btnPlusMinus" id="btnEndGodzinaPlus">+</div>
					</div>
					<div class="row">
						<select name="endPlace">
							<option value="0">LOKALIZACJA</option>
							<c:forEach items="${EndPlaces}" var="place">
								<option value="${place.idRentalPlace}">${place.name}</option>	
							</c:forEach>
						</select>
					</div>
				</div>	
			</div>
			<div class="bottomRow">
				<select name="car">
					<option value="0">KLASA SAMOCHODU</option>
					<c:forEach items="${CarClass}" var="cl">
						<option value="${cl.idRentalClass}">${cl.className}</option>	
					</c:forEach>
				</select>
			</div>
			<div class="bottomRow">
				<input type="submit" class="button" value="DALEJ">
			</div>	
			</form:form>
		</div>			
	</body>
</html>