<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>

<!DOCTYPE html>
<html lang="pl">
<head>
	<meta charset="utf-8">
	<link href="<c:url value="/resources/css/headerGreen.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/css/navGreen.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/css/subtitleGreen.css" />" rel="stylesheet">
	
	<tilesx:useAttribute id="list" name="cssFiles" classname="java.util.List" />
	<c:forEach var="item" items="${list}">
  		<tiles:insertAttribute value="${item}" />
  		<br/>
	</c:forEach>
	
	<title><tiles:insertAttribute name="title" /></title> 
</head>
<body>
	<header>
		<span class="titleGrey">SALON SAMOCHODOWY</span>
		<span class="titleGold">FAJNE AUTO</span>
	</header>
	
	<tiles:insertAttribute name="navigation" />
	
	<div class="subtitle">
		<tiles:insertAttribute name="subtitle" />
	</div>
	<hr>
		
	<tiles:insertAttribute name="content" />
</body>
</html>