<div id="contenedor">
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script type="text/javascript">
	$('#titulo').text('Gestión de productos');
</script>

<a class="back" href="${pageContext.servletContext.contextPath}/productos"></a>
<form:form id="productosForm" modelAttribute="producto" action="${pageContext.servletContext.contextPath}/productos/${accion}">
	<fieldset>
	<legend>Nuevo Producto</legend>
	<form:hidden path='ID'/>	
		<div class="form-group">
	<label for='descripcion'>Descripcion:</label>
	<form:input path='descripcion'/>
		</div>	
		<div class="form-group">
	<label for='precioVenta'>Precio de venta</label>
	<form:input path='precioVenta'/>
		</div>	
		<div class="form-group">
	<label for='precioCompra'>Precio de compra</label>
	<form:input path='precioCompra'/>
		</div>	
		<div class="form-group">
	<label for='imagenProducto'>Imagen del producto</label>
	<form:input path='imagenProducto'/>
		</div>			
		<div class="form-group">
	<label for='cantidadExistencia'>Cantidad en existencia</label>
	<form:input path='cantidadExistencia'/>
		</div>	

		<div class="form-group">
	<label for='proveedor'>Proveedor</label>
	<form:select items="${proveedores}" path='id_proveedor' itemLabel="nombre" itemValue="ID"><form:option value="-- Seleccione una opcion --"/></form:select>
		</div>		
	
		<div class="form-group">
	<label for='ID_Grupo'>Grupo</label>
	<form:select items="${grupos}" path='ID_Grupo' itemLabel="descripcion" itemValue="clave" onchange="$('#productosForm').attr('action','${pageContext.servletContext.contextPath}/productos/nuevo2').submit()"><form:option value="-- Seleccione una opcion --"/></form:select>
		</div>		
	
	<c:forEach items="${producto.atributos}" var="atributo" varStatus="i">
		<div class="form-group">
			<form:label path="atributos[${i.index}].descripcion" >${producto.atributos[i.index].descripcion }</form:label>
			<form:input path='atributos[${i.index}].valor'/>
		</div>	
	</c:forEach> 	
		<div class="form-group">
	<label></label>
	<form:button class="enviar">Enviar datos</form:button>&nbsp;&nbsp;&nbsp;&nbsp; 
	<button type="button" onclick="window.open('${pageContext.servletContext.contextPath}/productos/atributos')">Agregar Atributos</button>
	<button type="button" onclick="window.open('${pageContext.servletContext.contextPath}/productos/grupos')">Agregar Grupos</button>
		</div>
	</fieldset>
</form:form>
</div>