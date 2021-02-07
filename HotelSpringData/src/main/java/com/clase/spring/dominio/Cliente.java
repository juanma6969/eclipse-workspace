package com.clase.spring.dominio;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="tcliente")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCliente;

	private String nombre;

	@Temporal(TemporalType.DATE)
	private Date fecha_Nac;
	
	private String direccion;
	
	

	
	private String edad;


	private String telefono;

	//bi-directional many-to-one association to Reserva
	@OneToMany(mappedBy="Cliente", fetch=FetchType.EAGER)
	private List<Reserva> reservas;

	public Cliente() {
	}


	public Cliente( String nombre, Date fecha_Nac, String direccion, String edad, String telefono) {
		super();
	
		this.nombre = nombre;
		this.fecha_Nac = fecha_Nac;
		this.direccion = direccion;
		this.edad = edad;
		this.telefono = telefono;
	}





	public int getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEdad() {
		return this.edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public Date getFecha_Nac() {
		return this.fecha_Nac;
	}

	public void setFecha_Nac(Date fecha_Nac) {
		this.fecha_Nac = fecha_Nac;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Reserva> getTreservas() {
		return this.reservas;
	}

	public void setTreservas(List<Reserva> treservas) {
		this.reservas = treservas;
	}
	
@Override
	public String toString() {
		final int maxLen = 10;
		return "Cliente [idCliente=" + idCliente + ", nombre=" + nombre + ", direccion=" + direccion + ", fecha_Nac="
				+ fecha_Nac + ", edad=" + edad + ", telefono=" + telefono + ", reservas="
				+ (reservas != null ? reservas.subList(0, Math.min(reservas.size(), maxLen)) : null) + "]";
	}
	
}
