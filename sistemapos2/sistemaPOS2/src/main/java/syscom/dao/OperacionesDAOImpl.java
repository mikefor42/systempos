package syscom.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import syscom.domain.Abono;
import syscom.domain.Cuenta;
import syscom.domain.DetalleDoc;
import syscom.domain.Documento;
import syscom.domain.Producto;

@Component
@Repository("operacionesDAO") 
public class OperacionesDAOImpl implements OperacionesDAO {

	@PersistenceContext
	EntityManager em;
	
	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	public EntityManager getEm() {
		return em;
	}

	@Transactional
	public void guardarDocumento(Documento documento, List<DetalleDoc> detalleList) {
		em.persist(documento);		
		for (Iterator iterator = detalleList.iterator(); iterator.hasNext();) {			
			DetalleDoc type = (DetalleDoc) iterator.next();
			type.setNumDocumento(documento.getNumDocumento());
			type.setID(0);
			em.persist(type);
			em.detach(type);
		}
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

	public String obtenerNumeroDocumento() {
		Query q = em.createNativeQuery("select case isnull(max(ID_Factura)) when 1  then 0001 else  max(ID_Factura)+1 end as algo from documentos");
		return q.getSingleResult().toString();
	}	
}
