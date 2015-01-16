<div>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<table border="1" style='color: #808080; font-family: "Book Antiqua", "Times New Roman", Serif;font-size:10; border-left-color: #808080; border-top-color: #808080; border-right-color: #808080; border-bottom-color: #808080; margin-top: 30px;'>	
	<tr><th>Nombre</th><th>Apellido</th><th>RFC</th><th>Email</th><th/><th/>
	<c:forEach var="cliente" items="${clientes}">		
		<tr>
			<td>${cliente.nombre}</td>
			<td>${cliente.apellido}</td>
			<td>${cliente.rfc}</td>
			<td>${cliente.email}</td>
			<td><a href="<s:url value='/clientes/editar?idCliente=${cliente.ID}'/>">Editar</a></td>
			<td><a href="<s:url value='/clientes/borrar?idCliente=${cliente.ID}'/>">Borrar</a></td>					
		</tr>
	</c:forEach>
	<tr><td></td><td></td><td></td><td></td><td></td><td><a href="${pageContext.servletContext.contextPath}/clientes/nuevo"><button>Nuevo</button></a></td></tr>
</table>
</div>
