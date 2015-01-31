<div id="contenedor">
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>

<a href="${pageContext.servletContext.contextPath}/proveedores/nuevo"> <button class="nuevo">NUEVO</button></a>
   
<h2>Lista de proveedores actuales</h2>
<table>	
<thead>
	<tr>
	<th>Nombre</th>
	<th>Apellido</th>
	<th>RFC</th>
	<th>Email</th>
	<th>Editar</th>
	<th>Borrar</th>
	</tr>
	</thead>
	<c:forEach var="proveedor" items="${proveedores}">		
		<tr>
			<td>${proveedor.nombre}</td>
			<td>${proveedor.apellido}</td>
			<td>${proveedor.rfc}</td>
			<td>${proveedor.email}</td>
			<td><a class="button" href="<s:url value='/proveedores/editar?idproveedor=${proveedor.ID}'/>">Editar</a></td>
			<td><a class="button" href="<s:url value='/proveedores/borrar?idproveedor=${proveedor.ID}'/>">Borrar</a></td>					
		</tr>
	</c:forEach>
</table>

</div>
