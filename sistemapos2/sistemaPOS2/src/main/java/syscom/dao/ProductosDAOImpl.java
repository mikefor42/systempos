package syscom.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import syscom.domain.Producto;

@Component
@Repository("productosDAO")
public class ProductosDAOImpl implements ProductosDAO {

	@PersistenceContext(type=PersistenceContextType.EXTENDED)
	EntityManager em;
	
	
	
	public List<Producto> obtenerProductos() {
		List<Producto> l = em.createNativeQuery("select * from productos", Producto.class).getResultList();
		long id = 0;
		for (Iterator iterator = l.iterator(); iterator.hasNext();) {
			Producto producto = (Producto) iterator.next();
			id = producto.getID();
			em.createNativeQuery("select * from atributos a join productosatributos b on a.id_atributos = b.Atributos_ID_Atributos where b.Productos_ID_Producto = 60");
		}
		
	}

	@Transactional
	public void guardarProducto(Producto producto) {
		em.persist(producto);		
	}

	public Producto obtenerProducto(long idproducto) {
		Query q = em.createNativeQuery("select * from productos where ID_Producto = :id", Producto.class);
		q.setParameter("id", idproducto);
		return (Producto) q.getSingleResult();
	}

	public void editarProducto(Producto producto) {
		// TODO Auto-generated method stub
		
	}

	public void borrarProducto(String idproducto) {
		// TODO Auto-generated method stub
		
	}
	
}
