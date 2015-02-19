package syscom.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import syscom.domain.Abono;
import syscom.domain.Cuenta;
import syscom.domain.Documento;
import syscom.domain.Producto;

@Component
@Repository("operacionesDAO") 
@Transactional
public class OperacionesDAOImpl implements OperacionesDAO {

	@PersistenceContext
	EntityManager em;
	
	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	
	
	public EntityManager getEm() {
		return em;
	}



	public void guardarDocumento(Documento documento) {
		em.persist(documento);		
	}

	public List<Producto> obtenerProductos() {
		List l = new ArrayList<Producto>();
		Producto p = new Producto();
		p.setDescripcion("Un producto");
		l.add(p);
		p = new Producto();
		p.setDescripcion("Otro  producto");
		l.add(p);
		p = new Producto();
		p.setDescripcion("Y otro producto");
		l.add(p);		
		return l;
	}

	public void actualizarInventario(Producto p) {
		// TODO Auto-generated method stub
		
	}

	public void abonarCuentaxCobrar(Abono abono) {
		// TODO Auto-generated method stub
		
	}

	public List<Cuenta> obtenerCuentasxPagar() {
		// TODO Auto-generated method stub
		return null;
	}

	public void abonarCuentaxPagar(Abono abono) {
		// TODO Auto-generated method stub
		
	}

	public List<Cuenta> obtenerCuentasxCobrar() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
