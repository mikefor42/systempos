<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<form:form modelAttribute="factura" >
	<fieldset>
		<form:select items="${clientes}" itemLabel="nombre" itemValue="ID" path="IDCliente"/>
		<form:select items="${productos}" itemLabel="descripcion" itemValue="ID" path="productosSel"/>
		
		<table border="1" style="width: 506px; height: 88px">
				<tr><th>Producto</th><th>Cantidad</th><th>Precio</th><th>Iva</th><th>Subtotal</th><th>Total</th></tr>						
		</table>
		<form:button>Enviar</form:button>
	</fieldset>
</form:form>