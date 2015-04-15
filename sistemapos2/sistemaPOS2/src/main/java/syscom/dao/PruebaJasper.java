package syscom.dao;

import java.util.ArrayList;
import java.util.List;

import syscom.domain.DetalleDoc;

public class PruebaJasper extends ArrayList<DetalleDoc> {
	String empresa_rfc;
	String empresa_nombre;
	String empresa_direccion;
	String empresa_telefonos;
	String empresa_email;
	String ciudad_empresa;
	String empresa_resolucion_dian;
	String empresa_logo;
	String nro_factura;
	String fecha_factura;
	String nip;
	String cliente;
	String telecasa;
	String direccion;
	String ciudad;
	String producto;
	String valor_total_sum;
	String iva_sum;

	public PruebaJasper(String empresa_nit, String empresa_nombre,
			String empresa_direccion, String empresa_telefonos,
			String empresa_email, String ciudad_empresa,
			String empresa_resolucion_dian, String empresa_logo,
			String nro_factura, String fecha_factura, String nip,
			String cliente, String telecasa, String direccion, String ciudad,
			String producto, String valor_total_sum, String iva_sum) {
		super();
		this.empresa_rfc = empresa_nit;
		this.empresa_nombre = empresa_nombre;
		this.empresa_direccion = empresa_direccion;
		this.empresa_telefonos = empresa_telefonos;
		this.empresa_email = empresa_email;
		this.ciudad_empresa = ciudad_empresa;
		this.empresa_resolucion_dian = empresa_resolucion_dian;
		this.empresa_logo = empresa_logo;
		this.nro_factura = nro_factura;
		this.fecha_factura = fecha_factura;
		this.nip = nip;
		this.cliente = cliente;
		this.telecasa = telecasa;
		this.direccion = direccion;
		this.ciudad = ciudad;
		this.producto = producto;
		this.valor_total_sum = valor_total_sum;
		this.iva_sum = iva_sum;
	}
	
	public String getEmpresa_nit() {
		return empresa_rfc;
	}
	public void setEmpresa_nit(String empresa_nit) {
		this.empresa_rfc = empresa_nit;
	}
	public String getEmpresa_nombre() {
		return empresa_nombre;
	}
	public void setEmpresa_nombre(String empresa_nombre) {
		this.empresa_nombre = empresa_nombre;
	}
	public String getEmpresa_direccion() {
		return empresa_direccion;
	}
	public void setEmpresa_direccion(String empresa_direccion) {
		this.empresa_direccion = empresa_direccion;
	}
	public String getEmpresa_telefonos() {
		return empresa_telefonos;
	}
	public void setEmpresa_telefonos(String empresa_telefonos) {
		this.empresa_telefonos = empresa_telefonos;
	}
	public String getEmpresa_email() {
		return empresa_email;
	}
	public void setEmpresa_email(String empresa_email) {
		this.empresa_email = empresa_email;
	}
	public String getCiudad_empresa() {
		return ciudad_empresa;
	}
	public void setCiudad_empresa(String ciudad_empresa) {
		this.ciudad_empresa = ciudad_empresa;
	}
	public String getEmpresa_resolucion_dian() {
		return empresa_resolucion_dian;
	}
	public void setEmpresa_resolucion_dian(String empresa_resolucion_dian) {
		this.empresa_resolucion_dian = empresa_resolucion_dian;
	}
	public String getEmpresa_logo() {
		return empresa_logo;
	}
	public void setEmpresa_logo(String empresa_logo) {
		this.empresa_logo = empresa_logo;
	}
	public String getNro_factura() {
		return nro_factura;
	}
	public void setNro_factura(String nro_factura) {
		this.nro_factura = nro_factura;
	}
	public String getFecha_factura() {
		return fecha_factura;
	}
	public void setFecha_factura(String fecha_factura) {
		this.fecha_factura = fecha_factura;
	}
	public String getNip() {
		return nip;
	}
	public void setNip(String nip) {
		this.nip = nip;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public String getTelecasa() {
		return telecasa;
	}
	public void setTelecasa(String telecasa) {
		this.telecasa = telecasa;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
	public String getValor_total_sum() {
		return valor_total_sum;
	}
	public void setValor_total_sum(String valor_total_sum) {
		this.valor_total_sum = valor_total_sum;
	}
	public String getIva_sum() {
		return iva_sum;
	}
	public void setIva_sum(String iva_sum) {
		this.iva_sum = iva_sum;
	}
}
