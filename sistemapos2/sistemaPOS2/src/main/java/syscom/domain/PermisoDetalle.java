package syscom.domain;

public class PermisoDetalle {
	String descripcion;
	int valor;
	boolean valor2;
	
	public PermisoDetalle() {
		this.descripcion = "algo";
		this.valor = 1;
		this.valor2 = true;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	public boolean isValor2() {
		return valor2;
	}
	public void setValor2(boolean valor2) {
		this.valor2 = valor2;
	}

	@Override
	public String toString() {
		return "PermisoDetalle [descripcion=" + descripcion + ", valor="
				+ valor + ", valor2=" + valor2 + "]";
	}
	
	
	
	
}
