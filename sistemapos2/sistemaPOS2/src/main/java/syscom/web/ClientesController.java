package syscom.web;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import syscom.dao.PersonasDAO;
import syscom.domain.Persona;

@Controller
@RequestMapping("/clientes")
@SessionAttributes("clientes")
public class ClientesController {
	
	@Autowired
	PersonasDAO dao;
	
	@RequestMapping(method=RequestMethod.GET)
	public String listarClientes(Model model){
		model.addAttribute("clientes",dao.obtenerClientes(1));		
		System.out.println("clientes");
		return "lista-clientes";
	}
	
	@RequestMapping(value="/nuevo", method=RequestMethod.GET)
	public String nuevoCliente(Model model){
		Persona p = new Persona();
		model.addAttribute("cliente", p);		
		return "nuevo-cliente";
	}
	
	@RequestMapping(value="/nuevo", method=RequestMethod.POST)
	public String guardarCliente(@ModelAttribute("cliente") @Valid Persona cliente, BindingResult br){
		if(br.hasErrors()){
			return "nuevo-cliente";
		}		
		dao.guardarCliente(cliente);		
		return "redirect:/clientes/";
	}
	
	@RequestMapping(value="/editar", method=RequestMethod.GET)
	public String editarCliente(@RequestParam(value="idCliente", required=true) String idCliente, Model model){
		Persona p = dao.obtenerCliente(idCliente);
		model.addAttribute("cliente", p);
		return "editar-cliente";
	}
	
	@RequestMapping(value="/editar", method=RequestMethod.POST)
	public String editarCliente(@Valid Persona cliente, BindingResult br){
		if(br.hasErrors()){
			return "editar-cliente";
		}		
		dao.editarCliente(cliente);		
		return "redirect:/clientes/";
	}
	
	@RequestMapping(value="/borrar", method=RequestMethod.GET)
	public String borrarCliente(@RequestParam("idCliente") String idCliente, Model model){
		dao.borrarCliente(idCliente);		
		return "redirect:/clientes/";
	}
	    
	@RequestMapping(value="/imprimir", method=RequestMethod.GET)	
	public @ResponseBody void imprimir(Model model, HttpServletResponse response) throws IOException, JRException {
		List<Persona> l = (List<Persona>) model.asMap().get("clientes");
		HashMap<String, Object> parameters = new HashMap(); 
		InputStream reportStream = new FileInputStream( "C:/Users/Syscom020/Clientes.jasper");
		JRDataSource dataSource = new JRBeanCollectionDataSource(l, true);
		JasperPrint print = JasperFillManager.fillReport(reportStream, parameters, dataSource);
		response.setContentType("application/pdf");
		String fileName = "UserReport.pdf";
		response.setHeader("Content-Disposition", "inline; filename="+ fileName);
		OutputStream out = response.getOutputStream();
		JasperExportManager.exportReportToPdfStream(print, out);
		out.flush();
		out.close(); 		
	}
}
