package dao;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStreamImpl;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.junit.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import syscom.dao.OperacionesDAO;
import syscom.dao.ProductosDAO;
import syscom.domain.DetalleDoc;
import syscom.domain.Documento;
import syscom.domain.Producto;


public class OperacionesDAOTest {	
	ApplicationContext context = new ClassPathXmlApplicationContext("classpath:sistemapos-servlet.xml");
	EntityManagerFactory emf = (EntityManagerFactory) context.getBean("emf");
	OperacionesDAO operacionesDAO = (OperacionesDAO) context.getBean("operacionesDAO");
	ProductosDAO productosDAO = (ProductosDAO) context.getBean("productosDAO");
	 
	@Test  
	public void guardarDocumento(){
//		em.getTransaction().begin();
//		em.createNativeQuery("delete from documentos").executeUpdate();
//		em.createNativeQuery("delete from detalledocumentos").executeUpdate();
//		em.getTransaction().commit();
		
		Documento documento = new Documento();
		documento.setNumDocumento("1111");
		ArrayList<DetalleDoc> detalles = new ArrayList<DetalleDoc>();		
		DetalleDoc detalle1 = new DetalleDoc();		
		DetalleDoc detalle2 = new DetalleDoc();
		DetalleDoc detalle3 = new DetalleDoc();
		detalles.add(detalle1);
		detalles.add(detalle2);
		detalles.add(detalle3);
		//documento.setDetalleList(detalles);
		operacionesDAO.guardarDocumento(documento, detalles);		
	}
	
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

}
