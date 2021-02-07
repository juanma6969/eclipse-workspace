package Dominio;

public class Clientes {
private int idCliente;
private String nombre;
private String direccion;
//Constructores
public Clientes() {
	
}
public Clientes (int pidCliente,String pnombre,String pdireccion) {
	this.idCliente=pidCliente;
	this.nombre=pnombre;
	this.direccion=pdireccion;
	
}
//Getters y Setters
public int getIdCliente() {
	return idCliente;
}
public void setIdCliente(int idCliente) {
	this.idCliente = idCliente;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getDireccion() {
	return direccion;
}
public void setDireccion(String direccion) {
	this.direccion = direccion;
}




}
