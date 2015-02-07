package dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import syscom.dao.PersonasDAO;
import syscom.dao.PersonasDAOImpl;
import syscom.domain.Persona;

import org.junit.*;


public class personasDAOTest {
	PersonasDAO personasDAO = new PersonasDAOImpl();
	EntityManager em = Persistence.createEntityManagerFactory("punit").createEntityManager();
	
	@Test
	public void testObtenerClientes() {		
		em.getTransaction().begin();
		em.createNativeQuery("delete from personas").executeUpdate();
		em.persist(new Persona());
		em.persist(new Persona());
		em.persist(new Persona());
		em.getTransaction().commit();
		
		Assert.assertEquals(3, personasDAO.obtenerClientes(1));
	}
}
