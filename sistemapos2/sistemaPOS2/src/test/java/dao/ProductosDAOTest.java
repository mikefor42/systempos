package dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.core.Context;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import syscom.dao.ProductosDAO;
import syscom.domain.Atributo;
import syscom.domain.Producto;
import syscom.web.VentasController;

//@ContextConfiguration(locations="classpath:sistemapos-servlet.xml")
//@RunWith(SpringJUnit4ClassRunner.class)
public class ProductosDAOTest {		
	ApplicationContext context = new ClassPathXmlApplicationContext("classpath:sistemapos-servlet.xml");
	EntityManagerFactory emf = (EntityManagerFactory) context.getBean("emf");
	EntityManager em = emf.createEntityManager();
	ProductosDAO productosDAO = (ProductosDAO) context.getBean("productosDAO");
	VentasController ventasController = (VentasController) context.getBean("ventasController");
	
	@Test
	@Ignore
	public void testGuardarYObtenerProductos(){
		Producto p = new Producto();
		Atributo a = new Atributo();
		a.setID(3);
		Atributo b = new Atributo();
		b.setID(3);
		Atributo c = new Atributo();
		c.setID(3);
		List as = new ArrayList<Atributo>();
		as.add(a);
		as.add(b);
		as.add(c);
		p.setAtributos(as);
		productosDAO.guardarProducto(p);

		//List<Producto> l = productosDAO.obtenerProductos();
		//Assert.assertEquals(1, productosDAO.obtenerProductos().size());
		System.out.println(productosDAO.obtenerProductos().get(0).getAtributos().getClass());
		Assert.assertEquals(3,productosDAO.obtenerProductos().get(0).getAtributos().size());
	}
	
	@Test 
	@Ignore
	public void testObtenerProductos() {
		for (Iterator iterator = productosDAO.obtenerProductos().iterator(); iterator.hasNext();) {
			Producto type = (Producto) iterator.next();
			System.out.println(type);
		} 
		
	}
	
	@Test 	
	@Ignore
	public void testObtenerProducto() {
		Producto p =productosDAO.obtenerProducto(61);
		Assert.assertNotNull(p);
	}
	
}
