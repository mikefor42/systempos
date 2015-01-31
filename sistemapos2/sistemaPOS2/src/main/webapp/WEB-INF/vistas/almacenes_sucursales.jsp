<div id="contenedor">

<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>

	<h2>Almacenes</h2>
	<table>
	<thead>
	<tr>
	<th>Almacen</th>
	<th>Editar</th>
	<th>Borrar</th>
	</tr>
	</thead>
	<c:forEach items="${almacenes}" var="almacen">
		<tr>
		<td>${almacen.descripcion}</td>
		<td><a class="button" href="/almacenes_sucursales/editar?id=${almacen.ID}"/>Editar</a></td>
		<td><a class="button" href="/almacenes_sucursales/borrar?id=${almacen.ID}"/>Borrar</a></td>
		</tr>
	</c:forEach>
	</table>
	
	
	<h2>Sucursales</h2>
	<table>
	<thead>
	<tr>
	<th>Sucursal</th>
	<th>Editar</th>
	<th>Borrar</tr>
	</tr>
	</thead>
	<c:forEach items="${sucursales}" var="sucursal">
		<tr>
		<td>${sucursal.descripcion}</td>
		<td><a class="button" href="/almacenes_sucursales/editar?id=${sucursal.ID}"/>Editar</a></td>
		<td><a class="button" href="/almacenes_sucursales/borrar?id=${sucursal.ID}"/>Borrar</a></td>
		</tr>
	</c:forEach>
	</table>	 
</div>