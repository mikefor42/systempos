package syscom.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import syscom.domain.Producto;

@Component
public class ProductosDAOImpl implements ProductosDAO {

	public List<Producto> obtenerProductos() {
		@SuppressWarnings("rawtypes")
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

	public void guardarProducto(Producto producto) {
		// TODO Auto-generated method stub
		
	}

	public Producto obtenerProducto(String idproducto) {
		Producto p = new Producto();
		p.setDescripcion("Un producto solito");
		return p;
	}

	public void editarProducto(Producto producto) {
		// TODO Auto-generated method stub
		
	}

	public void borrarProducto(String idproducto) {
		// TODO Auto-generated method stub
		
	}
	
}
