<div id="contenedor" class="col-sm-8">
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script type="text/javascript"> $('#titulo').text('Ventas');   </script>		

<form:form id="agregarForm" modelAttribute="documento" action="${pageContext.servletContext.contextPath}/ventas/agregar" role="form" cssClass="form-horizontal" >
	<div class="row">
		<div class="col-sm-7"></div>
		<div class="col-sm-5 h5" align="right">Jueves 22 de Marzo de 2015</div><br>
		<a class="back" href="${pageContext.servletContext.contextPath}/ventas/listadoDocumentos">Listado de facturas</a>
		<hr size="2px" width="80%" noshade="noshade" align="right" />
	</div>		
	<form:hidden path="detalle.numDocumento" value="${documento.numDocumento}"/>			

	<div class="form-group">
		<form:label path="IDCliente">Cliente:</form:label>
		<div class="col-sm-10"><form:select path="IDCliente">
			<form:option value="0" label="-- Seleccione una opcion --"/>
			<form:options items="${clientesList}" itemLabel="Nombre" itemValue="ID"/>
		</form:select></div>
	</div>	
	
	<div style="display: none" id="dialogDiv">
		<select id="productoSelect" onchange="asignar()" ondblclick="asignar();$('#dialogDiv').dialog('close')"  oninput="asignar();" onkeypress="alert(event.keyCode);if(event.keyCode == 13) { asignar(); }" multiple="true"></select>
		<label id="descripcionDialog"></label>
	</div>
		
	<div class="form-group">
		<label for='buscar'>Producto:</label>
		<div class="col-sm-3"><input type="text" id="buscar"/><form:hidden path="detalle.IDProducto" id="IDProductoHidden"/><form:hidden id="precio" path='detalle.precio'/></div>
		<div class="col-sm-7" ><label id="descripcion"></label></div>			
	</div>	
	
	<div class="form-group">
		<form:label path="detalle.cantidad">Cantidad:</form:label>
		<div class="col-sm-10"><form:input  id="cantidad" path='detalle.cantidad' value="1" /></div>
	</div>
	<div class="form-group">
		<label>  </label>
		<form:button class="enviar">Agregar</form:button>
	</div>	
</form:form>

<div style="height:230px;overflow:auto;">
	<table>
	<thead>
	<tr><td>Cantidad</td><td>Descripcion</td><td>Precio</td><td>Importe</td><td>Quitar</td></tr>
	</thead>
	<tbody>
	<c:forEach items="${detalleList}" var="detalle" varStatus="i">
		<tr>		
			<td>${detalle.cantidad}</td>
			<td>${detalle.productoSeleccionado.descripcion}</td>
			<td>${detalle.productoSeleccionado.precioVenta}</td>
			<td>${detalle.total}</td>   
			<td><a href="${pageContext.servletContext.contextPath}/ventas/quitar?id=${i.index}">Quitar</a></td>
		</tr>
	</c:forEach>
	</tbody>
	</table>
</div>




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
</div>
<div id="calculosDiv" class="col-sm-3">
<form:form id="documentoForm" modelAttribute="documento" action="${pageContext.servletContext.contextPath}/ventas/documento" class="form-horizontal">
	<fieldset>			
	<div class="form-group">	
		<label class="col-sm-5">Subtotal:</label>
		<div class="col-sm-7"><form:input style="color:black" path='subtotal'/></div>
	</div>	
	<div class="form-group">
		<label class="col-sm-5">Descuento:</label>
		<div class="col-sm-7">
			<div class="input-group">	
				<span class="input-group-addon sizing-addon1" >%</span>
				<form:input path='descuento' onblur="calcular()"/>
			</div>	
		</div>
	</div>	
	<div class="form-group">
		<label class="col-sm-5">Iva:</label>
		<div class="col-sm-7">
			<div class="input-group">
				<span class="input-group-addon sizing-addon1">%</span>
				<form:input path='iva' onblur="calcular()"/>
			</div>
		</div>
	</div>
	<div class="form-group">	
		<label class="col-sm-5">Total:</label>
		<div class="col-sm-7"><form:input path="total"/></div>
	</div>
	<div class="form-group">
		<label class="col-sm-5">A crédito:</label>
		<div class="col-sm-7"><input type="checkbox" onclick="$('#creditoDiv').css('display','block')"></input> </div>
	</div>
	<div id="creditoDiv" style="display: none">
		<label class="col-sm-5">Dias:</label><div class="col-sm-7"><form:input path="dias"/><br><form:button onclick="return false;">Ver créditos</form:button></div>
	</div>
	<div class="form-group">
		<label></label>
		<div><form:button class="enviar" >Enviar datos</form:button></div>		
	</div>	
	</fieldset>
	
</form:form>
</div>