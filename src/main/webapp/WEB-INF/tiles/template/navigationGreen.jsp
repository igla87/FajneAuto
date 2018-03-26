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
				    <li><a href="<c:url value="/admin/konfigurator" />">KONFIGURATOR</a></li>
				    <li><a href="<c:url value="/admin/uzywane" />">UŻYWANE</a></li>
				    <li><a href="<c:url value="/admin/wynajem" />">WYNAJEM</a></li>
				    <li><a href="<c:url value="/admin/konta" />">KONTA</a></li>
				    <li><a href="<c:url value="/j_spring_security_logout" />">WYLOGUJ</a></li>
				</ol>			
			</div>
		</div>	
	</body>
</html>