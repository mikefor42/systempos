<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form modelAttribute="grupo" action="${pageContext.servletContext.contextPath}/productos/nuevoGrupo">
	<div class="form-group">
		<form:label path="descripcion">Grupo: </form:label><form:input path="descripcion"/>
	</div>
	<div class="form-group">
		<form:button>Enviar</form:button>
	</div>	
	</form:form>
	
	<table>
		<tr><th>Id</th><th>Grupo</th></tr>
		<c:forEach items="${gruposList}" var="grupo">
			<tr><td>${grupo.clave }</td><td>${grupo.descripcion }</td></tr>
		</c:forEach>
	</table>
</body>
</html>