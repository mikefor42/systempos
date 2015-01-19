<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<form:form modelAttribute="detalleDoc" action="${pageContext.servletContext.contextPath}/ventas/agregar" >
	<fieldset>		
		<span class="formspan"><label for='IDProducto'>Producto:</label><form:select items="${productos}" itemLabel="descripcion" itemValue="ID" path="IDProducto" onchange="obtenerProductoFunction()"/></span>
		<div id="descripcionDiv"></div>
		<span class="formspan"><label for='precio'>Precio:</label><form:input path='precio'/></span>
		<span class="formspan"><label for='cantidad'>Cantidad:</label><form:input path='cantidad'/></span>		
		<span class="formspan"><label for='descuento'>Descuento:</label><form:input path='descuento'/></span>				
		<form:button>Agregar</form:button>
	</fieldset>
</form:form>
<div style="float: left; margin-right: 100px">
<table>
<tr><td>Cantidad</td><th>Descripcion</th><th>Precio</th><th>Descuento</th><th>Importe</th></tr>
<c:forEach items="${detalleList}" var="detalle" varStatus="i">
	<tr>		
		<td>${detalle.cantidad}</td>
		<td>${detalle.productoSeleccionado.descripcion}</td>
		<td>${detalle.productoSeleccionado.precioVenta}</td>
		<td>${detalle.descuento}</td>
		<td>${detalle.total}</td>   
		<td><a href="${pageContext.servletContext.contextPath}/ventas/quitar?id=${i.index}">Quitar</a></td>
	</tr>
</c:forEach>
</table>
</div>
<div>
	<span class="formspan"><label>Subtotal:</label><label></label></span>
	<span class="formspan"><label>Descuento:</label><label></label></span>
	<span class="formspan"><label>Iva:</label><label></label></span>
	<span class="formspan"><label>Total:</label><label></label></span>
	<span class="formspan"><label></label><input type="button" value="Enviar datos"/></span>	
</div>