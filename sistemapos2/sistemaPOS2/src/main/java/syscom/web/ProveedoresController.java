package syscom.web;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
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
@RequestMapping("/proveedores")
@SessionAttributes("proveedores")
public class ProveedoresController {
	
	@Autowired
	PersonasDAO dao;
	
	@RequestMapping(method=RequestMethod.GET)
	public String listarProveedores(Model model){
		model.addAttribute("proveedores",dao.obtenerProveedores());		
		System.out.println("proveedores");
		return "lista-proveedores";
	}
	
	@RequestMapping(value="/nuevo", method=RequestMethod.GET)
	public String nuevoProveedor(Model model){
		Persona p = new Persona();
		model.addAttribute("proveedor", p);
		model.addAttribute("estados", dao.obtenerEstados());
		return "nuevo-proveedor";
	}
	
	@RequestMapping(value="/nuevo", method=RequestMethod.POST)
	public String guardarProveedor(@ModelAttribute("proveedor") @Valid Persona proveedor, BindingResult br){
		if(br.hasErrors()){
			return "nuevo-proveedor";
		}		
		dao.guardarProveedor(proveedor);		
		return "redirect:/proveedores/";
	}
	
	@RequestMapping(value="/editar", method=RequestMethod.GET)
	public String editarProveedor(@RequestParam(value="idproveedor", required=true) long idproveedor, Model model){
		Persona p = dao.obtenerProveedor(idproveedor);
		model.addAttribute("proveedor", p);
		return "editar-proveedor";
	}
	
	@RequestMapping(value="/editar", method=RequestMethod.POST)
	public String editarProveedor(@ModelAttribute("proveedor") @Valid Persona proveedor, BindingResult br){
		if(br.hasErrors()){
			return "editar-proveedor";
		}		
		dao.editarProveedor(proveedor);		
		return "redirect:/proveedores/";
	}
	
	@RequestMapping(value="/borrar", method=RequestMethod.GET)
	public String borrarProveedor(@RequestParam("idproveedor") long idproveedor, Model model){
		dao.borrarProveedor(idproveedor);		
		return "redirect:/proveedores/";
	}
	
	@RequestMapping(value="/imprimir", method=RequestMethod.GET)	
	public @ResponseBody void imprimir(Model model, HttpServletResponse response) throws IOException, JRException {
		List<Persona> l = (List<Persona>) model.asMap().get("proveedores");
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
