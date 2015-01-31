<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<form:form>
		<form:select path="IDCliente" items="${clientesList}" itemLabel="nombre" itemValue="ID"></form:select>		
		<table border="1"> 
		<c:forEach items="cxpList">
			<tr><td>Cuenta</td><a href="#">Abonar</a></tr>
		</c:forEach>
		</table>
	</form:form>
