package syscom.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import syscom.dao.ConfiguracionesDAO;
import syscom.dao.ConfiguracionesDAOImpl;
import syscom.dao.OperacionesDAOImpl;

@Controller
public class ConfiguracionesController {
	
	ConfiguracionesDAO dao = new ConfiguracionesDAOImpl();
	
	@RequestMapping(value="/almacenes_sucursales", method=RequestMethod.GET)
	String almacenes_sucursales(Model model) {
		List sucursales = dao.obtenerSucursales();
		List almacenes = dao.obtenerAlmacenes();
		model.addAttribute("sucursales", sucursales);
		model.addAttribute("almacenes", almacenes);
		return "almacenes_sucursales";
	}
	
	@RequestMapping(value="/almacenes_sucursales/editar", method=RequestMethod.GET)
	String editar(Model model) {
		return "almacenes_sucursales";
	}
	
	@RequestMapping(value="/almacenes_sucursales/borrar", method=RequestMethod.GET)
	String borrar(Model model) {
		return "almacenes_sucursales";
	}
	
	
	
	
	
	
}
