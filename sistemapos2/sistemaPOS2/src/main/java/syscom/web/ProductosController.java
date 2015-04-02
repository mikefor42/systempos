package syscom.web;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import syscom.dao.PersonasDAO;
import syscom.dao.ProductosDAO;
import syscom.domain.Atributo;
import syscom.domain.AtributoProducto;
import syscom.domain.Par;
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
		model.addAttribute("producto", p);
		model.addAttribute("atributo", new Atributo());
		model.addAttribute("grupos", productosDAO.obtenerGrupos());
		model.addAttribute("proveedores", personasDAO.obtenerProveedores());
		model.addAttribute("accion","nuevo");
		
		model.addAttribute("gruposList", productosDAO.obtenerGrupos());
		model.addAttribute("atributoForm", new Par());
		model.addAttribute("atributosList", productosDAO.obtenerAllAtributos());
		
		model.addAttribute("grupoForm", new Par());
		model.addAttribute("gruposList", productosDAO.obtenerGrupos());
		return "nuevo-producto";
	}
	
	@RequestMapping(value="/nuevo", method=RequestMethod.POST)
	public String guardarProducto(@ModelAttribute("producto") @Valid Producto producto, BindingResult br, Model model) throws Exception{
		if(br.hasErrors()){
			for(ObjectError i : br.getAllErrors()) {
				System.out.println(i.getDefaultMessage());
			}
			return "nuevo-producto";
		}		
		producto.setID(0);
		long id = productosDAO.guardarProducto(producto);
		String imagen = guardarImagen(producto.getImageFile(), id);
		producto.setImagen(imagen);
		productosDAO.editarProducto(producto);
		return "redirect:/productos/";
	}
	
	private String guardarImagen(MultipartFile imagen, long id) throws IOException {	
		String path = "c://imagenes/productos"+ id + "_producto.jpg";
		File file = new File(path);
		FileUtils.writeByteArrayToFile(file, imagen.getBytes());
		return id + "_producto.jpg";
	}

	@RequestMapping(value="/nuevo2", method=RequestMethod.POST)
	public String obtenerAtributos(@ModelAttribute("producto") Producto producto, BindingResult br, Model model){	
		producto.setAtributos(productosDAO.obtenerAtributos(producto.getID_Grupo()));	
		model.addAttribute("producto", producto);
		model.addAttribute("atributo", new Atributo());
		model.addAttribute("grupos", productosDAO.obtenerGrupos());
		model.addAttribute("proveedores", personasDAO.obtenerProveedores());
		model.addAttribute("accion","nuevo");
		
		model.addAttribute("gruposList", productosDAO.obtenerGrupos());
		model.addAttribute("atributoForm", new Par());
		model.addAttribute("atributosList", productosDAO.obtenerAllAtributos());
		
		model.addAttribute("grupoForm", new Par());
		model.addAttribute("gruposList", productosDAO.obtenerGrupos());
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
	
	@RequestMapping(value="/atributos", method=RequestMethod.GET)
	public String atributos(Model model) {
		model.addAttribute("gruposList", productosDAO.obtenerGrupos());
		model.addAttribute("atributo", new Par());
		model.addAttribute("atributosList", productosDAO.obtenerAllAtributos());
		return "atributos";
	}
	
	@RequestMapping(value="/grupos", method=RequestMethod.GET)
	public String grupos(Model model) {		
		model.addAttribute("grupo", new Par());
		model.addAttribute("gruposList", productosDAO.obtenerGrupos());
		return "grupos";
	}
	
	@RequestMapping(value="/nuevoAtributo", method=RequestMethod.POST)
	public String nuevoAtributo(Model model, @Valid Par atributo, BindingResult br){
		productosDAO.guardarAtributo(atributo);	
		return "redirect:/productos/nuevo";
	}
	
	@RequestMapping(value="/nuevoGrupo", method=RequestMethod.POST)
	public String nuevoGrupo(Model model, @Valid Par grupo, BindingResult br){
		productosDAO.guardarGrupo(grupo);	
		return "redirect:/productos/nuevo";
	}
	
	


}
