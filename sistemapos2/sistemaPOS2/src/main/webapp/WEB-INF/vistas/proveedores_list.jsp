<div>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<table border="1" style='color: #808080; font-family: "Book Antiqua", "Times New Roman", Serif;font-size:10; border-left-color: #808080; border-top-color: #808080; border-right-color: #808080; border-bottom-color: #808080; margin-top: 30px;'>	
	<tr><th>Nombre</th><th>Apellido</th><th>RFC</th><th>Email</th><th/><th/>
	<c:forEach var="proveedor" items="${proveedores}">		
		<tr>
			<td>${proveedor.nombre}</td>
			<td>${proveedor.apellido}</td>
			<td>${proveedor.rfc}</td>
			<td>${proveedor.email}</td>
			<td><a href="<s:url value='/proveedores/editar?idproveedor=${proveedor.ID}'/>">Editar</a></td>
			<td><a href="<s:url value='/proveedores/borrar?idproveedor=${proveedor.ID}'/>">Borrar</a></td>					
		</tr>
	</c:forEach>
	<tr><td></td><td></td><td></td><td></td><td></td><td><a href="${pageContext.servletContext.contextPath}/proveedores/nuevo"><button>Nuevo</button></a></td></tr>
</table>

</div>
