package syscom.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import syscom.dao.PersonasDAO;
import syscom.domain.Persona;

@Controller
@RequestMapping("/clientes")
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
}
