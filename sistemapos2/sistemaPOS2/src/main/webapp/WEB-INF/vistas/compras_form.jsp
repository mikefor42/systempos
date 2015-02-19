<div id="contenedor">
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script type="text/javascript">
	$('#titulo').text('Compras');
</script>

<form:form modelAttribute="detalleDoc" action="${pageContext.servletContext.contextPath}/compras/agregar" >
	<fieldset>		
	<legend>Compras</legend>
		<span class="formspan"><label for='IDProducto'>Producto:</label><form:select items="${productos}" itemLabel="descripcion" itemValue="ID" path="IDProducto" onchange="obtenerProductoFunction()"/></span>
		<br>
		<div id="descripcionDiv"></div>
		<br>
		<span class="formspan"><label for='precio'>Precio:</label><form:input path='precio'/></span>
		<span class="formspan"><label for='cantidad'>Cantidad:</label><form:input path='cantidad'/></span>		
		<span class="formspan"><label for='descuento'>Descuento:</label><form:input path='descuento'/></span>				
		<form:button class="enviar">Agregar</form:button>
	</fieldset>
</form:form>
<div style="float: left; margin-right: 100px">
<table>
<thead>
<tr><td>Cantidad</td><td>Descripcion</td><td>Precio</td><td>Descuento</td><td>Importe</td><td>Quitar</td></tr>
</thead>
<c:forEach items="${detalleList}" var="detalle" varStatus="i">
	<tr>		
		<td>${detalle.cantidad}</td>
		<td>${detalle.productoSeleccionado.descripcion}</td>
		<td>${detalle.productoSeleccionado.precioVenta}</td>
		<td>${detalle.descuento}</td>
		<td>${detalle.total}</td>   
		<td><a href="${pageContext.servletContext.contextPath}/compras/quitar?id=${i.index}">Quitar</a></td>
	</tr>
</c:forEach>
</table>
</div>
<div>
	<form:form  modelAttribute="documento" action="${pageContext.servletContext.contextPath}/compras/documento">
		<span class="formspan"><label>Subtotal:</label><label></label></span>
		<span class="formspan"><label>Descuento:</label><form:input path='descuento'/></span>
		<span class="formspan"><label>Iva:</label><form:input path='iva'/></span>
		<span class="formspan"><label>Total:</label><label></label></span>
		<span class="formspan"><label></label><form:button class="enviar">Enviar datos</form:button></span>
	</form:form>
	<h4>${mensaje}</h4>	
</div>
</div>