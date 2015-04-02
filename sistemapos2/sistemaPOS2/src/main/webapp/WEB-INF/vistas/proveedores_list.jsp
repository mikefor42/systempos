<div id="contenedor">
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<script type="text/javascript">
	$('#titulo').text('Gestión de proveedores');
</script>

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
	<th>Imagen</th>
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
			<td><img alt="" class="img-responsive" src="<c:url value='/imagenes?imagen=${proveedor.imagen}'/>" width="80px" height="80px"></td>					
		</tr>
	</c:forEach>
</table>
<td><a class="button" href="<s:url value='/proveedores/imprimir'/>">Reporte de proveedores</a></td>
</div>
