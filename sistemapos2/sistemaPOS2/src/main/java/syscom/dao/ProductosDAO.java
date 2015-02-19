package syscom.dao;

import java.util.List;

import syscom.domain.Producto;

public interface ProductosDAO {

	public List<Producto> obtenerProductos();

	void guardarProducto(Producto producto);

	Producto obtenerProducto(long idproducto);

	void editarProducto(Producto producto);

	void borrarProducto(String idproducto);

}
