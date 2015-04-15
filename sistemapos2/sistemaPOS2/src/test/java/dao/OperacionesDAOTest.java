package dao;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStreamImpl;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

import org.junit.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import syscom.dao.OperacionesDAO;
import syscom.dao.ProductosDAO;
import syscom.dao.PruebaJasper;
import syscom.domain.DetalleDoc;
import syscom.domain.Documento;
import syscom.domain.Persona;
import syscom.domain.Producto;
import syscom.web.VentasController;


public class OperacionesDAOTest {	
	ApplicationContext context = new ClassPathXmlApplicationContext("classpath:sistemapos-servlet.xml");
	EntityManagerFactory emf = (EntityManagerFactory) context.getBean("emf");
	OperacionesDAO operacionesDAO = (OperacionesDAO) context.getBean("operacionesDAO");
	ProductosDAO productosDAO = (ProductosDAO) context.getBean("productosDAO");
//	 
//	@Test  
//	public void guardarDocumento(){
////		em.getTransaction().begin();
////		em.createNativeQuery("delete from documentos").executeUpdate();
////		em.createNativeQuery("delete from detalledocumentos").executeUpdate();
////		em.getTransaction().commit();
//		
//		Documento documento = new Documento();
//		documento.setNumDocumento("1111");
//		ArrayList<DetalleDoc> detalles = new ArrayList<DetalleDoc>();		
//		DetalleDoc detalle1 = new DetalleDoc();		
//		DetalleDoc detalle2 = new DetalleDoc();
//		DetalleDoc detalle3 = new DetalleDoc();
//		detalles.add(detalle1);
//		detalles.add(detalle2);
//		detalles.add(detalle3);
//		//documento.setDetalleList(detalles);
//		operacionesDAO.guardarDocumento(documento, detalles);		
//	}
	
//	@Test 
//	public void autocompleteProductos() {
//		List<Producto> p = productosDAO.obtenerProductos("ewr");
//		Assert.assertEquals(1, p.size());
//	}
//	
	
//	@Test
//	public void obtenerNumeroDeFactura() {		
//		Assert.assertEquals(8123, operacionesDAO.obtenerNumeroDocumento());
//	}
//	
//	@Test
//	public void obtenerImagen() throws IOException {
//
//		
//	}
//	 
//
//	@Test
//	public void testControllerReportes() throws FileNotFoundException, JRException {
//		
//		HashMap<String, Object> parameters = new HashMap();
//		parameters.put("fecha",new Date().toLocaleString());
//		parameters.put("nro_factura","0001");
//		parameters.put("empresa_nombre","La ZAPATERIA");
//		parameters.put("empresa_rfc","LZA101208HGT");
//		parameters.put("empresa_direccion","Juarez 20 Col. Centro");
//		parameters.put("empresa_telefonos","775345654");
//		parameters.put("ciudad_empresa","Tulancingo Hidalgo");
//		parameters.put("empresa_email","lazapateria@hotmail.com");
//		parameters.put("fecha_factura",new Date().toLocaleString());
//		parameters.put("rfc","HEMM93029GGR");
//		parameters.put("telefono","775345566");
//		parameters.put("direccion","Centro Tulancingo");
//		parameters.put("ciudad","Tulancingo Hidalgo");
//		parameters.put("cliente","Miguel Angel Hernandez y Algo");
//		parameters.put("valor_total_sum","2000.00");
//		parameters.put("iva_sum","230.00");
//		parameters.put("TOTAL","2230.00");
//
//		
//		Producto producto1 = new Producto();
//		Producto producto2 = new Producto();
//		Producto producto3 = new Producto();
//		
//		DetalleDoc detalle1 = new DetalleDoc();
//		detalle1.setProductoSeleccionado(producto1);
//		DetalleDoc detalle2 = new DetalleDoc();
//		detalle2.setProductoSeleccionado(producto2);
//		DetalleDoc detalle3 = new DetalleDoc();
//		detalle3.setProductoSeleccionado(producto3);
//		List<DetalleDoc> detalle = new ArrayList<DetalleDoc>();
//		detalle.add(detalle1);
//		detalle.add(detalle2);
//		detalle.add(detalle3);
//
//	
//		
//		InputStream reportStream = new FileInputStream( "C:/Users/Syscom020/Documents/documentoVentas.jasper");
//		JRDataSource dataSource = new JRBeanCollectionDataSource(detalle, true);
//		JasperPrint print = JasperFillManager.fillReport(reportStream, parameters, dataSource);
//		String fileName = "UserReport.pdf";
//		JasperViewer.viewReport(print, true);
//		System.out.println("OK");
//	}
	
	@Test
	public void testObtenerDocumentos() {
		Assert.assertTrue(operacionesDAO.obtenerDocumentos().size() > 1);
	}
	
}
