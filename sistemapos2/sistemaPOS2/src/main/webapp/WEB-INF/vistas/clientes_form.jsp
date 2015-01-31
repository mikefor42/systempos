
<div id="contenedor">

<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<a class="back" href="${pageContext.servletContext.contextPath}/clientes"></a>

<form:form modelAttribute="cliente" action="${accion}">
	<fieldset>
	<legend>Nuevo Cliente</legend>
	<span class="formspan"><form:hidden path='ID'/></span>	
	
	<span class="formspan"><label for='nombre'>Nombre</label><form:input path='nombre'/><form:errors path='nombre'/></span>	
	<span class="formspan"><label for='apellido'>Apellido</label><form:input path='apellido'/><form:errors path='apellido'/></span>	
	<span class="formspan"><label for='pais'>Pais</label><form:input path='pais'/><form:errors path='nombre'/></span>
	<span class="formspan"><label for='estado'>Estado</label><form:input path='estado'/></span>
	<span class="formspan"><label for='municipio'>Municipio</label><form:input path='municipio'/></span>
	<span class="formspan"><label for='direccion'>Direccion</label><form:input path='direccion'/></span>
	<span class="formspan"><label for='telefonoFijo'>TelefonoFijo</label><form:input path='telefonoFijo'/></span>
	<span class="formspan"><label for='telefonoCelular'>TelefonoCelular</label><form:input path='telefonoCelular'/></span>
	<span class="formspan"><label for='rfc'>RFC</label><form:input path='rfc'/></span>
	<span class="formspan"><label for='email'>Email</label><form:input path='email'/></span>
	<span class="formspan"><label for='fecha_nac'>Fecha de Nacimiento:</label><form:input path='fecha_nac'/></span>
	<span class="formspan"><label for='imagen'>Imagen</label><form:input path='imagen'/></span>
	<span class="formspan"><form:button class="enviar">Enviar datos</form:button></span>
	</fieldset>
</form:form>



</div>