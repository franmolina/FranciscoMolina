<%--
  Formulario para añadir nuevos juegos al sistema
  
  Author : Francisco Molina Sanchez
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page errorPage="error.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="app.name" /></title>
</head>
<body>
	<h2>
		<c:choose>
			<c:when test="${empty juego.idJuego}">
				<spring:message code="accion.nuevo" />
			</c:when>
			<c:otherwise>
				<spring:message code="accion.editar.juego" />
			</c:otherwise>
		</c:choose>
	</h2>
	<%-- 	Formulario de registro de un Juego nuevo --%>
	<form:form modelAttribute="juego" method="POST"
		action="${pageContext.request.contextPath}/juego/save">
		<form:hidden path="idJuego" />
		<table>

			<tr>
				<td><spring:message code="juego.titulo" /></td>
				<td><form:input path="titulo" required="required" /></td>
				<td><form:errors path="titulo" cssClass="error" /></td>
			</tr>

			<tr>
				<td><spring:message code="juego.categoria" /></td>
				<td><form:select path="categoria.idCategoria"
						items="${listaCategorias}" itemLabel="nombre"
						itemValue="idCategoria" required="required" /></td>
			</tr>

			<tr>
				<td><spring:message code="juego.plataforma" /></td>
				<td><form:select path="plataforma.idPlataforma"
						items="${listaPlataformas}" itemLabel="nombre"
						itemValue="idPlataforma" required="required" /></td>
			</tr>

			<tr>
				<td><spring:message code="juego.fechaLanzamiento" /></td>
				<td><form:input path="fechaLanzamiento"
						value="${fechaLanzamiento}" type="date" required="required" /></td>
				<td><form:errors path="fechaLanzamiento" cssClass="error" /></td>
			</tr>

			<tr>
				<td><spring:message code="juego.descripcion" /></td>
				<td><form:textarea path="descripcion" rows="8" cols="30" /></td>
				<td><form:errors path="descripcion" cssClass="error" /></td>
			</tr>


			<tr>
				<td><input type="submit"
					value="<spring:message code="accion.guardar"/>" /></td>
			</tr>
		</table>
		<form:errors cssClass="errorblock" element="div" />
	</form:form>
	<br> ${msg}
	<br>
	<a href="${pageContext.request.contextPath}/juego/list"><spring:message
			code="accion.listar.juegos" /></a>
</body>
</html>