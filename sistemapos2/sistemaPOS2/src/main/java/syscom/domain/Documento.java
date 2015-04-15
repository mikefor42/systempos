package syscom.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="documentos")
public class Documento implements Serializable {
	
	public static int FACTURA_VENTA = 1;
	public static int FACTURA_COMPRA = 2;
	public static int TICKET_VENTA = 3;
	public static int TICKET_COMPRA = 4;
	public static int NOTA_CREDITO_VENTA = 5;
	public static int NOTA_CREDITO_COMPRA = 6;
	
	@Id
	@Column(name="ID_Factura")
	long ID;	
	long IDCliente;  
	long IDPersonal;
	long IDProveedor;
	
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	Date fecha;
	int status;
	double subtotal;
	double iva;
	double total;
	String numDocumento;
	int tipo;
	double descuento;
	
	@Transient
	DetalleDoc detalle;		
	
	@Transient
	List<DetalleDoc> detalleList;
	@Transient
	boolean ventaCredito;
	@Transient
	int dias;
	
	@Transient
	Persona cliente;
	
	
	public Documento() {
		this.setFecha(new Date());
//		super();
//		ID = (long)(Math.random() * 10000); 
//		IDCliente = ID;
//		IDPersonal = ID;
//		this.fecha = new Date();
//		this.status = 1;
//		this.subtotal = 100;
//		this.iva = 15;
//		this.total = 115;
//		this.numDocumento = (int) ID;
//		this.tipo = 1;
//		this.descuento = 10;		
	}





	public Persona getCliente() {
		return cliente;
	}





	public void setCliente(Persona cliente) {
		this.cliente = cliente;
	}





	public boolean isVentaCredito() {
		return ventaCredito;
	}





	public void setVentaCredito(boolean ventaCredito) {
		this.ventaCredito = ventaCredito;
	}





	public int getDias() {
		return dias;
	}





	public void setDias(int dias) {
		this.dias = dias;
	}





	public DetalleDoc getDetalle() {
		return detalle;
	}





	public void setDetalle(DetalleDoc detalle) {
		this.detalle = detalle;
	}





	public List<DetalleDoc> getDetalleList() {
		return detalleList;
	}





	public void setDetalleList(List<DetalleDoc> detalleList) {
		this.detalleList = detalleList;
	}





	public long getID() {
		return ID;
	}
	public void setID(long iD) {
		ID = iD;
	}
	public long getIDCliente() {
		return IDCliente;
	}
	public void setIDCliente(long iDCliente) {
		IDCliente = iDCliente;
	}
	public long getIDPersonal() {
		return IDPersonal;
	}
	public void setIDPersonal(long iDPersonal) {
		IDPersonal = iDPersonal;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	public double getIva() {
		return iva;
	}
	public void setIva(double iva) {
		this.iva = iva;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}

	public int getTipo() {
		return tipo;
	}
	
	
	public String getNumDocumento() {
		return numDocumento;
	}



	public void setNumDocumento(String numDocumento) {
		this.numDocumento = numDocumento;
	}



	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public double getDescuento() {
		return descuento;
	}
	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}





	public long getIDProveedor() {
		return IDProveedor;
	}





	public void setIDProveedor(long iDProveedor) {
		IDProveedor = iDProveedor;
	}





	@Override
	public String toString() {
		return "Documento [ID=" + ID + ", IDCliente=" + IDCliente
				+ ", IDPersonal=" + IDPersonal + ", fecha=" + fecha
				+ ", status=" + status + ", subtotal=" + subtotal + ", iva="
				+ iva + ", total=" + total + ", numDocumento=" + numDocumento
				+ ", tipo=" + tipo + ", descuento=" + descuento + ", detalle="
				+ detalle + ", detalleList=" + detalleList + "]";
	}
	
	
	
}
