package com.clase.spring.dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="tclientes")
public class Cliente implements Serializable {
	
	private static final long serialVersionUID = 1L;
	 

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idCliente;
	private String password;
	private String nombre;
	private String apellidos;
	private String telefono;
	private String email;
	
	@OneToMany(mappedBy="tcliente", fetch=FetchType.EAGER)
	private List<Pedido> lPedidos=new ArrayList<>();
	
	 public Cliente() {}
	public Cliente( String password, String nombre, String apellidos, String telefono, String email) {
		super();
	
		this.password = password;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.email = email;
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
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Pedido> getlPedidos() {
		return lPedidos;
	}
	public void setlPedidos(ArrayList<Pedido> lPedidos) {
		this.lPedidos = lPedidos;
	}
	public Integer getIdCliente() {
		return idCliente;
	}
	
	
	
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCliente == null) ? 0 : idCliente.hashCode());
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
		Cliente other = (Cliente) obj;
		if (idCliente == null) {
			if (other.idCliente != null)
				return false;
		} else if (!idCliente.equals(other.idCliente))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Cliente [getPassword()=" + getPassword() + ", getNombre()=" + getNombre() + ", getApellidos()="
				+ getApellidos() + ", getTelefono()=" + getTelefono() + ", getEmail()=" + getEmail()
				+ ", getlPedidos()=" + getlPedidos().size() + ", getIdCliente()=" + getIdCliente() + ", hashCode()="
				+ hashCode() + "]";
	}
	
	
	


}
