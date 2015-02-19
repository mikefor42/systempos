package syscom.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import syscom.domain.Par;
import syscom.domain.Permiso;
import syscom.domain.Persona;

@Component
@Repository("personasDAO") 
@Transactional
public class PersonasDAOImpl implements PersonasDAO {
	
	private static final String OBTENER_TODOS = "select * from personas  where tipo = :tipo";

	@PersistenceContext	
	private EntityManager em;
	
	public void setEm(EntityManager em) {
		this.em = em;
	}

	public List<Persona> obtenerPersonas(int opcion) {
		Query query = em.createNativeQuery(OBTENER_TODOS, Persona.class);
		query.setParameter("tipo", opcion);
		return query.getResultList();
	}

	public void guardarPersona(Persona persona) {		
		em.persist(persona);	
	}

	public Persona obtenerPersona(long id) {
		return em.find(Persona.class, id);
	}

	public void editarPersona(Persona persona) {
		Persona c = em.find(Persona.class, persona.getID());		
		c.setNombre(persona.getNombre());
		c.setApellido(persona.getApellido());
		c.setPais(persona.getPais());
		c.setEstado(persona.getEstado());
		c.setMunicipio(persona.getMunicipio());
		c.setDireccion(persona.getDireccion());
		c.setTelefonoFijo(persona.getTelefonoFijo());
		c.setTelefonoCelular(persona.getTelefonoCelular());
		c.setRfc(persona.getRfc());
		c.setEmail(persona.getEmail());
		c.setImagen(persona.getImagen());
		c.setUsuario(persona.getUsuario());
	    c.setFecha_nac(persona.getFecha_nac());	    
	}

	public void borrarPersona(long id) {
		Persona c = em.find(Persona.class, id);	
		em.remove(c);
	}
	
	public void borrarPersonal(long idpersonal) {
		borrarPersona(idpersonal);
	}

	public void editarPersonal(Persona personal) {
		editarPersona(personal);		
	}

	public List<Persona> obtenerPersonalList() {
		return obtenerPersonas(Persona.EMPLEADO);
	}

	public void guardarPersonal(Persona personal) {
		personal.setTipo(Persona.EMPLEADO);
		guardarPersona(personal);
	}

	public List<Persona> obtenerProveedores() {
		return obtenerPersonas(Persona.PROVEEDOR);	
	}

	public void guardarProveedor(Persona proveedor) {
		proveedor.setTipo(Persona.PROVEEDOR);
		guardarPersona(proveedor);		
	}

	public Persona obtenerProveedor(long idproveedor) {
		return obtenerPersona(idproveedor);
	}

	public void editarProveedor(Persona proveedor) {
		editarPersona(proveedor);
	}

	public void borrarProveedor(long idproveedor) {
		borrarPersona(idproveedor);
	}

	public Persona obtenerPersonal(long idpersonal) {		
		return obtenerPersona(idpersonal);
	}

	public List<Permiso> obtenerPermisosPersonal(long id) {
		List<Permiso> l = new ArrayList<Permiso>();
		l.add(new Permiso());
		l.add(new Permiso());
		l.add(new Permiso());
		l.add(new Permiso());
		l.add(new Permiso());
		return l;
	}

	public void agregarModulo(long idPersona, long idModulo) {
		// TODO Auto-generated method stub
		
	}

	public Map<Long, String> obtenerModulos() {
		Map map = new HashMap<Long, String>();
		map.put(1, "Modulo1");
		map.put(2, "Modulo2");
		map.put(3, "Modulo3");
		map.put(4, "Modulo4");
		map.put(5, "Modulo5");
		return map;
	}

	public List<Persona> obtenerClientes() {
		return obtenerPersonas(Persona.CLIENTE);
	}

	public void guardarCliente(Persona cliente) {
		cliente.setTipo(Persona.CLIENTE);
		guardarPersona(cliente);		
	}

	public Persona obtenerCliente(long idCliente) {		
		return obtenerPersona(idCliente);
	}

	public void editarCliente(Persona cliente) {
		editarPersona(cliente);		
	}

	public void borrarCliente(long idCliente) {
		borrarPersona(idCliente);		
	}
	
	private List<Par> obtenerPar(int id, String cadena, String parameter) {	
		List<Par> l = new ArrayList<Par>();
		Query query = em.createNativeQuery(cadena);
		if(parameter != null) query.setParameter(parameter, id);
		for (Iterator iterator = query.getResultList().iterator(); iterator.hasNext();) {
			Object[] type = (Object[]) iterator.next();
			l.add(new Par((Integer)type[0], (String)type[1]));
		}		
		return l;
	}

	public List<Par> obtenerMunicipios(int estado) {
		return obtenerPar(estado, "select idmunicipio, municipio from municipio where estado_idestado = :estado", "estado");
	}

	public List<Par> obtenerEstados() {		
		return obtenerPar(0, "select * from estado", null);
	}
}
