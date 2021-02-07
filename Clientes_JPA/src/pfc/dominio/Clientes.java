package pfc.dominio;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TClientes")
public class Clientes {
	@Id
	private String idCliente;
	private String password;
	private String nombre;
	

	

	public Clientes() {}

	public Clientes(String idCliente, String password, String nombre) {

		this.idCliente = idCliente;
		this.password = password;
		this.nombre = nombre;

	}
	public String getIdCliente() {
		return idCliente;
	}
	
	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

}
