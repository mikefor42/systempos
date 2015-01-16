<div>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<table border="1" style='color: #808080; font-family: "Book Antiqua", "Times New Roman", Serif;font-size:10; border-left-color: #808080; border-top-color: #808080; border-right-color: #808080; border-bottom-color: #808080; margin-top: 30px;'>	
	<tr><th>Descripcion</th><th></th><th></th></tr>
	<c:forEach var="producto" items="${productos}">		
		<tr>
			<td>${producto.descripcion}</td>
			<td><a href="<s:url value='/productos/editar?idproducto=${producto.ID}'/>">Editar</a></td>
			<td><a href="<s:url value='/productos/borrar?idproducto=${producto.ID}'/>">Borrar</a></td>					
		</tr>
	</c:forEach>
	<tr><td></td><td></td><td><a href="${pageContext.servletContext.contextPath}/productos/nuevo"><button>Nuevo</button></a></td></tr>
</table>

</div>
