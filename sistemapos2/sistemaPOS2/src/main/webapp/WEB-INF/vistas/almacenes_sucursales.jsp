<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<div>
	<table border="1">
	<thead>Almacenes</thead>
	<tr><th>Almacen</th></tr>
	<c:forEach items="${almacenes}" var="almacen">
		<tr>
		<td>${almacen.descripcion}</td>
		<td><a href="/almacenes_sucursales/editar?id=${almacen.ID}"/>Editar</a></td>
		<td><a href="/almacenes_sucursales/borrar?id=${almacen.ID}"/>Borrar</a></td>
		</tr>
	</c:forEach>
	</table>
	<br>
	<br>
	<table border="1">
	<thead>Sucursales</thead>
	<tr><th>Sucursal</th></tr>
	<c:forEach items="${sucursales}" var="sucursal">
		<tr>
		<td>${sucursal.descripcion}</td>
		<td><a href="/almacenes_sucursales/editar?id=${sucursal.ID}"/>Editar</a></td>
		<td><a href="/almacenes_sucursales/borrar?id=${sucursal.ID}"/>Borrar</a></td>
		</tr>
	</c:forEach>
	</table>	 
</div>