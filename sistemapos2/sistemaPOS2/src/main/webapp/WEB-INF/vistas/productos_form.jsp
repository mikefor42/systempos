<div id="contenedor">
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script type="text/javascript">
	$('#titulo').text('Gestión de productos');
</script>

<a class="back" href="${pageContext.servletContext.contextPath}/productos"></a>
<form:form id="productosForm" modelAttribute="producto" action="${pageContext.servletContext.contextPath}/productos/${accion}"    enctype="multipart/form-data">
	<fieldset>
	<legend>Nuevo Producto</legend>
	<form:hidden path='ID'/>	
	
	<div class="form-group">
		<label for='descripcion'>Descripcion:</label><form:input path='descripcion'/>
	</div>	
	<div class="form-group">
		<label for='precioVenta'>Precio de venta</label><form:input path='precioVenta'/>
	</div>	
	<div class="form-group">
		<label for='precioCompra'>Precio de compra</label><form:input path='precioCompra'/>
	</div>	
	<div class="form-group">
		<label for='imageFile'>Imagen del producto</label><input type="file" name="imageFile" id="imageFile">
	</div>			
	<div class="form-group">
		<label for='cantidadExistencia'>Cantidad en existencia</label><form:input path='cantidadExistencia'/>
	</div>		
	<div class="form-group">
		<label for='proveedor'>Proveedor</label><form:select items="${proveedores}" path='id_proveedor' itemLabel="nombre" itemValue="ID"><form:option value="-- Seleccione una opcion --"/></form:select>
	</div>		
	<div class="form-group">
		<label for='ID_Grupo'>Grupo</label><form:select items="${grupos}" path='ID_Grupo' itemLabel="descripcion" itemValue="clave" onchange="$('#productosForm').attr('action','${pageContext.servletContext.contextPath}/productos/nuevo2').submit()"><form:option value="-- Seleccione una opcion --"/></form:select>
	</div>		
	
	<c:forEach items="${producto.atributos}" var="atributo" varStatus="i">
		<div class="form-group">
			<form:label path="atributos[${i.index}].descripcion" >${producto.atributos[i.index].descripcion }</form:label>
			<form:input path='atributos[${i.index}].valor'/>
		</div>	
	</c:forEach> 	
	<div class="form-group">
		<label></label>
		<form:button  class="enviar">Enviar datos</form:button>&nbsp;&nbsp;&nbsp;&nbsp; 
		<button type="button" onclick="$('#atributosDiv').dialog();">Agregar Atributos</button>
		<button type="button" onclick="$('#gruposDiv').dialog();">Agregar Grupos</button>
	</div>
	</fieldset>
</form:form>
</div>

<div id="atributosDiv" style="display: none">
	<form:form modelAttribute="atributoForm" action="${pageContext.servletContext.contextPath}/productos/nuevoAtributo" target="_blank">
		<div class="form-group">
			<form:label path="clave">Grupo: </form:label><form:select path="clave" items="${gruposList}" itemValue="clave" itemLabel="descripcion"></form:select>
		</div>	
		<div class="form-group">
			<form:label path="descripcion">Atributo: </form:label><form:input path="descripcion"/>
		</div>
		<div class="form-group">
			<form:button>Enviar</form:button>
		</div>	
	</form:form>
	<table>
		<tr><th>Grupo</th><th>Atributo</th></tr>
		<c:forEach items="${atributosList}" var="atributo">
			<tr><td>${atributo.clave }</td><td>${atributo.descripcion }</td></tr>
		</c:forEach>
	</table>
</div>

<div id="gruposDiv" style="display: none">
	<form:form modelAttribute="grupoForm" action="${pageContext.servletContext.contextPath}/productos/nuevoGrupo" target="_blank">
	<div class="form-group">
		<form:label path="descripcion">Grupo: </form:label><form:input path="descripcion"/>
	</div>
	<div class="form-group">
		<form:button>Enviar</form:button>
	</div>	
	</form:form>	
	<table>
		<tr><th>Id</th><th>Grupo</th></tr>
		<c:forEach items="${gruposList}" var="grupo">
			<tr><td>${grupo.clave }</td><td>${grupo.descripcion }</td></tr>
		</c:forEach>
	</table>
</div>



