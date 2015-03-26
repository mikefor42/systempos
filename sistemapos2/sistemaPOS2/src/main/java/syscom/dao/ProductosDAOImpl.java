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

import syscom.domain.Atributo;
import syscom.domain.Par;
import syscom.domain.Producto;

@Component
@Repository("productosDAO")
public class ProductosDAOImpl implements ProductosDAO {

	@PersistenceContext(type=PersistenceContextType.TRANSACTION)
	EntityManager em;

	public List<Producto> obtenerProductos() {
		List<Producto> l = em.createNativeQuery("select * from productos", Producto.class).getResultList();
		long id = 0;
		for (Iterator iterator = l.iterator(); iterator.hasNext();) {
			Producto producto = (Producto) iterator.next();
			id = producto.getID();
			Query q = (Query) em.createNativeQuery("select a.atributos_id_atributos as id_atributos, b.descripcion, a.valor from productosatributos a, "
					+ "atributos b where a.productos_id_producto = :elid and a.atributos_id_atributos = b.ID_Atributos;", Atributo.class);
			q.setParameter("elid", producto.getID());
			List<Atributo> l2 = q.getResultList();			
			producto.setAtributos(l2);			
		}
		return l;		
	}

	@Transactional
	public void guardarProducto(Producto producto) {
		em.persist(producto);
		if(producto.getAtributos() == null) return;
		for (Iterator iterator = producto.getAtributos().iterator(); iterator.hasNext();) {
			Atributo type = (Atributo) iterator.next();
			Query q = em.createNativeQuery("insert into productosatributos (productos_id_producto, atributos_id_atributos, valor) values(:producto, :atributo, :valor)");
			q.setParameter("producto", producto.getID());
			q.setParameter("atributo", type.getID());
			q.setParameter("valor", type.getValor());
			q.executeUpdate();
		}
	}

	public Producto obtenerProducto(long idproducto) {		
		Producto producto = em.find(Producto.class, idproducto);
		Query q = (Query) em.createNativeQuery("select a.atributos_id_atributos as id_atributos, b.descripcion, a.valor from productosatributos a, "
				+ "atributos b where a.productos_id_producto = :elid and a.atributos_id_atributos = b.ID_Atributos;", Atributo.class);
		q.setParameter("elid", producto.getID());
		List<Atributo> l2 = q.getResultList();
		producto.setAtributos(l2);			
		return producto;
	}

	@Transactional
	public void editarProducto(Producto producto) {
		Producto p = em.find(Producto.class, producto.getID());
		p.setAlmacen(producto.getAlmacen());
		p.setAtributos(producto.getAtributos());
		p.setCantidadExistencia(producto.getCantidadExistencia());
		p.setCantidadMinima(producto.getCantidadMinima());
		p.setComentario(producto.getComentario());
		p.setDescripcion(producto.getDescripcion());
		p.setID(producto.getID());
		p.setID_Grupo(producto.getID_Grupo());
		p.setImagenProducto(producto.getImagenProducto());
		p.setPrecioCompra(producto.getPrecioCompra());
		p.setPrecioVenta(producto.getPrecioVenta());
		p.setId_proveedor(producto.getId_proveedor());
		Query q = em.createNativeQuery("delete from productosatributos where productos_id_producto = :elid");
		q.setParameter("elid", producto.getID());
		q.executeUpdate();		
		for (Iterator iterator = p.getAtributos().iterator(); iterator.hasNext();) {
			Atributo type = (Atributo) iterator.next();
			q = em.createNativeQuery("insert into productosatributos (productos_id_producto, atributos_id_atributos, valor) values(:producto, :atributo, :valor)");
			q.setParameter("producto", p.getID());
			q.setParameter("atributo", type.getID());
			q.setParameter("valor", type.getValor());
			q.executeUpdate();
		}		
	}

	@Transactional
	public void borrarProducto(String idproducto) {
		Query q = em.createNativeQuery("select * from productos where ID_Producto = :id", Producto.class);
		q.setParameter("id", idproducto);
		Producto producto = (Producto) q.getSingleResult();
		em.remove(producto);
		q = em.createNativeQuery("delete from productosatributos where productos_id_producto = :elid");
		q.setParameter("elid", producto.getID());
		q.executeUpdate();
	
	}

	public List<Par> obtenerGrupos() {
		
		Query q = (Query) em.createNativeQuery("select id_grupo, descripcion from grupos");
		List<Par> l = new ArrayList<Par>();
		for (Iterator iterator = q.getResultList().iterator(); iterator.hasNext();) {
			Object[] obj = (Object[]) iterator.next();
			l.add(new Par((Integer)obj[0], (String) obj[1]));
		}	
		return l;
	}

	public List<Atributo> obtenerAtributos(long id_Grupo) {
		Query q = (Query) em.createNativeQuery("select a.id_atributos,a.descripcion, null as valor from atributos a, grupos b where a.id_grupo = b.id_grupo and b.id_grupo = :elid", Atributo.class);
		q.setParameter("elid", id_Grupo);
		return q.getResultList();
	}

	public List obtenerProductos(String texto) {		
		Query q = (Query) em.createNativeQuery("select * from productos where descripcion like '%" + texto + "%' or ID_Producto = '" + texto + "'", Producto.class);
		List<Producto> l = q.getResultList(); 
		long id;
		
		for (Iterator iterator = l.iterator(); iterator.hasNext();) {
			Producto producto = (Producto) iterator.next();
			id = producto.getID();
			q = (Query) em.createNativeQuery("select a.atributos_id_atributos as id_atributos, b.descripcion, a.valor from productosatributos a, "
					+ "atributos b where a.productos_id_producto = :elid and a.atributos_id_atributos = b.ID_Atributos;", Atributo.class);
			q.setParameter("elid", producto.getID());
			List<Atributo> l2 = q.getResultList();			
			producto.setAtributos(l2);			
		}
		return l;		
	}

	@Transactional
	public void guardarAtributo(Par atributo) {
		Query query = em.createNativeQuery("insert into atributos (id_grupo, descripcion) values(:elid,:descripcion)");
		query.setParameter("elid", atributo.getClave());
		query.setParameter("descripcion", atributo.getDescripcion());	
		query.executeUpdate();
	}

	public List<Par> obtenerAllAtributos() {
		Query q = (Query) em.createNativeQuery("select id_grupo, descripcion from atributos");
		List<Par> l = new ArrayList<Par>();
		for (Iterator iterator = q.getResultList().iterator(); iterator.hasNext();) {
			Object[] obj = (Object[]) iterator.next();
			l.add(new Par((Integer)obj[0], (String) obj[1]));
		}	
		return l;
	}

	@Transactional
	public void guardarGrupo(Par grupo) {
		Query query = em.createNativeQuery("insert into grupos	 values(:elid,:descripcion)");
		query.setParameter("elid", grupo.getClave());
		query.setParameter("descripcion", grupo.getDescripcion());	
		query.executeUpdate();		
	}
}
	

