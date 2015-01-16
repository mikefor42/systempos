<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<form:form modelAttribute="producto">
	<fieldset>
	<span class='formspan'><label for='ID'>ID</label><form:hidden path='ID'/></span>
	<span class='formspan'><label for='descripcion'>descripcion</label><form:input path='descripcion'/></span>
	<span class='formspan'><label for='precioVenta'>precioVenta</label><form:input path='precioVenta'/></span>
	<span class='formspan'><label for='precioCompra'>precioCompra</label><form:input path='precioCompra'/></span>
	<span class='formspan'><label for='imagenProducto'>imagenProducto</label><form:input path='imagenProducto'/></span>
	<span class='formspan'><label for=''></label><form:input path=''/></span>
	<span class='formspan'><label for='cantidadExistencia'>cantidadExistencia</label><form:input path='cantidadExistencia'/></span>
	<span class='formspan'><label for='cantidadMinima'>cantidadMinima</label><form:input path='cantidadMinima'/></span>
	<span class='formspan'><label for=''></label><form:input path=''/></span>
	<span class='formspan'><label for='proveedor'>proveedor</label><form:input path='proveedor'/></span>
	<span class='formspan'><label for='almacen'>almacen</label><form:input path='almacen'/></span>
	<span class="formspan"><form:button>Enviar datos</form:button></span>
	</fieldset>
</form:form>
