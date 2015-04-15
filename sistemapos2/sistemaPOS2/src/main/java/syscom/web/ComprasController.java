package syscom.web;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import syscom.dao.OperacionesDAO;
import syscom.dao.PersonasDAO;
import syscom.dao.ProductosDAO;
import syscom.domain.Abono;
import syscom.domain.Cuenta;
import syscom.domain.DetalleDoc;
import syscom.domain.Documento;
import syscom.domain.Persona;
import syscom.domain.Producto;

@Controller
@RequestMapping("/compras")
@SessionAttributes({"productos","detalleList","proveedoresList", "documento","detalleDoc"})
public class ComprasController {
	@Autowired
	PersonasDAO personasDAO;
	@Autowired
	ProductosDAO productosDAO;
	@Autowired
	OperacionesDAO operacionesDAO;
	
	@RequestMapping(method=RequestMethod.GET)
	public String pantallaCompras(Model model, HttpServletRequest request, HttpServletResponse response) {
		model.addAttribute("detalleList", new ArrayList<DetalleDoc>());
		model.addAttribute("proveedoresList", personasDAO.obtenerProveedores());
		model.addAttribute("productos", productosDAO.obtenerProductos());	
		Documento d =  new Documento();
		d.setNumDocumento(operacionesDAO.obtenerNumeroDocumento());
		d.setDetalle(new DetalleDoc());
		model.addAttribute("documento",d);			
		return "compras-form";
	}  
	
	@RequestMapping("/agregar")
	public String agregarProducto(@Valid Documento documento, BindingResult br1, Model model) {	
		Producto producto = productosDAO.obtenerProducto(documento.getDetalle().getIDProducto());	
		DetalleDoc dd = documento.getDetalle();
		DetalleDoc dd2 = new DetalleDoc();
		dd2.setNumDocumento(dd.getNumDocumento());
		dd2.setCantidad(dd.getCantidad());
		dd2.setDescuento(dd.getDescuento());
		dd2.setDocumento(dd.getDocumento());
		dd2.setIDProducto(dd.getIDProducto());
		dd2.setIva(dd.getIva());
		dd2.setPrecio(dd.getPrecio());
		dd2.setProductoSeleccionado(dd.getProductoSeleccionado());
		dd2.setSubtotal(dd.getSubtotal());
		dd2.setTotal(dd.getTotal());
		dd2.setProductoSeleccionado(producto);
		dd2.setTotal(dd2.getCantidad() * dd2.getPrecio());
		((List) model.asMap().get("detalleList")).add(dd2); 
				
		float subtotal = 0;

		for (Iterator iterator = ((List) model.asMap().get("detalleList")).iterator(); iterator.hasNext();) {
			DetalleDoc detalleDoc2 = (DetalleDoc) iterator.next();
			subtotal += detalleDoc2.getTotal();
		}		
		documento.setSubtotal(subtotal);
		float iva = (float) (subtotal*(documento.getIva()/100));
		subtotal = subtotal - iva;
		float descuento = (float) (subtotal*(documento.getDescuento()/100));		
		documento.setTotal(subtotal - descuento);
		documento.setDetalle(new DetalleDoc());		
		model.addAttribute("documento", documento);
		return "compras-form";
	}
	
	
	@RequestMapping(value="/obtenerProducto", method=RequestMethod.GET)
	@ResponseBody
	public void obtenerProducto(@RequestParam("idProducto") long id, HttpServletRequest request, HttpServletResponse response) throws IOException{
		Producto p = productosDAO.obtenerProducto(id);
		request.getSession().setAttribute("productoSeleccionado", p);
		response.getWriter().write(p.getDescripcion() +"|"+ p.getPrecioVenta()); //TODO		
	}
	   
	@RequestMapping("/quitar")
	public String quitarProducto(Model model, @RequestParam("id") int id, HttpServletRequest request, HttpServletResponse response) {
		List<DetalleDoc> l = (List) request.getSession().getAttribute("detalleList");
		DetalleDoc d = l.get(id);
		l.remove(d);		
		model.addAttribute("detalleDoc", new DetalleDoc());		
		return "compras-form";
	}
	
	@RequestMapping(value="/documento", method=RequestMethod.POST)
	String guardarDocumento(@Valid Documento documento, BindingResult br, Model model) {
		if(br.hasErrors()){
			return "compras-form";
		}		
		
		documento.setDetalleList((List) model.asMap().get("detalleList"));
		documento.setTipo(Documento.FACTURA_COMPRA);
		//operacionesDAO.guardarDocumento(documento,(List) model.asMap().get("detalleList"));
		model.addAttribute("mensaje", "El documento se ha guardado de forma exitosa");
		model.addAttribute("opciones", true);
		return "compras-form";
	}
	
	@RequestMapping(value="/cxp", method=RequestMethod.GET)
	public String cuentasxpagar(Model model) {
		List<Cuenta> l = operacionesDAO.obtenerCuentasxPagar();
		model.addAttribute(l);	
		return "cuentas-x-cobrar";
	}
	
	@RequestMapping(value="/cxc", method=RequestMethod.POST)
	public String abonarcxp(Model model, @Valid Abono abono) {
		operacionesDAO.abonarCuentaxPagar(abono);
		return "cuentas-x-pagar";
	}
	
	@RequestMapping(value="/productos", method=RequestMethod.GET)
	@ResponseBody List obtenerProductos(@RequestParam("texto") String texto, Model model) {
		return productosDAO.obtenerProductos(texto);
	}	
	
	@RequestMapping(value="/imprimir", method=RequestMethod.GET)	
	public @ResponseBody void imprimir(Model model, HttpServletResponse response) throws IOException, JRException {
		List<DetalleDoc> l = (List<DetalleDoc>) model.asMap().get("detalleList");
		HashMap<String, Object> parameters = new HashMap();
		parameters.put("fecha",new Date().toLocaleString());
		parameters.put("nro_factura","0001");
		parameters.put("empresa_nombre","La ZAPATERIA");
		parameters.put("empresa_rfc","LZA101208HGT");
		parameters.put("empresa_direccion","Juarez 20 Col. Centro");
		parameters.put("empresa_telefonos","775345654");
		parameters.put("ciudad_empresa","Tulancingo Hidalgo");
		parameters.put("empresa_email","lazapateria@hotmail.com");
		parameters.put("fecha_factura",new Date().toLocaleString());
		parameters.put("rfc","HEMM93029GGR");
		parameters.put("telefono","775345566");
		parameters.put("direccion","Centro Tulancingo");
		parameters.put("ciudad","Tulancingo Hidalgo");
		parameters.put("cliente","Miguel Angel Hernandez y Algo");
		parameters.put("valor_total_sum","2000.00");
		parameters.put("iva_sum","230.00");
		parameters.put("TOTAL","2230.00");
		InputStream reportStream = new FileInputStream( "C:/Users/Syscom020/Documents/documentoVentas.jasper"); //TODO
		JRDataSource dataSource = new JRBeanCollectionDataSource(l, true);
		JasperPrint print = JasperFillManager.fillReport(reportStream, parameters, dataSource);
		response.setContentType("application/pdf");
		String fileName = "UserReport.pdf";
		response.setHeader("Content-Disposition", "inline; filename="+ fileName);
		OutputStream out = response.getOutputStream();
		JasperExportManager.exportReportToPdfStream(print, out);
		out.flush();
		out.close(); 		
	}
}
