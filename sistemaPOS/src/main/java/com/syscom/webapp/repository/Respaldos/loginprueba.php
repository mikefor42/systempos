<?php
require_once('conn/conn.php');
require('function.php');
?>
<?php
if (!function_exists("GetSQLValueString")) {
function GetSQLValueString($theValue, $theType, $theDefinedValue = "", $theNotDefinedValue = "") 
{
  if (PHP_VERSION < 6) {
    $theValue = get_magic_quotes_gpc() ? stripslashes($theValue) : $theValue;
  }

  $theValue = function_exists("mysql_real_escape_string") ? mysql_real_escape_string($theValue) : mysql_escape_string($theValue);

  switch ($theType) {
    case "text":
      $theValue = ($theValue != "") ? "'" . $theValue . "'" : "NULL";
      break;    
    case "long":
    case "int":
      $theValue = ($theValue != "") ? intval($theValue) : "NULL";
      break;
    case "double":
      $theValue = ($theValue != "") ? doubleval($theValue) : "NULL";
      break;
    case "date":
      $theValue = ($theValue != "") ? "'" . $theValue . "'" : "NULL";
      break;
    case "defined":
      $theValue = ($theValue != "") ? $theDefinedValue : $theNotDefinedValue;
      break;
  }
  return $theValue;
}
}
?>
<?php
// *** Validate request to login to this site.
if (!isset($_SESSION)) {
  session_start();
}

$loginFormAction = $_SERVER['PHP_SELF'];
if (isset($_GET['accesscheck'])) {
  $_SESSION['PrevUrl'] = $_GET['accesscheck'];
}

