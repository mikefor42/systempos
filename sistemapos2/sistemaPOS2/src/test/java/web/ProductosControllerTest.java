package web;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import syscom.dao.ProductosDAO;
import syscom.domain.Atributo;
import syscom.domain.Producto;
import syscom.web.ProductosController;

public class ProductosControllerTest {
	static ApplicationContext context = new ClassPathXmlApplicationContext("classpath:sistemapos-servlet.xml");
	static EntityManagerFactory emf = (EntityManagerFactory) context.getBean("emf");
	static EntityManager em = emf.createEntityManager();
	ProductosDAO productosDAO = (ProductosDAO) context.getBean("productosDAO");
	ProductosController productosController = (ProductosController) context.getBean("productosController");
	
//	@Test
//	@Ignore
//	public void testControllerMostrarProductos() {
//		Model model = new ExtendedModelMap();
//		productosController.listarProductos(model);
//		Assert.assertNotNull(model.asMap().get("productosList"));
//	}
//	
//	
//	@Test
//	@Ignore
//	public void testIrANuevoProducto() {
//		Model model = new ExtendedModelMap();
//		productosController.nuevoProducto(model);
//		Assert.assertNotNull(model.asMap().get("producto"));				
//		Assert.assertNotNull(model.asMap().get("proveedores"));		
//		Assert.assertNotNull(model.asMap().get("atributo"));
//		Assert.assertNotNull(model.asMap().get("grupos"));
//	}
//	
	@Test
	public void testObtenerAtributos() {
		Model model = new ExtendedModelMap();
		Producto p = new Producto();
		p.setAtributos(new ArrayList<Atributo>());
		p.setID_Grupo(1);
		productosController.obtenerAtributos(p, null, model);
		Assert.assertEquals(2, ((Producto)model.asMap().get("producto")).getAtributos().size());
	}

}
