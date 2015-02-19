<div id="contenedor">
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<script type="text/javascript">
	$('#titulo').text('Gestión de productos');
</script>



<a href="${pageContext.servletContext.contextPath}/productos/nuevo"> <button class="nuevo">NUEVO</button></a>
   
<h2>Lista de productos actuales</h2>

<table>	
	<thead>
	<tr>
	<th>Descripcion</th>
	<c:forEach items="${titulosList}" var="titulo">
		<th>${titulo.atributoRow.label}</th>		
	</c:forEach>	
	<th>Editar</th>
	<th>Borrar</th>		
	</tr>
	</thead>
	
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
			<td><a class="button" href="<s:url value='/productos/editar?idproducto=${producto.ID}'/>">Editar</a></td>
			<td><a class="button" href="<s:url value='/productos/borrar?idproducto=${producto.ID}'/>">Borrar</a></td>					
		</tr> 
	</c:forEach>
</table>

</div>