if (isset($_POST['user']) && isset($_SESSION['sesion_qap_key']) && !empty($_SESSION['sesion_qap_key']) ) {
  $myVar = $_SESSION['sesion_qap_key'];
  if(isset($_POST[''.$myVar.'']) && empty($_POST[''.$myVar.'']))
  {
    $loginUsername=GetSQLValueString($_POST['user'], "text");
  $password=GetSQLValueString($_POST['password'], "text");  
  inyectar($loginUsername,$password);
  if(intentos(0,$loginUsername))
  {
	$total=intentos(1,$loginUsername);
  }else
  {
	$total=intentos(3,$loginUsername);
  }
  $MM_fldUserAuthorization = "nivel";
  $MM_redirectLoginSuccess3 = "index.php";
  $MM_redirectLoginSuccess1 = "beta/index.php";
  $MM_redirectLoginSuccess2 = "beta2/index.php";
  $MM_redirectLoginFailed = "login.php?m=1";
  $MM_redirectLoginFailed2 = "login.php?m=2";
  $MM_redirectLoginFailed3 = "login.php?m=3";
  $MM_redirecttoReferrer = true;
  mysql_select_db($database, $connection);
 
  $LoginRS__query=sprintf("SELECT usuario, pass, nivel,estado,mac FROM usuarios WHERE usuario=%s AND pass=%s",
  $loginUsername, GetSQLValueString(md5($password), "text")); 
   
  $LoginRS = mysql_query($LoginRS__query, $connection) or die(mysql_error());
  $loginFoundUser = mysql_num_rows($LoginRS);
  
  if($total<3)
  {
	if ($loginFoundUser) 
	{
		intentos(4,$loginUsername);
		$loginStrGroup  = mysql_result($LoginRS,0,'nivel');
		$loginestado  = mysql_result($LoginRS,0,'estado');
		$sistema  = mysql_result($LoginRS,0,'mac');
		//declare two session variables and assign them
		$_SESSION['MM_Username'] = substr($loginUsername, 1, -1);
		$_SESSION['MM_UserGroup'] = $loginStrGroup;	  
		$_SESSION['MM_Userestado'] = $loginestado;
		$_SESSION["ultimoAcceso"]= date("Y-n-j H:i:s"); 
        
        $msg="";
		if($loginestado==1){
		if (isset($_SESSION['PrevUrl']) && true ) {
		$MM_redirectLoginSuccess = $_SESSION['PrevUrl'];	
		}
		if($sistema=='0')
		{
		if($loginStrGroup==0) { 
		id_session2();
        mysql_close(); 
		header("Location: " . $MM_redirectLoginSuccess1 ); 
		}
		else{
		id_session();
		primera();
        mysql_close(); 
		header("Location: " . $MM_redirectLoginSuccess2);
		}
		}else
		{
		$_SESSION['MM_Username'] = NULL;
		$_SESSION['MM_UserGroup'] = NULL;
		$_SESSION['PrevUrl'] = NULL;
		$_SESSION["ultimoAcceso"]=NULL; 
		unset($_SESSION['MM_Username']);
		unset($_SESSION['MM_UserGroup']);
		unset($_SESSION['PrevUrl']);
		unset($_SESSION["ultimoAcceso"] );
		if(isset($_SESSION['sesion_qap_key']))
			unset($_SESSION['sesion_qap_key']);
         mysql_close(); 
		header("Location: ". $MM_redirectLoginFailed);
		}
		/*if($loginStrGroup==1) { header("Location: " . $MM_redirectLoginSuccess2 ); }
		if($loginStrGroup==3) { header("Location: " . $MM_redirectLoginSuccess2 ); }
		if($loginStrGroup==4) { header("Location: " . $MM_redirectLoginSuccess2 ); }
		if($loginStrGroup==5) { header("Location: " . $MM_redirectLoginSuccess2 ); }
		*/
		}else
		if($loginestado==2)
		{
		{
		  $sql=mysql_query("select mensaje from bloqueo where usuario=$loginUsername");
          if(mysql_num_rows($sql)){
             $msg=mysql_fetch_array($sql);
            $_SESSION["msg"]=$msg[0];
          }else{
            $_SESSION["msg"]=NULL;
            unset($_SESSION["msg"]);
          }
         
		  mysql_close(); 
		header("Location: ". $MM_redirectLoginFailed2 );
		}
		}
	}
	else {
	intentos(2,$loginUsername);
	bad($loginUsername,$password);
    mysql_close(); 
	header("Location: ". $MM_redirectLoginFailed );
	}
  }else
  {
	if(intentos(5,$loginUsername))
	{
		if ($loginFoundUser) 
		{
		intentos(4,$loginUsername);
		$loginStrGroup  = mysql_result($LoginRS,0,'nivel');
		$loginestado  = mysql_result($LoginRS,0,'estado');
		$sistema  = mysql_result($LoginRS,0,'mac');
		//declare two session variables and assign them
		$_SESSION['MM_Username'] = substr($loginUsername, 1, -1);
		$_SESSION['MM_UserGroup'] = $loginStrGroup;	  
		$_SESSION['MM_Userestado'] = $loginestado;
		$_SESSION["ultimoAcceso"]= date("Y-n-j H:i:s"); 

		if($loginestado==1){
		if (isset($_SESSION['PrevUrl']) && true ) {
		$MM_redirectLoginSuccess = $_SESSION['PrevUrl'];	
		}
		if($sistema=='0')
		{
		if($loginStrGroup==0) { 
		id_session();
        mysql_close(); 
		header("Location: " . $MM_redirectLoginSuccess1 ); 
		}
		else{
		id_session();
		primera();
        mysql_close(); 
		header("Location: " . $MM_redirectLoginSuccess2);
		}
		}else
		{
		$_SESSION['MM_Username'] = NULL;
		$_SESSION['MM_UserGroup'] = NULL;
		$_SESSION['PrevUrl'] = NULL;
		$_SESSION["ultimoAcceso"]=NULL; 
		unset($_SESSION['MM_Username']);
		unset($_SESSION['MM_UserGroup']);
		unset($_SESSION['PrevUrl']);
		unset($_SESSION["ultimoAcceso"] );
        mysql_close(); 
		header("Location: ". $MM_redirectLoginFailed );
		}
		/*if($loginStrGroup==1) { header("Location: " . $MM_redirectLoginSuccess2 ); }
		if($loginStrGroup==3) { header("Location: " . $MM_redirectLoginSuccess2 ); }
		if($loginStrGroup==4) { header("Location: " . $MM_redirectLoginSuccess2 ); }
		if($loginStrGroup==5) { header("Location: " . $MM_redirectLoginSuccess2 ); }
		*/
		}else
		if($loginestado==2)
		{
		{
		  mysql_close(); 
		header("Location: ". $MM_redirectLoginFailed2 );
		}
		}
		}
		else {
		intentos(2,$loginUsername);
		bad($loginUsername,$password);
        mysql_close(); 
		header("Location: ". $MM_redirectLoginFailed );
		}
	}else
	{
	   mysql_close(); 
		header("Location: ". $MM_redirectLoginFailed3 );
		
	}
  }
  }  
}
?>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=0" />
<title>.: Login :.</title>
<!--<link rel="stylesheet" href="css/style.css" type="text/css" media="all" />-->
<link href='http://fonts.googleapis.com/css?family=Coda' rel='stylesheet' type='text/css' />
<link href='http://fonts.googleapis.com/css?family=Jura:400,500,600,300' rel='stylesheet' type='text/css' />
<link rel="stylesheet" type="text/css" href="css/QapTcha.jquery.css" media="screen" />
<link type="text/css" rel="stylesheet" media="all" href="css/ui-lightness/jquery-ui-1.8.21.custom.css"/>
<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.7.2.min.js" type="text/javascript"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.9/jquery-ui.min.js" type="text/javascript"></script>
<script type="text/javascript" src="js/captcha/jquery.js"></script>
<script type="text/javascript" src="js/captcha/jquery-ui.js"></script>
<script type="text/javascript" src="js/captcha/jquery.ui.touch.js"></script>
<script type="text/javascript" src="js/captcha/QapTcha.jquery.js"></script>
<script type="text/javascript">
	var numero = 1;
	$(document).ready(function() {
		$('.QapTcha').QapTcha({
			autoSubmit : false,
			autoRevert : true,
			PHPfile : 'captchasesionmanager.php'
		});
	});	
