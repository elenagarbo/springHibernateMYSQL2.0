<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Panel de administración. Aqui puedes borrar noticias</h2>


<c:if test="${!empty listRestaurantes}">
	<table class="tg">
	<tr>
		<th width="80">Restaurante ID</th>
		<th width="120">Restaurante Nombre</th>
		<th width="120">Restaurante Direccion</th>
		<th width="60">Restaurante Tipo</th>
	
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listRestaurantes}" var="restaurante">
		<tr>
			<td>${restaurante.id}</td>
			<td>${restaurante.nombre}</td>
			<td>${restaurante.direccion}</td>
			<td>${restaurante.tipo}</td>
			
			<td><a href="<c:url value='/edit/${restaurante.id}' />" >Edit</a></td>
			<td><a href="<c:url value='/remove/${restaurante.id}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>

<form action="logout" method="post">
		<input value="Logout" type="submit">
	</form>
</body>
</html>