package dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.junit.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import syscom.dao.OperacionesDAO;
import syscom.dao.OperacionesDAOImpl;
import syscom.domain.DetalleDoc;
import syscom.domain.Documento;


public class OperacionesDAOTest {	
	ApplicationContext context = new ClassPathXmlApplicationContext("classpath:sistemapos-servlet.xml");
	EntityManagerFactory emf = (EntityManagerFactory) context.getBean("emf");
	OperacionesDAO operacionesDAO = (OperacionesDAO) context.getBean("operacionesDAO");
	 
	@Test  
	public void testObtenerClientes(){
//		em.getTransaction().begin();
//		em.createNativeQuery("delete from documentos").executeUpdate();
//		em.createNativeQuery("delete from detalledocumentos").executeUpdate();
//		em.getTransaction().commit();
		
		Documento documento = new Documento();
		ArrayList<DetalleDoc> detalles = new ArrayList<DetalleDoc>();
		operacionesDAO.guardarDocumento(documento);
		DetalleDoc detalle1 = new DetalleDoc();
		DetalleDoc detalle2 = new DetalleDoc();
		DetalleDoc detalle3 = new DetalleDoc();
		detalles.add(detalle1);
		detalles.add(detalle2);
		detalles.add(detalle3);
		documento.setDetalle(detalles);
		
	}

}
