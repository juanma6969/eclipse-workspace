package pfc.dominio;



import java.util.List;

public class Cliente {
	//Aqui podemos encontrar una lista de servicios de la clase servicios 
private int  idCliente;
private String provincia;
private String email;
private String nombre;
private List<Servicio>servicios;
public Cliente(String provincia, String email, String nombre) {

	this.email=email;
	this.provincia = provincia;
	this.nombre = nombre;
}
public Cliente() {

}
public int getIdCliente() {
	return idCliente;
}
public void setIdCliente(int idCliente) {
	this.idCliente = idCliente;
}
public String getProvincia() {
	return provincia;
}
public void setProvincia(String provincia) {
	this.provincia = provincia;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public List<Servicio> getServicios() {
	return servicios;
}
public void setServicios(List<Servicio> servicios) {
	this.servicios = servicios;
}

@Override
public String toString() {
	return "Cliente [idCliente=" + idCliente + ", provincia=" + provincia + ", email=" + email + ", nombre=" + nombre
			+ ", servicios=" + servicios + "]";
}




}