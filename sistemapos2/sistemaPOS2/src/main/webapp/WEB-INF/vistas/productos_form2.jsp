<div id="contenedor">
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<a class="back" href="${pageContext.servletContext.contextPath}/productos/editar"></a>


<form:form modelAttribute="producto" action="${pageContext.servletContext.contextPath}/productos/nuevo2/">
	
	<c:forEach items="${producto.atributos}" var="atributo" varStatus="i">
		<div class="form-group">
			<form:label path="atributos[${i.index}].descripcion" >${producto.atributos[i.index].descripcion }</form:label>
			<form:input path='atributos[${i.index}].valor'/>
		</div>	
	</c:forEach> 
	
		<div class="form-group">
	<form:button class="enviar">Enviar datos</form:button>
		</div>
		<div class="form-group">
	<a href="#" onclick="mostrarVentanaAtributos('atributosDiv')">Agregar Atributo</a>
		</div>
</fieldset>
</form:form>



<div id="atrubutosDiv" style="display: none" >
<form:form modelAttribute="atributo" action="${pageContext.servletContext.contextPath}/productos/agregarAtributo" method="POST"> 

	<div class="form-group"><label for='descripcion'>Nombre:</label><form:input path='descripcion'/></div>
	<div class="form-group"><label for='valor'>Valor:</label><form:input path='valor'/></div>	
	<br>
	<form:button class="enviar">Enviar datos</form:button>
</form:form>
</div>
</div>