<div id="contenedor">
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<script type="text/javascript">
	$('#titulo').text('Gestión de clientes');
</script>



  <a href="${pageContext.servletContext.contextPath}/clientes/nuevo"> <button class="nuevo">NUEVO</button></a>
   
<h2>Lista de clientes actuales</h2>
<table>	
<thead>	<tr>
<th>Nombre</th>
<th>Apellido</th>
<th>RFC</th>
<th>Email</th>
<th>Telefono</th>
<th>Celular</th>
<th>Editar</th>
<th>Borrar</th>
<th></th>
</tr>
</thead>
	<c:forEach var="cliente" items="${clientes}">		
		<tr>
			<td>${cliente.nombre}</td>
			<td>${cliente.apellido}</td>
			<td>${cliente.rfc}</td>
			<td>${cliente.email}</td>
			<td>${cliente.telefonoFijo}</td>
			<td>${cliente.telefonoCelular}</td>
			<td><a class="button" href="<s:url value='/clientes/editar?idCliente=${cliente.ID}'/>">Editar</a></td>
			<td><a class="button" href="<s:url value='/clientes/borrar?idCliente=${cliente.ID}'/>">Borrar</a></td>					
		</tr>
	</c:forEach>
</table>
<td><a class="button" href="<s:url value='/clientes/imprimir'/>">Reporte de clientes</a></td>
</div>
