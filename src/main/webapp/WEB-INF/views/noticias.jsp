<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2>Zona publica de noticias. Aqui tienes todas las noticias</h2>

<div class="container">

		<h2>Seccion de Noticias</h2>

<!-- 		<a href="LeerNoticias"> -->

<%--  <% String msg = (String)session.getAttribute("servletMsg"); 
out.println(msg);
<%--  %> --%>

	
</div>

<table>
        <tr>
            <td>ID</td><td>Titulo</td><td>Descripcion</td>
        </tr>
        <c:forEach items="${employees}" var="new">
            <tr>
            <td>${new.id}</td>
            <td>${new.title}</td>
            <td>${new.description}</td>
            <td><a href="<c:url value='/edit-${new.id}-employee' />">${new.ssn}</a></td>
            <td><a href="<c:url value='/delete-${new.id}-employee' />">delete</a></td>
            
            <td><a href="editEmployee?id=${new.id}">Edit</a>
                <a href="deleteEmployee?id=${new.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>


<c:url var="addNoticia" value="/noticia/add" ></c:url>
<form:form action="${addNoticia }" commandName="noticia">
<!-- <table> -->
<!-- 			<tr> -->
<!-- 			<td><form:label path="employeeName"> -->
<!-- 						<spring:message text="Employee Name" /> -->
<!-- 					</form:label></td> -->
<!-- 					<td> -->
<!-- 			<form:input path="employeeName"  type="text"/></td> -->
			
<!-- 			</tr> -->
			
<!-- 			<tr> -->
<!-- 			<td><form:label path="employeeContact"> -->
<!-- 						<spring:message text="Employee Contact" /> -->
<!-- 					</form:label></td> -->
<!-- 					<td> -->
<!-- 			<form:input path="employeeContact" type="text"/></td> -->
<!-- 			<td> -->
<!-- 			</tr> -->
			
<!-- 			<tr> -->
<!-- 			<td> -->
<!-- 			<input type="submit" -->
<%-- 					value="<spring:message text="Add Person"/>" /> --%>
<!-- 			</td> -->
<!-- 			</tr> -->
<!-- 		</table> -->
		
		<table border="1">
		<tr>
		<th> Noticia Id </th>
		<th> Noticia Titulo </th>
		<th> Noticia Descripcion </th>
		<th> Acciones </th>
		</tr>
		
		<c:if test="${!empty noticiaList}">
			<c:forEach items="${noticiaList}" var="noticia">
			<tr>
			<td>${noticia.id }</td>
			<td>${noticia.title }</td>
			<td>${noticia.description }</td>
			<td><a href="<c:url value='/removeNoticia/${noticia.id}' />" >Delete</a></td>
<%-- 			<td><a href="<c:url value='/editNoticia/${noticia.id}' />" >Edit</a></td> --%>
			</tr>
			</c:forEach>
		</c:if>
		</table>
</form:form>
</body>
</html>