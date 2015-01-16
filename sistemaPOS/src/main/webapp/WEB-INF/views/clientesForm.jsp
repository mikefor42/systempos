<%@ include file="/WEB-INF/views/encabezado.jsp"%>
<spring:form method="POST" modelAttribute="cliente" action="guardarCliente.do">
	<spring:input path="nombre" />
	<spring:input path="apellido" />
	<spring:input path="direccion" />
	<spring:input path="email" />
	<spring:input path="estado" />
	<spring:input path="imagen" />
	<spring:input path="municipio" />
	<spring:input path="rfc" />
	<spring:input path="telefonoCelular" />
	<spring:input path="telefonoFijo" />
	<spring:input path="tipo" />	
	<spring:button />
</spring:form>
<%@ include file="/WEB-INF/views/piedepagina.jsp"%>
