
<div id="container">

<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script type="text/javascript">
	$('#titulo').text('Gestión de clientes');
</script>

<a class="back" href="${pageContext.servletContext.contextPath}/clientes">Regresar</a>

<form:form modelAttribute="cliente" action="${accion}" role="form">
	<fieldset>
	<legend>Nuevo Cliente</legend>
	<form:hidden path='ID'/>
	<div class="form-group">
		<label for='nombre'>Nombre</label>
		<form:input path='nombre'/><form:errors path='nombre'/>
	</div>	
	<div class="form-group"><label for='apellido'>Apellido</label><form:input path='apellido'/><form:errors path='apellido'/></div>		
	<div class="form-group"><label for='estado'>Estado</label><form:select path="estado" onchange="cargarMunicipios()">
		<form:option value="-- Seleccione una opcion --"/>
		<form:options items="${estados}" itemLabel="descripcion" itemValue="clave"/>
	</form:select></div>
	<div class="form-group"><label for='municipio'>Municipio</label><form:select path="municipio"/></div>
	<div class="form-group"><label for='direccion'>Direccion</label><form:input path='direccion'/></div>
	<div class="form-group"><label for='telefonoFijo'>TelefonoFijo</label><form:input path='telefonoFijo'/></div>
	<div class="form-group"><label for='telefonoCelular'>TelefonoCelular</label><form:input path='telefonoCelular'/></div>
	<div class="form-group"><label for='rfc'>RFC</label><form:input path='rfc'/></div>
	<div class="form-group"><label for='email'>Email</label><form:input path='email'/></div>
	<div class="form-group"><label for='fecha_nac'>Fecha de Nac.</label><form:input path='fecha_nac'/></div>
	<div class="form-group"><label for='imagen'>Imagen</label><form:input path='imagen'/></div>
	<div class="form-group"><form:button class="enviar">Enviar datos</form:button></div>
	</fieldset>
</form:form>



</div>