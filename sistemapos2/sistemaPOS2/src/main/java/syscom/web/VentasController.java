package syscom.web;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.mockito.Mockito;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import syscom.dao.PersonasDAO;
import syscom.dao.PersonasDAOImpl;
import syscom.dao.ProductosDAO;
import syscom.dao.ProductosDAOImpl;
import syscom.domain.DetalleDoc;
import syscom.domain.Documento;
import syscom.domain.Producto;

@Controller
@RequestMapping("/ventas")
public class VentasController {
	PersonasDAO personasDAO = new PersonasDAOImpl();
	ProductosDAO productosDAO = new ProductosDAOImpl();
	
	@RequestMapping(method=RequestMethod.GET)
	String pantallaVentas(Model model, HttpServletRequest request, HttpServletResponse response) {
		
		request.getSession().setAttribute("detalleList", new ArrayList<DetalleDoc>());

		model.addAttribute("clientes", personasDAO.obtenerClientes());
		model.addAttribute("productos", productosDAO.obtenerProductos());
		
		Documento d = new Documento(); 
		model.addAttribute("documento", d);
				
		model.addAttribute("detalleDoc", new DetalleDoc());
		return "ventas-form";
	}
	
	@RequestMapping("/agregar")
	String agregarProducto(@Valid DetalleDoc detalleDoc, BindingResult br1, HttpServletRequest request, HttpServletResponse response, Model model) {
		Producto producto = (Producto) request.getSession().getAttribute("productoSeleccionado");		
		detalleDoc.setProductoSeleccionado(producto);
		List<DetalleDoc> detalleList = (List<DetalleDoc>) request.getSession().getAttribute("detalleList"); 
		detalleList.add(detalleDoc);
		model.addAttribute("detalleList", detalleList);
		
//		for(DetalleDoc d : (List<DetalleDoc>)request.getSession().getAttribute("detalle")) {
//			System.out.println(d.getCantidad());
//		}
		return "ventas-form";
	}
	
	@RequestMapping("/guardar")
	String guardarDocumento(@Valid Documento detalleDoc, BindingResult br2, Model model) {
		System.out.println("guardar");
		return "ventas-form";
	}
	
	@RequestMapping(value="/obtenerProducto", method=RequestMethod.GET)
	@ResponseBody
	void obtenerProducto(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String id = request.getParameter("id");
		Producto p = productosDAO.obtenerProducto(id);
		request.getSession().setAttribute("productoSeleccionado", p);
		response.getWriter().write(p.getDescripcion() +"|"+ p.getPrecioVenta());		
	}
	
	@RequestMapping("/quitar")
	String quitarProducto(Model model, @RequestParam("id") String id, HttpServletRequest request, HttpServletResponse response) {
		List<DetalleDoc> l = (List) request.getSession().getAttribute("detalleList");
		DetalleDoc d = null;
		for(DetalleDoc dc : l){
			if(dc.getIDProducto() == Long.parseLong(id));
			d = dc;
		}
		l.remove(d);
		model.addAttribute("detalleDoc", new DetalleDoc());
		return "ventas-form";
	}
}
