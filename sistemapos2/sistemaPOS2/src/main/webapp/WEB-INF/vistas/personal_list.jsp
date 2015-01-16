<div>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<table border="1" style='color: #808080; font-family: "Book Antiqua", "Times New Roman", Serif;font-size:10; border-left-color: #808080; border-top-color: #808080; border-right-color: #808080; border-bottom-color: #808080; margin-top: 30px;'>	
	<tr><th>Nombre</th><th>Apellido</th><th>RFC</th><th>Email</th><th/><th/>
	<c:forEach var="personal" items="${personalList}">		
		<tr>
			<td>${personal.nombre}</td>
			<td>${personal.apellido}</td>
			<td>${personal.rfc}</td>
			<td>${personal.email}</td>
			<td><a href="<s:url value='/personal/editar?idpersonal=${personal.ID}'/>">Editar</a></td>
			<td><a href="<s:url value='/personal/borrar?idpersonal=${personal.ID}'/>">Borrar</a></td>					
		</tr>
	</c:forEach>
	<tr><td></td><td></td><td></td><td></td><td></td><td><a href="${pageContext.servletContext.contextPath}/personal/nuevo"><button>Nuevo</button></a></td></tr>
</table>

</div>
