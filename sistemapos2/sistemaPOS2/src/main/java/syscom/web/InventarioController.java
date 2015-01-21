package syscom.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		Map map = new HashMap<String, String>();
		map.put("idProducto", "");
		map.put("cantidad", "");
		map.put("comentario", "");
		model.addAttribute("agregarMap", new HashMap<String, String>());
		return "inventario";
	}	
	
	@RequestMapping(value="/agregar")
	public String agregar(Model model, @RequestParam Map<String,String> params){
		
		List<Producto> l = (List) model.asMap().get("inventarioList");
		for(Producto p : l){
			if(p.getID() == Long.parseLong(params.get("idProducto"))) {
				p.setCantidadExistencia(p.getCantidadExistencia()+Integer.parseInt(params.get("cantidad")));
				p.setComentario(params.get("comentario"));
				operacionesDAO.actualizarInventario(p);
			}
		}
		return "inventario";
	}	
	
}
