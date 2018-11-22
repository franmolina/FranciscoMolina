<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Repositorio de Videojuegos - Acceder</title>
</head>
<body>
	<form action="/login" method="post">
		<fieldset>
			<legend>Inicio de sesi�n</legend>
			Nombre de usuario:<br>
			<input type="text" required="required"><br>
			Contrase�a:<br>
			<input type="password" required="required"><br>
			<input type="submit" value="Acceder">
		</fieldset>
		
	</form>

</body>
</html>