package syscom.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import syscom.dao.PersonasDAO;
import syscom.dao.PersonasDAOImpl;
import syscom.dao.ProductosDAO;
import syscom.dao.ProductosDAOImpl;
import syscom.domain.Persona;

@Controller
@RequestMapping("/ventas")
public class VentasController {
	PersonasDAO personasDAO = new PersonasDAOImpl();
	ProductosDAO productosDAO = new ProductosDAOImpl();
	
	@RequestMapping(method=RequestMethod.GET)
	String pantallaVentas(Model model) {		
		model.addAttribute("clientes", personasDAO.obtenerClientes());
		model.addAttribute("productos", productosDAO.obtenerProductos());
		model.addAttribute("cliente", new Persona());
		return "ventas-form";
	}
	
}
