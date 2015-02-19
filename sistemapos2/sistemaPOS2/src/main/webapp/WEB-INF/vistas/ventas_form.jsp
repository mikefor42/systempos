<div id="contenedor">

<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script type="text/javascript">
	$('#titulo').text('Ventas');
</script>
		
<form:form id="agregarForm" modelAttribute="documento" action="${pageContext.servletContext.contextPath}/ventas/agregar" role="form" >
	<fieldset>	
		<legend>Seleccionar Artículos</legend>	
		<label>Producto:</label>  
		<input type="text" id="buscar" onkeypress="autocompletar(this.value)"/> 
		<form:select id="IDProducto" path="detalle.IDProducto" onchange="asignar()"/>		
		<label for='precio'>Precio:</label><form:input id="precio" path='detalle.precio'/><br>
		<label for='cantidad'>Cantidad:</label><form:input  id="cantidad" path='detalle.cantidad'/>						
		<form:button class="enviar">Agregar</form:button>
	</fieldset>
</form:form>
<div style="float: left; margin-right: 100px">
<table>
<thead>
<tr>
<td>Cantidad</td><td>Descripcion</td><td>Precio</td><td>Importe</td><td>Quitar</td></tr>
</thead>
<c:forEach items="${detalleList}" var="detalle" varStatus="i">
	<tr>		
		<td>${detalle.cantidad}</td>
		<td>${detalle.productoSeleccionado.descripcion}</td>
		<td>${detalle.productoSeleccionado.precioVenta}</td>
		<td>${detalle.total}</td>   
		<td><a href="${pageContext.servletContext.contextPath}/ventas/quitar?id=${i.index}">Quitar</a></td>
	</tr>
</c:forEach>
</table>
</div>

	<form:form id="documento" modelAttribute="documento" action="${pageContext.servletContext.contextPath}/ventas/documento">
		<fieldset>
		<label>Subtotal:</label><form:input style="color:black" path='subtotal'/>
		<label>Descuento:</label><form:input path='descuento' onblur="calcular()"/>
		<label>Iva:</label><form:input path='iva' onblur="calcular()"/>
		<label>Total:</label><form:input path="total"/>
		<label></label><form:button class="enviar">Enviar datos</form:button>
		</fieldset>
	</form:form>
	<h4>${mensaje}</h4>	


</div>