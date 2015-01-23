<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<form:form modelAttribute="producto">
	<fieldset>
	<span class='formspan'><form:hidden path='ID'/></span>
	<span class='formspan'><label for='descripcion'>Descripcion:</label><form:textarea path='descripcion'/></span>
	<span class='formspan'><label for='precioVenta'>Precio de venta</label><form:input path='precioVenta'/></span>
	<span class='formspan'><label for='precioCompra'>Precio de vompra</label><form:input path='precioCompra'/></span>
	<span class='formspan'><label for='imagenProducto'>Imagen del producto</label><form:input path='imagenProducto'/></span>	
	<span class='formspan'><label for='cantidadExistencia'>Cantidad en existencia</label><form:input path='cantidadExistencia'/></span>	
	<span class='formspan'><label for='proveedor'>Proveedor</label><form:select items="${proveedoresList }" path='proveedor'/></span>		
	<c:forEach items="${producto.atributos}" var="atributo" varStatus="i">
		<span class='formspan'>
			<form:label path="atributos[${i.index}].atributoRow.label" >${producto.atributos[i.index].atributoRow.label }</form:label>
			<form:input path='atributos[${i.index}].valor'/>
		</span>	
	</c:forEach>
	<span class="formspan"><form:button>Enviar datos</form:button></span>
	<span class="formspan"><span class="formspan"><a href="#" onclick="mostrarVentanaAtributos('atrubutosDiv')">Agregar Atributo</a></span ></span>
	</fieldset>
</form:form>

<div id="atrubutosDiv" style="display: none" >
<form:form modelAttribute="atributoBean" action="${pageContext.servletContext.contextPath}/productos/agregarAtributo" method="POST"> 
	<span class='formspan'><label for='atributoRow.descripcion'>Nombre:</label><form:input path='atributoRow.descripcion'/></span>
	<span class='formspan'><label for='valor'>Valor:</label><form:input path='valor'/></span>
	<span class='formspan'><label for='atributoRow.label'>Etiqueta:</label><form:input path='atributoRow.label'/></span>
	<form:button>Enviar datos</form:button>
</form:form>
</div>
