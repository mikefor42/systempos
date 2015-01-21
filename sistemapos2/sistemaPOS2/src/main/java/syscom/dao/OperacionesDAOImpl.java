package syscom.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import syscom.domain.Documento;
import syscom.domain.Producto;

@Component
public class OperacionesDAOImpl implements OperacionesDAO {

	public void guardarDocumento(Documento documento) {
		
		
	}

	public Object obtenerProductos() {
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

}
