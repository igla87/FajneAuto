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
			<form:form modelAttribute="newAccount">
				<div class="topColumns">
					<div class="column">
						<div class="elementBox">
							<p>IMIĘ:</p>
							<div class="inputBox">
								<form:input path="name" type="text" class="input"/>
							</div>
						</div>
						<div class="elementBox">
							<p>NAZWISKO:</p>
							<div class="inputBox">
								<form:input path="surname" type="text" class="input"/>
							</div>
						</div>
						<div class="elementBox">
							<p>MIASTO:</p>
							<div class="inputBox">
								<form:input path="addressCity" type="text" class="input"/>
							</div>
						</div>
						<div class="elementBox">
							<p>KOD POCZTOWY:</p>
							<div class="inputBox">
								<form:input path="addressPostCode" type="text" class="input"/>
							</div>
						</div>
						<div class="elementBox">
							<p>ULICA, NUMER:</p>
							<div class="inputBox">
								<form:input path="addressStreet" type="text" class="input"/>
							</div>
						</div>
					</div>	
					<div class="column">
						<div class="elementBox">
							<p>TELEFON:</p>
							<div class="inputBox">
								<form:input path="phone" type="text" class="input"/>
							</div>
						</div>
						<div class="elementBox">
							<p>E-MAIL:</p>
							<div class="inputBox">
								<form:input path="email" type="text" class="input"/>
							</div>
						</div>
						<div class="elementBox">
							<p>LOGIN:</p>
							<div class="inputBox">
								<form:input path="login" type="text" class="input"/>
							</div>
						</div>
						<div class="elementBox">
							<p>HASŁO:</p>
							<div class="inputBox">
								<form:input path="password" type="text" class="input"/>
							</div>
						</div>
						<div class="elementBox">
							<p>POTWÓRZ HASŁO:</p>
							<div class="inputBox">
								<form:input path="password2" type="text" class="input"/>
							</div>
						</div>
					</div>	
				</div>
				<input type="submit" class="button" value="ZAREJESTRUJ">
			</form:form>
		</div>			
	</body>
</html>