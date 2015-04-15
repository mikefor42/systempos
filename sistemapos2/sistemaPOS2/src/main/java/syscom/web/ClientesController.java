package syscom.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.util.Date;
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

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import syscom.dao.PersonasDAO;
import syscom.domain.Persona;

@Controller
@RequestMapping("/clientes")
@SessionAttributes({"clientes","cliente"})
public class ClientesController {
	
	@Autowired
	PersonasDAO dao;
	
	@RequestMapping(method=RequestMethod.GET)
	public String listarClientes(Model model){
		model.addAttribute("clientes",dao.obtenerClientes());		
		System.out.println("clientes");
		return "lista-clientes";
	}
	
	@RequestMapping(value="/nuevo", method=RequestMethod.GET)
	public String nuevoCliente(Model model){
		Persona p = new Persona();
		model.addAttribute("cliente", p);		
		model.addAttribute("estados", dao.obtenerEstados());
		model.addAttribute("accion", "nuevo");
		return "nuevo-cliente";
	}
	
	@RequestMapping(value="/nuevo", method=RequestMethod.POST)
	public String guardarCliente(@ModelAttribute("cliente") @Valid Persona cliente, BindingResult br) throws IOException{
		if(br.hasErrors()){
			System.out.println("Errores");	
			for(ObjectError i : br.getAllErrors()) {
				System.out.println(i.getDefaultMessage());
			}
			return "nuevo-cliente";
		}		
		long id = dao.guardarCliente(cliente);	
		String imagen = guardarImagen(cliente.getImageFile(), id);
		cliente.setImagen(imagen);
		dao.editarPersonal(cliente);
		return "redirect:/clientes/";
	}
	
	private String guardarImagen(MultipartFile imagen, long id) throws IOException {	
		String path = "c://imagenes/"+ id + "_cliente.jpg";
		File file = new File(path);
		FileUtils.writeByteArrayToFile(file, imagen.getBytes());
		return id + "_cliente.jpg";
	}
	
	@RequestMapping(value="/editar", method=RequestMethod.GET)
	public String editarCliente(@RequestParam(value="idCliente", required=true) long idCliente, Model model) throws ParseException{
		Persona p = dao.obtenerCliente(idCliente);
		model.addAttribute("cliente", p);
		model.addAttribute("estados", dao.obtenerEstados());
		model.addAttribute("municipios", dao.obtenerMunicipios(Integer.parseInt(p.getEstado())));
		model.addAttribute("accion", "editar");
		return "editar-cliente";
	}
	
	@RequestMapping(value="/editar", method=RequestMethod.POST)
	public String editarCliente(@ModelAttribute("cliente") @Valid Persona clienteLocal, BindingResult br, Model model) throws IOException{
		if(br.hasErrors()){			
			System.out.println("Errores" + clienteLocal.toString());	
			for(ObjectError i : br.getAllErrors()) {
				System.out.println(i.getDefaultMessage());
			}
			return "editar-cliente";
		}		
		if(clienteLocal.getImageFile().getSize() == 0) {
			Persona cli = (Persona) model.asMap().get("cliente");
			clienteLocal.setImagen(cli.getImagen());
		} else {
			String imagen = guardarImagen(clienteLocal.getImageFile(), clienteLocal.getID());
			clienteLocal.setImagen(imagen);
		}
		dao.editarCliente(clienteLocal);		
		return "redirect:/clientes/";
	}
	
	@RequestMapping(value="/borrar", method=RequestMethod.GET)
	public String borrarCliente(@RequestParam("idCliente") long idCliente, Model model){
		dao.borrarCliente(idCliente);
		model.addAttribute("estados", dao.obtenerEstados());
		return "redirect:/clientes/";
	}
	    
	@RequestMapping(value="/imprimir", method=RequestMethod.GET)	
	public @ResponseBody void imprimir(Model model, HttpServletResponse response) throws IOException, JRException {
		List<Persona> l = (List<Persona>) model.asMap().get("clientes");
		HashMap<String, Object> parameters = new HashMap(); 
		parameters.put("fecha", new Date().toLocaleString());
		InputStream reportStream = new FileInputStream( "C:/Users/Syscom020/Documents/clientes.jasper");
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
