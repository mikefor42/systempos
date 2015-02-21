package dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
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


//@ContextConfiguration(locations="classpath:sistemapos-servlet.xml")
//@RunWith(SpringJUnit4ClassRunner.class)
public class ProductosDAOTest {		
	static ApplicationContext context = new ClassPathXmlApplicationContext("classpath:sistemapos-servlet.xml");
	static EntityManagerFactory emf = (EntityManagerFactory) context.getBean("emf");
	static EntityManager em = emf.createEntityManager();
	ProductosDAO productosDAO = (ProductosDAO) context.getBean("productosDAO");
	

//	@BeforeClass	
//	static public void setUp() {
//		em.getTransaction().begin();
//		em.createNativeQuery("delete from productos").executeUpdate();
//		Producto p = new Producto(); 		
//		em.persist(p);
//		em.createNativeQuery("delete from atributos").executeUpdate();
//		em.createNativeQuery("insert into atributos (ID_Atributos, descripcion, ID_Grupo) values (1, 'tamaño', 1)").executeUpdate();
//		em.createNativeQuery("insert into atributos (ID_Atributos, descripcion, ID_Grupo) values (2, 'color', 1)").executeUpdate();
//		em.createNativeQuery("insert into atributos (ID_Atributos, descripcion, ID_Grupo) values (3, 'talla', 2)").executeUpdate();
//		Query q = em.createNativeQuery("insert into productosatributos (productos_id_producto, atributos_id_atributos, valor) values (:elid, 1, 'Grande')");
//		q.setParameter("elid", p.getID());
//		q.executeUpdate();
//		q = em.createNativeQuery("insert into productosatributos (productos_id_producto, atributos_id_atributos, valor) values (:elid, 2, 'Azul')");
//		q.setParameter("elid", p.getID());
//		q.executeUpdate();
//		q = em.createNativeQuery("insert into productosatributos (productos_id_producto, atributos_id_atributos, valor) values (:elid, 2, 'Azul')");
//		q.setParameter("elid", p.getID());
//		q.executeUpdate();
//		em.getTransaction().commit();
//	}
//	
	
//	@Ignore
//	@AfterClass	
//	static public void end() {
//		em.getTransaction().begin();
//		em.createNativeQuery("delete from productos").executeUpdate();
//		em.createNativeQuery("delete from atributos").executeUpdate();
//		em.createNativeQuery("delete from productosatributos").executeUpdate();
//		em.getTransaction().commit();
//	}
	
	
//	@Test
//	@Ignore
//	public void testGuardarYObtenerProducto(){
//		Producto p = new Producto();
//		Atributo a = new Atributo();
//		a.setID(1);
//		Atributo b = new Atributo();
//		b.setID(2);
//		Atributo c = new Atributo();
//		c.setID(3);
//		List as = new ArrayList<Atributo>();
//		as.add(a);
//		as.add(b);
//		as.add(c);
//		p.setAtributos(as);
//		productosDAO.guardarProducto(p);
//
//		//List<Producto> l = productosDAO.obtenerProductos();
//		//Assert.assertEquals(1, productosDAO.obtenerProductos().size());
//		Assert.assertEquals(3,productosDAO.obtenerProducto(p.getID()).getAtributos().size());
//	}
//	
//	@Test 
//	@Ignore
//	public void testObtenerProductos() {
//		for (Iterator iterator = productosDAO.obtenerProductos().iterator(); iterator.hasNext();) {
//			Producto type = (Producto) iterator.next();
//			Assert.assertEquals(2, type.getAtributos().size());
//			System.out.println(type);
//		} 		
//	}
//	
//	@Test 	
//	@Ignore
//	public void testObtenerProducto() {
//		Producto p =productosDAO.obtenerProducto(24);		
//		Assert.assertNotNull(p);
//		Assert.assertEquals(2, p.getAtributos().size());
//	}
//	
//	@Test
//	public void testEditarNombreProducto() {
//		Producto p = productosDAO.obtenerProducto(31);
//		int r = new Random(1000).nextInt();
//		p.setDescripcion("prueba"+r);
//		productosDAO.editarProducto(p);
//		p = productosDAO.obtenerProducto(31);
//		Assert.assertEquals("prueba"+r, p.getDescripcion());
//	}
	
//	@Test
//	public void testEditarCantidadAtributosProducto() {
//		Producto p = productosDAO.obtenerProducto(34);
//		Assert.assertEquals(3, p.getAtributos().size());
//		p.getAtributos().remove(0);
//		productosDAO.editarProducto(p);
//		p = productosDAO.obtenerProducto(34);
//		Assert.assertEquals(2, p.getAtributos().size());
//	}
//	
//	@Test
//	@Ignore
//	public void testConsuta() {
//		Query q = (Query) em.createNativeQuery("select a.atributos_id_atributos as id_atributos, b.descripcion, a.valor from productosatributos a, "
//				+ "atributos b where a.productos_id_producto = :elid and a.atributos_id_atributos = b.ID_Atributos;", Atributo.class);
//		q.setParameter("elid",18);
//		List l2 = q.getResultList();
//	}
	
	
	@Test
	@Ignore
	public void testObtenerAtributosPorGrupo(){
		Assert.assertNotNull(productosDAO.obtenerAtributos(1));
		Assert.assertEquals(2, productosDAO.obtenerAtributos(1));
		Assert.assertEquals(1, productosDAO.obtenerAtributos(2));
	}

	
}
