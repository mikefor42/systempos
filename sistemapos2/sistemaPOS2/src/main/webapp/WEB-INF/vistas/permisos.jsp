<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div>	
	<table  border="1">
	<tr><th>Modulo</th><th>Crear</th><th>Leer</th><th>Actualizar</th><th>Eliminar</th></tr>
	<c:forEach items="${permisosList}" var="permisoS" varStatus="i">
		<tr>
			<td>${permisoS.modulo}</td><td><a href="#" onclick="editarPermisos(${permisoS.ID})">Editar Permisos</a></td>
		</tr>
	</c:forEach>
	</table>

	<div id="editarPermisosDiv">
		<form:form action="${pageContext.servletContext.contextPath}/personal/permisos" method="POST" modelAttribute="permiso">
			<form:hidden path="ID"/>
			<form:button>Enviar</form:button>
		</form:form>					
	</div>	
</div>
