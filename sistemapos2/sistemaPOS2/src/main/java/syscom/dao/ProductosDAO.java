package syscom.dao;

import java.util.Collection;
import java.util.List;

import syscom.domain.Atributo;
import syscom.domain.Par;
import syscom.domain.Producto;

public interface ProductosDAO {

	public List<Producto> obtenerProductos();

	long guardarProducto(Producto producto) throws Exception;

	Producto obtenerProducto(long idproducto);

	void editarProducto(Producto producto);

	void borrarProducto(String idproducto);

	public List<Par> obtenerGrupos();

	public List<Atributo> obtenerAtributos(long id_Grupo);

	public List obtenerProductos(String texto);

	public void guardarAtributo(Par atributo);

	public Object obtenerAllAtributos();

	public void guardarGrupo(Par grupo);

}
