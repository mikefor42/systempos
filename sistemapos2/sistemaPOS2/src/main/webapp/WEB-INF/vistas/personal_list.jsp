<div id="contenedor">
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<script type="text/javascript">
	$('#titulo').text('Gestión de personal');
</script>


<a href="${pageContext.servletContext.contextPath}/personal/nuevo"> <button class="nuevo">NUEVO</button></a>
   
<h2>Lista del personal actual</h2>
<div style="height:400px; width:900px; overflow:auto;">
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
	<th></th>
	</tr>
	</thead>
	<c:forEach var="personal" items="${personalList}">		
		<tr>
			<td>${personal.nombre}</td>
			<td>${personal.apellido}</td>
			<td>${personal.rfc}</td>
			<td>${personal.email}</td>
			<td><a class="button" href="<s:url value='/personal/editar?idpersonal=${personal.ID}'/>">Editar</a></td>
			<td><a class="button" href="<s:url value='/personal/borrar?idpersonal=${personal.ID}'/>">Borrar</a></td>
			<td><img alt="" class="img-responsive" src="<c:url value='/imagenes?imagen=${personal.imagen}'/>" width="80px" height="80px"></td>
			<td><a class="button" href="<s:url value='/personal/permisos?id=${personal.ID}'/>">Configuración</a></td>					
		</tr>
	</c:forEach>
</table>
</div>
<td><a class="button" href="<s:url value='/personal/imprimir'/>">Reporte de personal</a></td>
</div>
