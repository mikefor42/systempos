package dao;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import syscom.dao.PersonasDAO;
import syscom.domain.Persona;
import syscom.web.ClientesController;


public class personasDAOTest {
	ApplicationContext context = new ClassPathXmlApplicationContext("classpath:sistemapos-servlet.xml");
	EntityManagerFactory emf = (EntityManagerFactory) context.getBean("emf");
	EntityManager em = emf.createEntityManager();
	PersonasDAO personasDAO = (PersonasDAO) context.getBean("personasDAO");
	
//	@Before
//	@Ignore
//	public void setUp() {
//		em.getTransaction().begin();
//		em.createNativeQuery("delete from personas").executeUpdate();
//		em.getTransaction().commit();
//	}
	
//	@After
//	@Ignore
//	public void end() {
//		em.getTransaction().begin();
//		em.createNativeQuery("delete from personas").executeUpdate();
//		em.getTransaction().commit();
//	}
//
//	
//	
	@Test
	public void testObtenerClientes() {		
		Persona p = new Persona();
		p.setNombre("alquien");
		p.setApellido("un apellido");
		personasDAO.guardarCliente(p);		

//		personasDAO.guardarCliente(new Persona());
//		personasDAO.guardarCliente(new Persona());
//		Assert.assertEquals(3, personasDAO.obtenerClientes().size());
	}
//	
//	@Test
//	@Ignore
//	public void testUpdateCliente() {
//		Persona persona = new Persona();
//		persona.setApellido("Un apellido");
//		persona.setID(1000);
//		personasDAO.guardarCliente(persona);
//
//		Persona persona2 = personasDAO.obtenerCliente(1000);
//		persona2.setApellido("Otro apellido");
//		personasDAO.editarCliente(persona2);
//		
//		Persona persona3 = personasDAO.obtenerCliente(1000);				
//		Assert.assertEquals("Otro apellido", persona3.getApellido());
//	}
//	
//	@Test
//	@Ignore
//	public void testBorrarCliente() {
//		Persona persona = new Persona();
//		persona.setID(1000);
//		personasDAO.guardarCliente(persona);
//		Assert.assertEquals(1, personasDAO.obtenerClientes().size());
//		
//		
//		Persona persona2 = personasDAO.obtenerCliente(1000);
//		personasDAO.borrarCliente(persona2.getID());
//		Assert.assertEquals(0, personasDAO.obtenerClientes().size());
//	}
//	
//	@Test
//	@Ignore
//	public void testSoloClientes() {
//		Persona persona1 = new Persona();
//		Persona persona2 = new Persona();
//		Persona persona3 = new Persona();
//		personasDAO.guardarCliente(persona1);
//		personasDAO.guardarPersonal(persona2);
//		personasDAO.guardarProveedor(persona3);
//		Assert.assertEquals(1, personasDAO.obtenerClientes().size());
//		Assert.assertEquals(1, personasDAO.obtenerProveedores().size());
//		Assert.assertEquals(1, personasDAO.obtenerPersonalList().size());	
//	}
//	
//	@Test
//	@Ignore
//	public void testConsultaClientes() {
//		Persona p = new Persona();
//		p.setTipo(1);
//		personasDAO.guardarCliente(new Persona());
//		
//		List<Persona> l = personasDAO.obtenerClientes();
//		System.out.println("Tamaño:" + l.size());
//		try {
//			System.out.println("La persona" + (Persona)l.get(1));
//		} catch (Exception e){
//			e.printStackTrace();
//		}
//		
//		System.out.println("OK");
//	}
//	
//	@Test
//	@Ignore
//	public void testUpdateProveedor() {
//		Persona persona = new Persona();
//		persona.setApellido("Un apellido");
//		persona.setID(1000);
//		personasDAO.guardarProveedor(persona);
//		Assert.assertEquals(1, personasDAO.obtenerProveedores().size());
//
//		Persona persona2 = personasDAO.obtenerProveedor(1000);
//		Assert.assertNotNull(persona2);
//		
//		persona2.setApellido("Otro apellido");
//		personasDAO.editarProveedor(persona2);
//		
//		Persona persona3 = personasDAO.obtenerProveedor(1000);				
//		Assert.assertEquals("Otro apellido", persona3.getApellido());
//	}
//	
//	@Test
//	public void testObtenerMunicipios() {
//		//Map m = personasDAO.obtenerLocalidades(1);
//	}
//	

}
