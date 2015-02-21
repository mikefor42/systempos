package syscom.web;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import syscom.dao.PersonasDAO;
import syscom.dao.ProductosDAO;
import syscom.domain.Atributo;
import syscom.domain.AtributoProducto;
import syscom.domain.Producto;

@Controller
@RequestMapping("/productos")
@SessionAttributes({"producto","atributoBean"})
public class ProductosController {
	@Autowired
	ProductosDAO productosDAO;
	@Autowired
	PersonasDAO personasDAO;
	
	
	@RequestMapping( method=RequestMethod.GET)
	public String listarProductos(Model model){
		List<Producto> l = productosDAO.obtenerProductos();	
		
		Set atributos = new HashSet<Atributo>();
		for(Producto p : l) {
			atributos.addAll(p.getAtributos());
		}		
		model.addAttribute("titulosList", atributos);
		model.addAttribute("productosList",l);
		return "lista-productos";
	}
	
	@RequestMapping(value="/nuevo", method=RequestMethod.GET)
	public String nuevoProducto(Model model){
		Producto p = new Producto();
		p.setAtributos(new ArrayList<Atributo>());
		model.addAttribute("producto", new Producto());
		model.addAttribute("atributo", new Atributo());
		model.addAttribute("grupos", productosDAO.obtenerGrupos());
		model.addAttribute("proveedores", personasDAO.obtenerProveedores());
		model.addAttribute("accion","nuevo");
		return "nuevo-producto";
	}
	
	@RequestMapping(value="/nuevo", method=RequestMethod.POST)
	public String guardarProducto(@Valid Producto producto, BindingResult br){
		if(br.hasErrors()){
			return "nuevo-producto";
		}		
		
		productosDAO.guardarProducto(producto);		
		return "redirect:/productos/";
	}
	
	@RequestMapping(value="/nuevo2", method=RequestMethod.POST)
	public String obtenerAtributos(@ModelAttribute("producto") Producto producto, BindingResult br, Model model){	
		producto.setAtributos(productosDAO.obtenerAtributos(producto.getID_Grupo()));	
		model.addAttribute("producto", producto);
		model.addAttribute("atributo", new Atributo());
		model.addAttribute("grupos", productosDAO.obtenerGrupos());
		model.addAttribute("proveedores", personasDAO.obtenerProveedores());
		model.addAttribute("accion","nuevo");
		return "nuevo-producto";
	}
	 
	@RequestMapping(value="/editar", method=RequestMethod.GET)
	public String editarProducto(@RequestParam(value="idproducto", required=true) long idproducto, Model model){
		Producto p = productosDAO.obtenerProducto(idproducto);
		model.addAttribute("producto", p);
		model.addAttribute("grupos", productosDAO.obtenerGrupos());
		model.addAttribute("proveedores", personasDAO.obtenerProveedores());
		model.addAttribute("accion","editar");
		return "editar-producto";
	}
	
	@RequestMapping(value="/editar", method=RequestMethod.POST)
	public String editarProducto(@Valid Producto producto, BindingResult br){
		if(br.hasErrors()){
			return "editar-producto";
		}		
		productosDAO.editarProducto(producto);		
		return "redirect:/productos/";
	}
	
	@RequestMapping(value="/borrar", method=RequestMethod.GET)
	public String borrarProducto(@RequestParam("idproducto") String idproducto, Model model){
		productosDAO.borrarProducto(idproducto);		
		return "redirect:/productos/";
	}
	
	@RequestMapping(value="/agregarAtributo", method=RequestMethod.POST)
	public String agregarAtributo(Model model, @Valid AtributoProducto atributo) {
		Producto p = (Producto) model.asMap().get("producto");
		//p.getAtributos().add(atributo);
		return "nuevo-producto";
	}
}
