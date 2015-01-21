<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<table border="1">	
	<tr><th>ID</th><th>Descripcion</th><th>Cantidad Almacen</th><th>Agregar</th></tr>
	<c:forEach items="${inventarioList}" var="producto">
		<tr>			
			<td>${producto.ID}</td>
			<td>${producto.descripcion}</td>
			<td>${producto.cantidadExistencia}</td>
			<td><a href="${pageContext.servletContext.contextPath}/inventario/agregar?id=${producto.ID}&cantidad=10">Agregar</a></td>
		</tr>		
	</c:forEach>
</table>