</script>
<style type="text/css">
#bg{
	background:url(img/BG.JPG)repeat-x fixed center top;
}
.color-red{
	color:#bb2828;
	font-family: Verdana;
	clear: both;
	font-size:10px;
}
.form-control{
	background-color:#FFF;
}

.container1 {
	width: 860px;
	position:relative;
	float:center;
	padding-top: 40px;
	margin: 0px auto;
	overflow: hidden;
	height:600px;
	margin-top:10px;
	
	background:url(img/login.PNG) no-repeat; 
	background-size:100%;
}

.section {
	float: left;
	padding-bottom: 30px;
	padding-top: 110px;
	width:200px;
	margin-left:327px;
	color:#FFF;
	font-weight:bold;	

}
button, html input[type="button"], input[type="reset"], input[type="submit"] {
    cursor: pointer;
	
}
.btn-danger {
    color: #FFF;
    background-color: #055562;
    border-color: #03363e;
	margin-left:65px;
}

.btn-danger:hover {
    
    background-color: #58aba4;
   
}

.btn {
    display: inline-block;
    padding: 6px 12px;
    margin-bottom: 0px;
    font-size: 14px;
    font-weight: normal;
    line-height: 1.42857;
    text-align: center;
    white-space: nowrap;
    vertical-align: middle;
    cursor: pointer;
    -moz-user-select: none;
    background-image: none;
    border: 1px solid transparent;
    border-radius: 4px;
}
.QapTcha .bgSlider{
   width:100%;
}
.QapTcha .dropSuccess {
	color:white;
}
</style>
</head>
<body id="bg">	
	<div class="container1">
		<div class="section">			
			<form id="login" name="login-form" action="<?php echo $loginFormAction; ?>" method="post">
				<div>					
					<?php
					if(isset($_GET['m'])){
						echo '<div class="error" style="color:white;background:red;">';
						if($_GET['m']=='1'){echo 'Usuario y/o Contraseña Incorrecta';}else if($_GET['m']=='2'){echo 'USUARIO BLOQUEADO, CONTACTE AL ADMINISTRADOR<br>'.$_SESSION["msg"];}
						else if($_GET['m']==3){echo "<script>alert('Su cuenta ha sido bloqueada durante 15 minutos, por 3 intentos fallidos,intente mas tarde')</script>";}
						echo "</div>";
					}
					else{
						echo "<h2></h2>";
					}
					?>
				</div>
				<div>
					<label>Usuario</label>
					<div class="form-group">
						<input id="user" name="user" class="form-control" placeholder="Usuario"  style="background:white;width: 100%;height: 30px;" type="text" value="" required="required"/>						
					</div>
					<label>Contrase&ntilde;a</label>
					<div class="form-group">
						<input id="password" name="password" class="form-control" type="password" style="background:white;width: 100%;height: 30px;" value="" placeholder="Clave de usuario" required="required"/>						
					</div>					
				</div>
				<p class="color-red">Deslice la flecha hacia la derecha con
					el rat&oacute;n de su computadora</p>
				<div style="width: 180px;">
					<div class="QapTcha"></div>
				</div>
				<div>
					<input type="submit" name="submit" value="Ingresar"
						class="button btn btn-danger" />
				</div>
			</form>
		</div>
	</div>	
</body>
</html>

