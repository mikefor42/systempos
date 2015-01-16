package syscom.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import syscom.dao.PersonasDAO;
import syscom.domain.Persona;

@Controller
@RequestMapping("/personal")
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
		return "nuevo-personal";
	}
	
	@RequestMapping(value="/nuevo", method=RequestMethod.POST)
	public String guardarPersonal(@Valid Persona personal, BindingResult br){
		if(br.hasErrors()){
			return "nuevo-personal";
		}		
		dao.guardarPersonal(personal);		
		return "redirect:/personal/";
	}
	
	@RequestMapping(value="/editar", method=RequestMethod.GET)
	public String editarPersonal(@RequestParam(value="idpersonal", required=true) String idpersonal, Model model){
		System.out.println("editar get");
		Persona p = dao.obtenerPersonal(idpersonal);
		model.addAttribute("personal", p);
		return "editar-personal";
	}
	
	@RequestMapping(value="/editar", method=RequestMethod.POST)
	public String editarpersonal(@Valid Persona personal, BindingResult br){
		System.out.println("editar post");
		if(br.hasErrors()){
			return "editar-personal";
		}		
		dao.editarPersonal(personal);		
		return "redirect:/personal/";
	}
	
	@RequestMapping(value="/borrar", method=RequestMethod.GET)
	public String borrarPersonal(@RequestParam("idpersonal") String idpersonal, Model model){
		dao.borrarPersonal(idpersonal);		
		return "redirect:/personal/";
	}
}
