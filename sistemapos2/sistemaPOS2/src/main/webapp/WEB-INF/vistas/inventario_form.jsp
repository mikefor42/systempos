<div id="contenedor">

<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<h2>Lista de productos actuales</h2>
<table>	
	<thead>
	<tr>
	<th>ID</th>
	<th>Descripcion</th>
	<th>Cantidad Almacen</th>
	<th>Agregar</th>
	</tr>
	</thead>
	<c:forEach items="${inventarioList}" var="producto">
		<tr>			
			<td>${producto.ID}</td>
			<td>${producto.descripcion}</td>
			<td>${producto.cantidadExistencia}</td>
			<td><a class="button" href="#" onclick="mostrarVentana('${producto.ID}', '${producto.descripcion}');">Agregar</a></td>
		</tr>		
	</c:forEach>
</table>

<div id="agregarDiv" style="display: none;">
<form action="${pageContext.servletContext.contextPath}/inventario/agregar" method="POST">
	<input type="hidden" name="idProducto" id="idTxt"/>
	<label>Descripción:</label><input type="text" id="descripcionTxt"/>
	<label>Cantidad:</label><input type="text" name="cantidad"  id="cantidadTxt"/> 
	<label>Comentario</label><input type="text" name="comentario" id="comentarioTxt" /> 
	<input type="submit"/>
</form>
</div>
</div>