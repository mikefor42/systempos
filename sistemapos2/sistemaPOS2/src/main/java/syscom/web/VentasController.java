package syscom.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import syscom.dao.OperacionesDAO;
import syscom.dao.OperacionesDAOImpl;
import syscom.dao.PersonasDAO;
import syscom.dao.PersonasDAOImpl;
import syscom.dao.ProductosDAO;
import syscom.dao.ProductosDAOImpl;
import syscom.domain.Abono;
import syscom.domain.Cuenta;
import syscom.domain.DetalleDoc;
import syscom.domain.Documento;
import syscom.domain.Producto;

@Controller
@RequestMapping("/ventas")
@SessionAttributes({"productos","detalleList","clientes", "documento","detalleDoc"})
public class VentasController {
	PersonasDAO personasDAO = new PersonasDAOImpl();
	ProductosDAO productosDAO = new ProductosDAOImpl();
	OperacionesDAO operacionesDAO = new OperacionesDAOImpl();
	
	@RequestMapping(method=RequestMethod.GET)
	String pantallaVentas(Model model, HttpServletRequest request, HttpServletResponse response) {
		model.addAttribute("detalleList", new ArrayList<DetalleDoc>());
		model.addAttribute("clientes", personasDAO.obtenerClientes());
		model.addAttribute("productos", productosDAO.obtenerProductos());		
		model.addAttribute("documento", new Documento());				
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
	
	
	@RequestMapping(value="/obtenerProducto", method=RequestMethod.GET)
	@ResponseBody
	void obtenerProducto(@RequestParam("idProducto") String id, HttpServletRequest request, HttpServletResponse response) throws IOException{
		Producto p = productosDAO.obtenerProducto(id);
		request.getSession().setAttribute("productoSeleccionado", p);
		response.getWriter().write(p.getDescripcion() +"|"+ p.getPrecioVenta());
		
	}
	   
	@RequestMapping("/quitar")
	String quitarProducto(Model model, @RequestParam("id") int id, HttpServletRequest request, HttpServletResponse response) {
		List<DetalleDoc> l = (List) request.getSession().getAttribute("detalleList");
		DetalleDoc d = l.get(id);
		l.remove(d);		
		model.addAttribute("detalleDoc", new DetalleDoc());		
		return "ventas-form";
	}
	
	@RequestMapping(value="/documento", method=RequestMethod.POST)
	String guardarDocumento(@Valid Documento documento, BindingResult br2, Model model) {
		documento.setDetalle((List) model.asMap().get("detalleList"));
		operacionesDAO.guardarDocumento(documento);
		model.addAttribute("mensaje", "El documento se ha guardado de forma exitosa");
		return "ventas-form";
	}
	
	@RequestMapping(value="/cxc", method=RequestMethod.GET)
	String cuentasxcobrar(Model model) {
		List<Cuenta> l = operacionesDAO.obtenerCuentasxCobrar();
		model.addAttribute(l);	
		return "cuentas-x-cobrar";
	}
	
	@RequestMapping(value="/cxc", method=RequestMethod.POST)
	String abonarcxc(Model model, @Valid Abono abono) {
		operacionesDAO.abonarCuentaxCobrar(abono);
		return "cuentas-x-cobrar";
	}
}
