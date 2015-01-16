package com.syscom.webapp.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.syscom.webapp.domain.Persona;
import com.syscom.webapp.services.PersonasManager;
import com.syscom.webapp.services.ProductoManager;

@Controller
public class PersonasController {
	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private PersonasManager personasManager;
	
	@RequestMapping(value="/principal.do")
	public ModelAndView irAPrincipal(HttpServletRequest request, HttpServletResponse response){	
		return new ModelAndView("principal");
	}

	@RequestMapping(value="/moduloClientes.do")
	public ModelAndView mostrarClientes(HttpServletRequest request, HttpServletResponse response){
		List<Persona> p = personasManager.obtenerPersonas();
		Map o = new HashMap<String, Object>();		
		ModelAndView vista = new ModelAndView("clientes");		
		vista.addObject("clientesList", p);		
		return vista;
	}
		
	@RequestMapping(value="/detalleCliente.do", method = RequestMethod.GET)
	public ModelAndView detalleCliente(Model model) {		
		model.addAttribute("cliente", new Persona());
		return new ModelAndView("clientes");
	}
	
	@RequestMapping(value="/nuevoCliente.do", method = RequestMethod.GET)
	public ModelAndView formCliente(Model model) {		
		model.addAttribute("cliente", new Persona());
		return new ModelAndView("clientes");
	}
	
	@RequestMapping(value="/guardarCliente.do", method = RequestMethod.POST)
	public ModelAndView guardarCliente(@ModelAttribute("cliente") Persona cliente, BindingResult result) {
		System.out.println(cliente.toString());		
		return new ModelAndView("principal");
	}
	
	public void setPersonasManager(PersonasManager personasManager) {
		this.personasManager = personasManager;
	}	
}
