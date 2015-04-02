package syscom.dao;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import syscom.domain.Par;
import syscom.domain.Permiso;
import syscom.domain.Persona;


public interface PersonasDAO {
	public List<Persona> obtenerClientes();
	public long guardarCliente(Persona cliente);
	public Persona obtenerCliente(long idCliente) throws ParseException;
	public void editarCliente(Persona cliente);
	public void borrarCliente(long idCliente);

	public List<Persona> obtenerProveedores();
	public long guardarProveedor(Persona proveedor);
	public Persona obtenerProveedor(long idproveedor) throws ParseException;
	public void editarProveedor(Persona proveedor);
	public void borrarProveedor(long idproveedor);

	public List<Persona> obtenerPersonalList();
	public long guardarPersonal(Persona personal);
	public Persona obtenerPersonal(long idpersonal) throws ParseException;
	public void editarPersonal(Persona personal);
	public void borrarPersonal(long idpersonal);
	public List<Permiso> obtenerPermisosPersonal(long id);

	public void agregarModulo(long idPersona, long idModulo);
	public Map<Long, String> obtenerModulos();
	public List<Par> obtenerMunicipios(int string);
	public List<Par> obtenerEstados();
}
