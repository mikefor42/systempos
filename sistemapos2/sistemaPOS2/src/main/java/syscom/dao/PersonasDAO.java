package syscom.dao;

import java.util.List;
import java.util.Map;

import syscom.domain.Par;
import syscom.domain.Permiso;
import syscom.domain.Persona;


public interface PersonasDAO {
	public List<Persona> obtenerClientes();
	public void guardarCliente(Persona cliente);
	public Persona obtenerCliente(long idCliente);
	public void editarCliente(Persona cliente);
	public void borrarCliente(long idCliente);

	public List<Persona> obtenerProveedores();
	public void guardarProveedor(Persona proveedor);
	public Persona obtenerProveedor(long idproveedor);
	public void editarProveedor(Persona proveedor);
	public void borrarProveedor(long idproveedor);

	public List<Persona> obtenerPersonalList();
	public void guardarPersonal(Persona personal);
	public Persona obtenerPersonal(long idpersonal);
	public void editarPersonal(Persona personal);
	public void borrarPersonal(long idpersonal);
	public List<Permiso> obtenerPermisosPersonal(long id);

	public void agregarModulo(long idPersona, long idModulo);
	public Map<Long, String> obtenerModulos();
	public List<Par> obtenerMunicipios(int estado);
	public List<Par> obtenerEstados();
}
