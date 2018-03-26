<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	</head>
	<body>
		<div class="menuBar">
			<div class="mainMenu">
				<ol>
				    <li><a>NOWE</a>
				      	<ul>
				        	<li><a href="<c:url value="/nowe" />">Przegląd modeli</a></li>
				      		<li><a href="#">Cenniki</a></li>
				      		<sec:authorize access="hasRole('ROLE_CUSTOMER')">
				        		<li><a href="#">Konfigurator</a></li>
				        	</sec:authorize>
				    	</ul>
				    </li>
					<li><a href="#">UŻYWANE</a></li>				    
				    <li><a>WYNAJEM</a>
					    <ul>
					        <li><a href="#">Informacje</a></li>
					        <sec:authorize access="hasRole('ROLE_CUSTOMER')">
				        		<li><a href="<c:url value="wynajem/formularz" />">Formularz</a></li>
				        	</sec:authorize>
					    </ul>
				    </li>
					<li><a href="#">KONTAKT</a></li>
				    <li><a>KONTO</a>
				    	<ul>
				    		<sec:authorize access="isAnonymous()">
				        		<li><a href="<c:url value="/konto/login" />">Zaloguj</a></li>
				        		<li><a href="<c:url value="/konto/rejestracja" />">Zarejestruj</a></li>
				        	</sec:authorize>
				        	<sec:authorize access="hasRole('ROLE_CUSTOMER')">
				        		<li><a href="<c:url value="/konto" />">Twoje konto</a></li>
				        	</sec:authorize>
				        	<sec:authorize access="isAuthenticated()">
				        		<li><a href="<c:url value="/j_spring_security_logout" />">Wyloguj</a></li>
				        	</sec:authorize>
				        	<sec:authorize access="hasRole('ROLE_ADMIN')">
				        		<li><a href="<c:url value="/admin" />">Administracja</a></li>
				        	</sec:authorize>
				    	</ul>
				    </li>
				</ol>			
			</div>
		</div>	
	</body>
</html>