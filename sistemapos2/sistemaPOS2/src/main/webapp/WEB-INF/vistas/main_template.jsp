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

<script src="<c:url value='/resources/js/jquery.js'/>"></script>
<link rel="stylesheet" href="<c:url value='/resources/js/jquery-ui.css'/>" />
<script src="<c:url value='/resources/js/jquery-ui.min.js'/>"></script>
<script src="<c:url value='/resources/js/chosen.proto.min.js'/>"></script>
<script src="<c:url value='/resources/js/chosen.jquery.min.js'/>"></script>
<script type="text/javascript">
	 var items;

	 $(function() {
    	$( "#fecha_nac" ).datepicker();
  	});
	
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
	
	 function cargarMunicipios(){	 		
	 		var id = $("#estado").val();
	 		$("#municipio").empty();
	 		$.ajax({
	 			url:"${pageContext.servletContext.contextPath}/home/municipios",
	 			data: {estado:id},
	 			dataType:'json',
	 			success:function(data){ 				
	 				for(var i=0;i<data.length;i++){	 					
	 					$("#municipio").append("<option value='"+data[i].clave+"'>"+data[i].descripcion+"</option>");
	 				}	 				
	 			}
	 		}); 		
 	}
 	
 	function autocompletar(texto) {			
	 		$.ajax({
	 			url:"${pageContext.servletContext.contextPath}/ventas/productos?texto="+texto,
	 			dataType:'json',
	 			success:function(data){	 						
	 				data.map(function(item){	 					
	 					var o = $("<option value='"+item.id+"'>"+item.descripcion+"</option>")
	 					$("#IDProducto").append(o)	 				
	 				})
	 				items = data;		 												 						 				 				
	 			}
		 	}); 		
 	}	
 	
 	function asignar(){
 		var i = $("#IDProducto option").index($("#IDProducto option:selected"));	 	
		$("#precio").val(items[i].precioVenta)
 	} 	
 	
 	function calcular() {
 		var iva = $("#iva").val();
 		var descuento = $("#descuento").val();
 		var subtotal = $("#subtotal").val();
 		
 		var total = descuento != 0 ? subtotal - subtotal * (descuento/100): subtotal;
 		var total = iva != 0 ? total - total * (iva/100):total;
 		
 		$("#total").val(total);
 	}
 	
</script>

<link href="<c:url value="/resources/css/menu.css" />" rel="stylesheet"> 
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
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