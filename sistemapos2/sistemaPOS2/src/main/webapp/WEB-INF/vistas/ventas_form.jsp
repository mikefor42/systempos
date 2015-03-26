<div id="contenedor">
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script type="text/javascript"> $('#titulo').text('Ventas');   </script>		

<form:form id="agregarForm" modelAttribute="documento" action="${pageContext.servletContext.contextPath}/ventas/agregar" role="form" cssClass="form-horizontal" >
	<legend>Seleccionar Artículos</legend>
	<div class="form-group">
		<form:label path="numDocumento">Numero Doc.</form:label>
		<div class="col-sm-10"><form:input path="numDocumento" readonly="true"/></div>
		<form:hidden path="detalle.numDocumento" value="${documento.numDocumento}"/>		
	</div>	

	<div class="form-group">
		<form:label path="fecha">Fecha:</form:label>
		<div class="col-sm-10"><form:input path="fecha"  /></div>
	</div>
	<div class="form-group">
		<form:label path="IDCliente">Cliente:</form:label>
		<div class="col-sm-10"><form:select path="IDCliente">
			<form:option value="0" label="-- Seleccione una opcion --"/>
			<form:options items="${clientesList}" itemLabel="Nombre" itemValue="ID"/>
		</form:select></div>
	</div>
	<div class="form-group">
		<label for='buscar'>Producto:</label>
		<div class="col-sm-3"><input type="text" id="buscar" onkeyup="autocompletar()"/></div>
		<div class="col-sm-7"><form:select id="IDProducto" path="detalle.IDProducto" onchange="asignar()"/></div>		
	</div>	
	<div class="form-group">		
		<form:label path="detalle.precio">Precio:</form:label>
		<div class="col-sm-10"><form:input id="precio" path='detalle.precio'/></div>
	</div>
	<div class="form-group">
		<form:label path="detalle.cantidad">Cantidad:</form:label>
		<div class="col-sm-10"><form:input  id="cantidad" path='detalle.cantidad'/></div>
	</div>
	<div class="form-group">
		<label>  </label>
		<form:button class="enviar">Agregar</form:button>
	</div>
</form:form>

<div>
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

<form:form id="documentoForm" modelAttribute="documento" action="${pageContext.servletContext.contextPath}/ventas/documento" class="form-horizontal">
	<fieldset>			
	<div class="form-group">	
		<label>Subtotal:</label>
		<form:input style="color:black" path='subtotal'/>
	</div>	
	<div class="form-group">
		<label>Descuento:</label>
		<div class="col-sm-9">
			<div class="input-group">	
				<div class="input-group-addon">%</div>
				<form:input path='descuento' onblur="calcular()"/>
			</div>	
		</div>
	</div>	
	<div class="form-group">
		<label>Iva:</label>
		<div class="col-sm-9">
			<div class="input-group">
				<div class="input-group-addon">%</div>
				<form:input path='iva' onblur="calcular()"/>
			</div>
		</div>
	</div>
	<div class="form-group">	
		<label>Total:</label>
		<form:input path="total"/>
	</div>
	<div class="form-group">
		<label></label>
		<form:button class="enviar">Enviar datos</form:button>		
	</div>
	</fieldset>
</form:form>

<h4>${mensaje}</h4>
<c:if test="${opciones == true}">
	<script>
		var r = confirm("Desea generar la factura?");
		if(r == true) {
			window.open("${pageContext.servletContext.contextPath}/ventas/imprimir");
		} else {
			
		}
	</script>
</c:if>	

${ documento }
</div>