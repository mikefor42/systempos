<%@ include file="/WEB-INF/views/encabezado.jsp"%>
<p>Clientes
<table border="1">
	<tr>
		<th>Nombre</th>
		<th>Apellido</th>
	</tr>
	<c:forEach items="${clientes}" var="cliente">
		<tr>
			<td><c:out value="${cliente.nombre}" /></td>
			<td><c:out value="${cliente.apellido}" /></td>
			<td><a href="detalleCliente.do">Detalle</a></td>
			<td><a href="nuevoCliente.do">Editar</a></td>
			<td><a href="actualizarCliente.do">Actualizar</a></td>
			<td><a href="borrarCliente.do">Borrar</a></td>
		</tr>
	</c:forEach>
	<tr><td>
	<spring:form method="GET" action="nuevoCliente.do"><spring:button >Nuevo cliente</spring:button></spring:form>
	</td></tr> 	
</table>
<br>
<%@ include file="/WEB-INF/views/piedepagina.jsp"%>


