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
<script src="<c:url value='/resources/js/jquery-ui.min.js'/>"></script>
<link href="<c:url value="/resources/css/estilos.css" />" rel="stylesheet"> 
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">	
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

<script type="text/javascript">
	 var items;

	 $(function() {
    	$( "#fecha_nac" ).datepicker({ dateFormat: 'dd/mm/yy' });
    	$( "#fecha" ).datepicker({ dateFormat: 'dd/mm/yy' });
    	var inputExepcion = $("#agregarForm input") 
    	var divExepcion = $("#agregarForm .form-group div") 
    	var selectExepcion = $("#agregarForm select") 
    	
    	var inputDocumentoExepcion = $("#documentoForm input") 
    	var divDocumentoExepcion = $("#documentoForm .form-group div")  
    	var documentoLabel =  $("#documentoForm label")   	  
		
    	$("input")
    		.not(inputExepcion)
    		.not(inputDocumentoExepcion)
    		.wrap("<div></div>");
    		
    	$("select").not(selectExepcion).wrap("<div></div>");
    	$(".form-group div")
    		.not(divExepcion)
    		.not(divDocumentoExepcion)
    		.addClass("col-sm-10");

		$("label").not(documentoLabel).addClass("col-sm-2 control-label");  
		
    	$("input").addClass("form-control");
    	$("select").addClass("form-control");
    	$("label").addClass("control-label");    	
    	$(".form-group").addClass("form-group-sm");
    	$("table").addClass("table table-striped table-hover table-bordered");
    	$("form").addClass("form-horizontal");
    	$("button").addClass("btn btn-primary"); 	
    	$("#contenedor").addClass("col-sm-10");
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
	
	 function cargarMunicipios(id){	 		
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
 	
 	function autocompletar() {			
 			var texto = $("#buscar").val();
	 		$.ajax({ 	 				
	 			url:"${pageContext.servletContext.contextPath}/ventas/productos?texto="+texto,
	 			dataType:'json',
	 			success:function(data){	 		 				
	 				$("#productoSelect").html("");
	 				data.map(function(item){	 					
	 					var o = $("<option value='"+item.id+"'>"+item.descripcion+"</option>");
	 					$("#productoSelect").append(o);
	 				})
	 				items = data;		 												 						 				 				
	 			}	 			
		 	}); 
		 	
		 	$('#dialogDiv').dialog({
		 		height: 400,
    			width: 500,
    			modal: false,
    			resizable: false,
    			position: { my: "left bottom" , at: "right bottom",  of: "#buscar" },
    			closeOnEscape: true,
    			create: function (event, ui) {
        			$(".ui-widget-header").hide();
   				} 			    			
		 	});
		 	
		 	$("#buscar").focus();			 	
 	}	
 	
 	function asignar(){
 		var i = $("#productoSelect option").index($("#productoSelect option:selected"));	
 		$("#IDProductoHidden").val(items[i].id) 	 		
		$("#precio").val(items[i].precioVenta)
		$("#descripcion").html(items[i].descripcion + "<br>" + items[i].precioVenta)
		$("#descripcionDialog").html(items[i].descripcion)
 	} 	
 	
 	function itemsToString() {
 		var r = "";
 		for(v in items) {
 			r ="r"+v;
 		} 		
 		return  r;
 	}
 	 	
 	function calcular() {
 		var iva = $("#iva").val();
 		var descuento = $("#descuento").val();
 		var subtotal = $("#subtotal").val();
 		
 		var total = descuento != 0 ? subtotal - subtotal * (descuento/100): subtotal;
 		var total = iva != 0 ? total - total * (iva/100):total;
 		
 		$("#total").val(total);
 	}
 	
 function algo() {
 	alert("algo");
 }
 	
</script>
</head>
<body>
	<div class="container">
		<div id="top">	
			<tiles:insertAttribute name="top"/>		
		</div>
		<div class="row">
			<div id="left" class="col-md-2">
				<tiles:insertAttribute name="left"/>
			</div>
			<div id="centerColumn" class="col-md-10">
				<tiles:insertAttribute name="centerColumn"/>
			</div>
		</div>		
		<div id="bottom">
			<tiles:insertAttribute name="bottom"/>
		</div>			
	</div>
</body>
</html>