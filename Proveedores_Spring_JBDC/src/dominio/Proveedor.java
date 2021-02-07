package dominio;

import java.io.Serializable;
import java.util.List;



public class Proveedor implements Serializable{


	private static final long serialVersionUID = 1L;
	
	//Atributos
	private int  idProveedor;
	private String nombre;
	private String telefono;
	private String contacto;
	private List<Compra> lineasCompras;
	//constructor
	public Proveedor() {}
	public Proveedor(String pNombre,String pTelefono,String pContacto) {
		this.nombre=pNombre;
		this.telefono=pTelefono;
		this.contacto=pContacto;
	}
	//Getters and Setters
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
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getContacto() {
		return contacto;
	}
	public void setContacto(String contacto) {
		this.contacto = contacto;
	}
	public List<Compra> getLineasCompras() {
		return lineasCompras;
	}
	public void setLineasCompras(List<Compra> lineasCompras) {
		this.lineasCompras = lineasCompras;
	}
	//Hascode and equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idProveedor;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Proveedor other = (Proveedor) obj;
		if (idProveedor != other.idProveedor)
			return false;
		return true;
	}
	//toString
	@Override
	public String toString() {
		return "Proveedor [getIdProveedor()=" + getIdProveedor() + ", getNombre()=" + getNombre() + ", getTelefono()="
				+ getTelefono() + ", getContacto()=" + getContacto() + ", getLineasCompras()=" + getLineasCompras()
				+ "]";
	}
	
	
}
