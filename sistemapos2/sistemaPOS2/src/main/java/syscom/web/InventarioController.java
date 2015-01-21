package syscom.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import syscom.dao.OperacionesDAO;
import syscom.domain.Producto;

@Controller
@RequestMapping("/inventario")
@SessionAttributes("inventarioList") 
public class InventarioController {
	
	@Autowired
	OperacionesDAO operacionesDAO;
	
	@RequestMapping(method=RequestMethod.GET)
	public String inicio(Model model){
		model.addAttribute("inventarioList", operacionesDAO.obtenerProductos());
		return "inventario";
	}	
	
	@RequestMapping(value="/agregar",method=RequestMethod.GET)
	public String agregar(Model model, @RequestParam("id") long id, @RequestParam("cantidad") int cantidad){
		List<Producto> l = (List) model.asMap().get("inventarioList");
		for(Producto p : l){
			if(p.getID() == id) p.setCantidadExistencia(p.getCantidadExistencia()+cantidad);
		}
		return "inventario";
	}	
	
}
