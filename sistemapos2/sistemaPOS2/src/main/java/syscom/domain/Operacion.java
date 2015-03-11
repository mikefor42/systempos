package syscom.domain;

import java.io.Serializable;

public class Operacion implements Serializable {
	public static final int VENTA = 1;
	public static final int COMPRA = 2;
	
	int tipo;

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	
}
