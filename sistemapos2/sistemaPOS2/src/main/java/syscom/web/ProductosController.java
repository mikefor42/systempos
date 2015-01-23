package syscom.web;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import syscom.dao.ProductosDAO;
import syscom.domain.Atributo;
import syscom.domain.Producto;

@Controller
@RequestMapping("/productos")
public class ProductosController {
	@Autowired
	ProductosDAO dao;
	
	@RequestMapping(method=RequestMethod.GET)
	public String listarProductos(Model model){
		List<Producto> l = dao.obtenerProductos();
		Atributo a = l.get(1).getAtributos().remove(3);
		Set atributos = new HashSet<Atributo>();
		for(Producto p : l) {
			atributos.addAll(p.getAtributos());
		}		
		model.addAttribute("titulosList", atributos);
		model.addAttribute("productos",l);
		return "lista-productos";
	}
	
	@RequestMapping(value="/nuevo", method=RequestMethod.GET)
	public String nuevoProducto(Model model){
		Producto p = new Producto();
		model.addAttribute("producto", p);
		return "nuevo-producto";
	}
	
	@RequestMapping(value="/nuevo", method=RequestMethod.POST)
	public String guardarProducto(@Valid Producto producto, BindingResult br){
		if(br.hasErrors()){
			return "nuevo-producto";
		}		
		for(Atributo a : producto.getAtributos()){
			System.out.println(a);
		}
		
		dao.guardarProducto(producto);		
		return "redirect:/productos/";
	}
	
	@RequestMapping(value="/editar", method=RequestMethod.GET)
	public String editarProducto(@RequestParam(value="idproducto", required=true) String idproducto, Model model){
		Producto p = dao.obtenerProducto(idproducto);
		model.addAttribute("producto", p);
		return "editar-producto";
	}
	
	@RequestMapping(value="/editar", method=RequestMethod.POST)
	public String editarProducto(@Valid Producto producto, BindingResult br){
		if(br.hasErrors()){
			return "editar-producto";
		}		
		dao.editarProducto(producto);		
		return "redirect:/productos/";
	}
	
	@RequestMapping(value="/borrar", method=RequestMethod.GET)
	public String borrarProducto(@RequestParam("idproducto") String idproducto, Model model){
		dao.borrarProducto(idproducto);		
		return "redirect:/productos/";
	}
}
