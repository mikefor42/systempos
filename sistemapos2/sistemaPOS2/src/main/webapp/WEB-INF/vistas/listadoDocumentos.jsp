<div id="contenedor" class="col-sm-8">
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script type="text/javascript"> $('#titulo').text('Documentos');   </script>

<a class="back" href="${pageContext.servletContext.contextPath}/ventas">Regresar</a>
<table>
<tr><th>Numero Documento</th><th>Cliente</th><th>Monto</th></tr>
<c:forEach items="${documentosList }" var="documento">
	<tr><td>${documento.numDocumento }</td><td>${documento.cliente.nombre } ${ documento.cliente.apellido }</td><td>${documento.total }</td>
</c:forEach>
</table>
</div>