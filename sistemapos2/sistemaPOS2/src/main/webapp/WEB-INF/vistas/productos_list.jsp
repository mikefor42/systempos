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
	<th></th>
	<th></th>
	<th></th>		
	</tr>
	</thead>	
	
	<c:forEach var="producto" items="${productosList}">		
		<tr>
			<td onmouseover="$('#div${producto.ID}').dialog({position: { my: 'left bottom' , at: 'right bottom', of: $('#div${producto.ID}').parent()  }});" 
				onmouseleave ="$('#div${producto.ID}').dialog('close')">${producto.descripcion}</td>
			<td>
				<a class="button"  href="<s:url value='/productos/editar?idproducto=${producto.ID}'/>">Editar</a>
				<div id="div${producto.ID}" style="display: none">
					${producto.descripcion}<br>
					<c:forEach items="${producto.atributos}" var="atributo" >
						${atributo.descripcion} : ${atributo.valor} <br>  
					</c:forEach>
				</div>
			</td>
			<td>
				<a class="button" href="<s:url value='/productos/borrar?idproducto=${producto.ID}'/>">Borrar</a>
			</td>	
			<td><img alt="" class="img-responsive" src="<c:url value='/imagenesProductos?imagen=${personal.imagen}'/>" width="80px" height="80px"></td>				
		</tr> 
	</c:forEach>
</table>
</div>


