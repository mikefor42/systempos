package syscom.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import syscom.domain.Abono;
import syscom.domain.Cuenta;
import syscom.domain.Documento;
import syscom.domain.Producto;

@Component
public class OperacionesDAOImpl implements OperacionesDAO {

	public void guardarDocumento(Documento documento) {
		
		
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
	
	
}
