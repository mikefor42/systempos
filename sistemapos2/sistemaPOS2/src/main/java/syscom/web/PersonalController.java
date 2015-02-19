package syscom.web;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.jboss.weld.context.bound.Bound;
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
import syscom.domain.Par;
import syscom.domain.Permiso;
import syscom.domain.Persona;
import syscom.forms.PermisosForm;

@Controller
@RequestMapping("/personal")
@SessionAttributes("personalList")
public class PersonalController {
	
	@Autowired
	PersonasDAO dao;
	
	@RequestMapping(method=RequestMethod.GET)
	public String listarPersonal(Model model){
		model.addAttribute("personalList",dao.obtenerPersonalList());		
		System.out.println("personal");
		return "lista-personal";
	}
	
	@RequestMapping(value="/nuevo", method=RequestMethod.GET)
	public String nuevoPersonal(Model model){
		Persona p = new Persona();
		model.addAttribute("personal", p);	
		model.addAttribute("estados", dao.obtenerEstados());
		return "nuevo-personal";
	}
	
	@RequestMapping(value="/nuevo", method=RequestMethod.POST)
	public String guardarPersonal(@ModelAttribute("personal") @Valid Persona personal, BindingResult br){
		if(br.hasErrors()){
			return "nuevo-personal";
		}		
		dao.guardarPersonal(personal);		
		return "redirect:/personal/";
	}
	
	@RequestMapping(value="/editar", method=RequestMethod.GET)
	public String editarPersonal(@RequestParam(value="idpersonal", required=true) long idpersonal, Model model){
		System.out.println("editar get");
		Persona p = dao.obtenerPersonal(idpersonal);
		model.addAttribute("personal", p);
		return "editar-personal";
	}
	
	@RequestMapping(value="/editar", method=RequestMethod.POST)
	public String editarpersonal(@ModelAttribute("personal") @Valid Persona personal, BindingResult br){
		System.out.println("editar post");
		if(br.hasErrors()){
			return "editar-personal";
		}		
		dao.editarPersonal(personal);		
		return "redirect:/personal/";
	}
	
	@RequestMapping(value="/borrar", method=RequestMethod.GET)
	public String borrarPersonal(@RequestParam("idpersonal") long idpersonal, Model model){
		dao.borrarPersonal(idpersonal);		
		return "redirect:/personal/";
	}
	
	@RequestMapping(value="/permisos", method=RequestMethod.GET)
	public String obtenerPermisos(Model model, @RequestParam("id") long id) {
		List<Permiso> l = dao.obtenerPermisosPersonal(id);
		PermisosForm permisosForm = new PermisosForm();
		permisosForm.setPermisosList(l);
		permisosForm.setIDPersona(id);
		permisosForm.setModulosMap(dao.obtenerModulos());
		model.addAttribute("permisosForm",permisosForm);
		return "permisos";
	} 
	
	@RequestMapping(value="/permisos", method=RequestMethod.POST)
	public String guardarPermisos(Model model, @ModelAttribute("permisosForm") PermisosForm permisosForm) {
		List<Permiso> l = permisosForm.getPermisosList();  
		for (Iterator iterator = l.iterator(); iterator.hasNext();) {
			Permiso type = (Permiso) iterator.next();
			System.out.print(type.toString());			
		}		
		return "permisos";
	}
	
	@RequestMapping(value="/modulos", method=RequestMethod.POST)
	public String agregarModulo(Model model, @ModelAttribute("permisosForm") PermisosForm permisosForm) {
		dao.agregarModulo(permisosForm.getIDPersona(), permisosForm.getIDModulo());
		return "permisos";
	}
	
	@RequestMapping(value="/imprimir", method=RequestMethod.GET)	
	public @ResponseBody void imprimir(Model model, HttpServletResponse response) throws IOException, JRException {
		List<Persona> l = (List<Persona>) model.asMap().get("personalList");
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
