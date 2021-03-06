<%--
  Muestra los datos de un usuario y sus análisis
  
  Author : Francisco Molina Sanchez
 --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page errorPage="error.jsp"%>

<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

	<%-- Perfil de usuario --%>
	<h2>
		<spring:message code="usuario.perfil" />
	</h2>
	<table class="table table-bordered">
			<thead class="thead-dark">
			<tr>
				<th><spring:message code="usuario.nombre" /></th>
				<td>${usuario.nombreUsuario}</td>
			</tr>
			<tr>
				<th><spring:message code="usuario.correo" /></th>
				<td>${usuario.correo}</td>
			</tr>
			<tr>
				<th><spring:message code="usuario.tipoUsuario" /></th>
				<td>${usuario.tipoUsuario.nombre}</td>
			</tr>
			<tr>
				<th><spring:message code="usuario.fechaAlta" /></th>
				<td><fmt:formatDate value="${usuario.fechaAlta}"
						pattern="dd-MM-yyyy HH:mm:ss" /></td>
			</tr>
		</thead>
	</table>
	<br>
	<%-- 	Lista de Analisis --%>
	<h3>
		<spring:message code="juego.analisis" />
	</h3>
	<!-- 	Mensaje de información -->
	<jsp:include page="${raiz}/tiles/mensaje.jsp" />
	<c:choose>
		<c:when test="${empty usuario.analisis}">
			<spring:message code="mensaje.analisis.vacio" />
		</c:when>
		<c:otherwise>
			<table class="table table-bordered">
				<thead class="thead-dark">
					<tr>
						<th><spring:message code="juego.analisis.fechaAlta" /></th>
						<th><spring:message code="juego.titulo" /></th>
						<th><spring:message code="juego.analisis.nota" /></th>
						<th><spring:message code="juego.analisis.comentario" /></th>
						<th><spring:message code="accion.borrar" /></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${usuario.analisis}" var="item">
						<tr>
							<td><fmt:formatDate value="${item.fechaAlta}"
									pattern="dd-MM-yyyy HH:mm:ss" /></td>
							<td><a href="${raiz}/${item.juego.idJuego}/juego/view">${item.juego.titulo}</a></td>
							<td>${item.nota}</td>
							<td align="center"><div class="iffyTip hideText">${item.comentario}</div></td>
							<td><a href="${raiz}/${item.idAnalisis}/analisis/delete"
								onclick="return window.confirm('<spring:message code="accion.analisis.confirmar"/>')">
									<i class="material-icons">delete_forever</i>
							</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:otherwise>
	</c:choose>

	<br>
	<a class="nav-link" href="${raiz}/usuario/edit"><spring:message code="accion.usuario.editar" /></a>
	
	<a class="nav-link" href="${raiz}/inicio"> <spring:message
			code="accion.inicio" /></a>
