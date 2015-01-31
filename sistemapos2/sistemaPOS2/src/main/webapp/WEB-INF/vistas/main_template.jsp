<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.11.1.min.js"></script>
<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/themes/smoothness/jquery-ui.css" />
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/jquery-ui.min.js"></script>
<script type="text/javascript">
	
	function obtenerProductoFunction() {		
		$.ajax({
			type: 'GET',
			url:'${pageContext.servletContext.contextPath}/ventas/obtenerProducto',
			data:'idProducto='+$("#idProducto").val(),
			success: function(data) {
				$("#descripcionDiv").html(data.split("|")[0]);
				$("#precioVenta").val(data.split("|")[1]);				
			},
			error: function(data){
				alert(data.statusText);
			}			
		});	
	}
	
	function mostrarVentana(id,descripcion) {
		$('#idTxt').val(id);
		$('#descripcionTxt').val(descripcion);
		$('#agregarDiv').dialog();
	}
	
	function mostrarVentanaAtributos(eldiv) {
		$('#'+eldiv).dialog();
	}
	
	var titulosTabla = "";
	
	function editarPermisos(id){
		$('#editarPermisosDiv').dialog();
		$('#ID').val(id);
	}

</script>
<link href="<c:url value="/resources/css/menu.css" />" rel="stylesheet">


</head>
<body>
	<div id="top">
	
		<tiles:insertAttribute name="top"/>
		
	</div>
	
	<div id="left">
		<tiles:insertAttribute name="left"/>
	</div>
	
	
	
	<div id="centerColumn">
		<tiles:insertAttribute name="centerColumn"/>
	</div>	
	
	
	
	<div id="bottom">
		<tiles:insertAttribute name="bottom"/>
	</div>	

</body>
</html>