package syscom.web;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionController {
	public static final String DEFAULT_ERROR_VIEW = "mensajeError";
	
	@ExceptionHandler(value={Exception.class, RuntimeException.class})
	public @ResponseBody String defaultErrorHandler(Exception e, HttpServletResponse response) {
		StringWriter sw = new StringWriter();
		PrintWriter p =new  PrintWriter(sw);
		e.printStackTrace(p);
		String s = sw.toString();
		String h = "<input class='toggle-box' id='header1' type='checkbox'>"+
					"<label for='header1'>Click here to read more!</label>"+
					"<h4>"+ s +"</h4>";
		String c = "<style>.toggle-box {  display: none; }"+
					".toggle-box + label {"+
					"  cursor: pointer;"+
					 " display: block;"+
					 " font-weight: bold;"+
					 " line-height: 21px;"+
					"  margin-bottom: 5px;"+
					"}"+
					
					".toggle-box + label + h4 {"+
					"  display: none;"+
					"  margin-bottom: 10px;"+
					"}"+
					
					".toggle-box:checked + label + h4 {"+
					"  display: block;"+
					"  font-family: 'Times New Roman', Times, serif;"+
					"}"+
					
					".toggle-box + label:before {"+
					"  background-color: #4F5150;"+
					"  -webkit-border-radius: 10px;"+
					"  -moz-border-radius: 10px;"+
					"  border-radius: 10px;"+
					"  color: #FFFFFF;"+
					"  content: '+';"+
					"  display: block;"+
					"  float: left;"+
					"  font-weight: bold;"+
					"  height: 20px;"+
					"  line-height: 20px;"+
					"  margin-right: 5px;"+
					"  text-align: center;"+
					"  width: 20px;"+
					"}"+
					
					".toggle-box:checked + label:before {"+
					"  content: '\2212';"+
					"}</style>";
					System.out.println("Errores:");
					e.printStackTrace();
					return "<h3>Ocurrio un error al procesar la petición</h3><br><h4>"+ e.getMessage() + "</h4>" + c+h;
	}
}
 