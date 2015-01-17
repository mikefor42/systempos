<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.11.1.min.js"></script>
<script type="text/javascript">
	
	function obtenerProductoFunction() {
		
		$.ajax({
			type: 'GET',
			url:'${pageContext.servletContext.contextPath}/ventas/obtenerProducto',
			data:$("#IDProducto").val(),
			success: function(data) {
				$("#descripcionDiv").html(data.split("|")[0]);
				$("#precioVenta").val(data.split("|")[1]);				
			}
		});	
	}

</script>

<style type="text/css">
	@import url(http://fonts.googleapis.com/css?family=Oswald);
	#cssmenu,
	#cssmenu ul,
	#cssmenu ul li,
	#cssmenu ul li a,
	#cssmenu #menu-button {
	  margin: 0;
	  padding: 0;
	  border: 0;
	  list-style: none;
	  line-height: 1;
	  display: block;
	  position: relative;
	  -webkit-box-sizing: border-box;
	  -moz-box-sizing: border-box;
	  box-sizing: border-box;
	}
	#cssmenu:after,
	#cssmenu > ul:after {
	  content: ".";
	  display: block;
	  clear: both;
	  visibility: hidden;
	  line-height: 0;
	  height: 0;
	}
	#cssmenu #menu-button {
	  display: none;
	}
	#cssmenu {
	  width: 1000px;
	  border: 3px solid #fd8a17;
	  border-radius: 3px;
	  font-family: 'Oswald', sans-serif;
	  line-height: 1;
	  background: #f7f7f7;
	  box-shadow: 1px 1px 0 #df7002, 2px 2px 0 #df7002, 3px 3px 3px rgba(0, 0, 0, 0.35);
	}
	#cssmenu > ul {
	  background: url('images/bg.png');
	}
	#cssmenu > ul > li {
	  float: left;
	}
	#cssmenu.align-center > ul {
	  font-size: 0;
	  text-align: center;
	}
	#cssmenu.align-center > ul > li {
	  display: inline-block;
	  float: none;
	}
	#cssmenu.align-right > ul > li {
	  float: right;
	}
	#cssmenu > ul > li > a {
	  padding: 20px 25px;
	  font-size: 14px;
	  text-transform: uppercase;
	  text-decoration: none;
	  color: #fd8a17;
	  -webkit-transition: all .2s ease;
	  -moz-transition: all .2s ease;
	  -ms-transition: all .2s ease;
	  -o-transition: all .2s ease;
	  transition: all .2s ease;
	}
	#cssmenu > ul > li > a:hover,
	#cssmenu > ul > li:hover > a,
	#cssmenu > ul > li.active > a {
	  color: #444444;
	}
	#cssmenu #menu-indicator {
	  position: absolute;
	  bottom: 0;
	  display: block;
	  height: 0;
	  width: 0;
	  border: 5px solid transparent;
	  border-bottom-color: #fd8a17;
	  -webkit-transition: all 0.25s ease-out;
	  -moz-transition: all 0.25s ease-out;
	  -ms-transition: all 0.25s ease-out;
	  -o-transition: all 0.25s ease-out;
	  transition: all 0.25s ease-out;
	}
	#cssmenu.small-screen {
	  width: 100%;
	}
	#cssmenu.small-screen > ul,
	#cssmenu.small-screen.align-center > ul {
	  width: 100%;
	  text-align: left;
	}
	#cssmenu.small-screen > ul > li,
	#cssmenu.small-screen.align-center > ul > li {
	  float: none;
	  display: block;
	  border-top: 1px solid rgba(100, 100, 100, 0.1);
	}
	#cssmenu.small-screen > ul > li > a {
	  padding: 18px 25px;
	}
	#cssmenu.small-screen > ul > li:after,
	#cssmenu.small-screen > ul > li:before {
	  display: none;
	}
	#cssmenu.small-screen #menu-button {
	  display: block;
	  padding: 18px 25px;
	  cursor: pointer;
	  font-size: 14px;
	  text-transform: uppercase;
	  text-decoration: none;
	  color: #fd8a17;
	  background: url('images/bg.png');
	}
	#cssmenu.small-screen #menu-button.menu-opened {
	  color: #444444;
	}
	#cssmenu.small-screen #menu-button:after {
	  content: "";
	  position: absolute;
	  right: 25px;
	  top: 19.5px;
	  display: block;
	  -webkit-box-sizing: content-box;
	  -moz-box-sizing: content-box;
	  box-sizing: content-box;
	  border-top: 2px solid #fd8a17;
	  border-bottom: 2px solid #fd8a17;
	  width: 18px;
	  height: 3px;
	}
	#cssmenu.small-screen #menu-button.menu-opened:after {
	  border-top: 2px solid #444444;
	  border-bottom: 2px solid #444444;
	}
	#cssmenu.small-screen #menu-button:before {
	  content: "";
	  position: absolute;
	  right: 25px;
	  top: 29.5px;
	  display: block;
	  width: 18px;
	  height: 2px;
	  background: #fd8a17;
	}
	#cssmenu.small-screen #menu-button.menu-opened:before {
	  background: #444444;
	}
	#cssmenu.small-screen #menu-indicator {
	  display: none;
	}
	
	#content {      
	  width: 1000px;
	  height: 450px;	
	  padding-left: 20px;  
	}
	
	#pie hr {
		width: 1000px;
	} 	
	
	#pie div {
		padding-top: 0;
		background-color: #4482E6;
		width: 1000px;
		height: 50px;
		color: white;
	} 	
	
	.formspan {
		display: table-row;		
		width: 300px;
	}
	
	.formspan label  {
		display: table-cell;
		margin: 5px;
	}
	
	.formspan input  {
		display: table-cell;
		margin: 5px;
		width: 350px;
	}
</style>
</head>
<body>
	<div id="top">
		<tiles:insertAttribute name="top"/>
	</div>
	<div id="content">
		<tiles:insertAttribute name="content"/>
	</div>	
	<div id="bottom">
		<tiles:insertAttribute name="bottom"/>
	</div>	
</body>
</html>