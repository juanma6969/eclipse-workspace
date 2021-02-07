package dominio;

import java.util.List;

public class Proveedor {

	private int idProveedor;
	private String nombre;
	private int telefono;
	private String contacto;	
	private List<Compra> compras;
	
	public Proveedor(String nombre, int telefono, String contacto) {
		this.nombre = nombre;
		this.telefono = telefono;
		this.contacto = contacto;
	}
	
	public Proveedor() {
		
	}

	public int getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(int idProveedor) {
		this.idProveedor = idProveedor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getContacto() {
		return contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	public List<Compra> getCompras() {
		return compras;
	}

	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}

	@Override
	public String toString() {
		return "Proveedor [idProveedor=" + idProveedor + ", nombre=" + nombre + ", telefono=" + telefono + ", contacto="
				+ contacto + ", compras=" + compras + "]";
	}
	
	
	
}
