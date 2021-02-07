package dominio;

import java.io.Serializable;
import java.util.List;

public class Producto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//Atributos
	private int  idProducto;
	private String nombre;
	private String descripcion;
	private List<Compra> lineasCompras;
	//Constructor 
	public Producto() {}
	public Producto(String pNombre,String pDescripcion) {
		this.nombre=pNombre;
		this.descripcion=pDescripcion;
	}
	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
		result = prime * result + idProducto;
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
		Producto other = (Producto) obj;
		if (idProducto != other.idProducto)
			return false;
		return true;
	}
	//toString
	@Override
	public String toString() {
		
		return "Producto [getIdProducto()=" + getIdProducto() + ", getNombre()=" + getNombre() + ", getDescripcion()="
				+ getDescripcion() ;
	}
	
	
}
