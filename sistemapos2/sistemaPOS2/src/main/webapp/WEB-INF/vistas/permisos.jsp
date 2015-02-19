<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script type="text/javascript">
	$('#titulo').text('Configuraciones');
</script>
<div>	

	<form:form modelAttribute="permisosForm" action="${pageContext.servletContext.contextPath}/personal/permisos" method="POSt">
	<label>Usuario: </label>   <input type="text"/><br>
	<label>Password:  </label> <input type="text"/><br>
	<table border="1">
	<tr><th>Modulo</th><th>Crear</th><th>Leer</th><th>Actualizar</th><th>Eliminar</th></tr>
	<c:forEach items="${permisosForm.permisosList}" var="permiso" varStatus="i">		
		<tr>
			<td>${permiso.modulo}</td>
			<td><form:checkbox path="permisosList[${i.index}].crear"/></td>
			<td><form:checkbox path="permisosList[${i.index}].leer"/></td>
			<td><form:checkbox path="permisosList[${i.index}].actualizar"/></td>
			<td><form:checkbox path="permisosList[${i.index}].eliminar"/></td>						
		</tr>		
	</c:forEach>
	<tr><td><form:button>Enviar</form:button><td><td><a href="agregarModulo()"></a></td></tr>
	</table>	
	</form:form>
</div>

<div>
<form:form action="${pageContext.servletContext.contextPath}/personal/modulos" method="POST" modelAttribute="permisosForm">
	<table>
	<tr>		
		<td><form:select path="IDModulo" items="${permisosForm.modulosMap.entrySet}" itemValue="key" itemLabel="value"/></td>
		<td><form:button>Agregar</form:button></td>
	</tr>
	</table>
</form:form>
</div>
