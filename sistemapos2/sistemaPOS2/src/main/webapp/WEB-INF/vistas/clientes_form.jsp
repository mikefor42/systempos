
<div id="contenedor">

<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script type="text/javascript">
	$('#titulo').text('Gestión de clientes');
</script>

<a class="back" href="${pageContext.servletContext.contextPath}/clientes">Regresar</a>

<form:form modelAttribute="cliente" action="${pageContext.servletContext.contextPath}/clientes/${accion}"  role="form"  enctype="multipart/form-data">
	<fieldset>
	<legend>Nuevo Cliente</legend>	
	<div class="form-group"><label for='nombre'>Nombre</label><form:input path='nombre'/><form:hidden path='ID'/><form:errors path='nombre'/></div>	
	<div class="form-group"><label for='apellido'>Apellido</label><form:input path='apellido'/><form:errors path='apellido'/></div>		
	<div class="form-group"><label for='estado'>Estado</label><form:select path="estado" onchange="cargarMunicipios($('#estado').val())">
		<form:option value="-- Seleccione una opcion --"/>
		<form:options items="${estados}" itemLabel="descripcion" itemValue="clave"/>
	</form:select></div>
	<div class="form-group"><label for='municipio'>Municipio</label><form:select path="municipio" items="${municipios}" itemLabel="descripcion" itemValue="clave"/></div>
	<div class="form-group"><label for='direccion'>Direccion</label><form:input path='direccion'/></div>
	<div class="form-group"><label for='telefonoFijo'>TelefonoFijo</label><form:input path='telefonoFijo'/></div>
	<div class="form-group"><label for='telefonoCelular'>TelefonoCelular</label><form:input path='telefonoCelular'/></div>
	<div class="form-group"><label for='rfc'>RFC</label><form:input path='rfc'/></div>
	<div class="form-group"><label for='email'>Email</label><form:input path='email'/></div>
	<div class="form-group"><label for='fecha_nac'>Fecha de Nac.</label><form:input path='fecha_nac'/></div>
	<div class="form-group"><label for='imagen'>Imagen</label><input type="file" name="imageFile" name="imageFile"></div>
	<div class="form-group"><form:button class="enviar">Enviar datos</form:button></div>
	<div class="form-group"><form:errors /></div>
	</fieldset>	
</form:form>

</div>

<div class="col-sm-2">	
	<img alt="" class="img-responsive" src="<c:url value='/imagenes?imagen=${cliente.imagen}'/>">
</div>	