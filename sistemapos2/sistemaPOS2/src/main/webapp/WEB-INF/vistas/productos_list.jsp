<div>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<table id="tabla" border="1" style='color: #808080; font-family: "Book Antiqua", "Times New Roman", Serif;font-size:10; border-left-color: #808080; border-top-color: #808080; border-right-color: #808080; border-bottom-color: #808080; margin-top: 30px;'>	
	<tr><th>Descripcion</th>
	<c:forEach items="${titulosList}" var="titulo">
		<th>${titulo.atributoRow.label}</th>		
	</c:forEach>			
	</tr>
	<c:set var="titulos" value="" />
	<c:forEach var="producto" items="${productos}">		
		<tr>
			<td>${producto.descripcion}</td>
			<c:forEach items="${titulosList}" var="titulo">
					<c:choose> 
					<c:when test="${producto.tieneAtributo(titulo)}" >
						<td>${titulo.valor}</td>					
					</c:when> 
					<c:otherwise>
						<td></td>
					</c:otherwise>
				</c:choose>
			</c:forEach>			
			<td><a href="<s:url value='/productos/editar?idproducto=${producto.ID}'/>">Editar</a></td>
			<td><a href="<s:url value='/productos/borrar?idproducto=${producto.ID}'/>">Borrar</a></td>					
		</tr> 
	</c:forEach>
	<tr><td></td><td></td><td><a href="${pageContext.servletContext.contextPath}/productos/nuevo"><button>Nuevo</button></a></td></tr>
</table>

</div>
