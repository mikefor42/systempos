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
@RequestMapping("/proveedores")
public class ProveedoresController {
	
	@Autowired
	PersonasDAO dao;
	
	@RequestMapping(method=RequestMethod.GET)
	public String listarProveedores(Model model){
		model.addAttribute("proveedores",dao.obtenerProveedores(1));		
		System.out.println("proveedores");
		return "lista-proveedores";
	}
	
	@RequestMapping(value="/nuevo", method=RequestMethod.GET)
	public String nuevoProveedor(Model model){
		System.out.println("Nuevo 1");
		Persona p = new Persona();
		model.addAttribute("proveedor", p);		
		return "nuevo-proveedor";
	}
	
	@RequestMapping(value="/nuevo", method=RequestMethod.POST)
	public String guardarProveedor(@Valid Persona proveedor, BindingResult br){
		if(br.hasErrors()){
			return "nuevo-proveedor";
		}		
		dao.guardarProveedor(proveedor);		
		return "redirect:/proveedores/";
	}
	
	@RequestMapping(value="/editar", method=RequestMethod.GET)
	public String editarProveedor(@RequestParam(value="idproveedor", required=true) String idproveedor, Model model){
		Persona p = dao.obtenerProveedor(idproveedor);
		model.addAttribute("proveedor", p);
		return "editar-proveedor";
	}
	
	@RequestMapping(value="/editar", method=RequestMethod.POST)
	public String editarProveedor(@Valid Persona proveedor, BindingResult br){
		if(br.hasErrors()){
			return "editar-proveedor";
		}		
		dao.editarProveedor(proveedor);		
		return "redirect:/proveedores/";
	}
	
	@RequestMapping(value="/borrar", method=RequestMethod.GET)
	public String borrarProveedor(@RequestParam("idproveedor") String idproveedor, Model model){
		dao.borrarProveedor(idproveedor);		
		return "redirect:/proveedores/";
	}
}
