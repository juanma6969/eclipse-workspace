package com.clase.spring.dominio;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tconsumicion")
public class Consumicion {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private int idConsumicion;
	
	@ManyToOne
	@JoinColumn(name="IdReservaR")
	private Reserva reserva;
	
	@ManyToOne
	@JoinColumn(name="IdServicioS")
	private Servicio servicio;
	
	@Temporal(TemporalType.DATE)
	private Date fechaConsumicion;
	
	private Double precio;

	public Consumicion( Reserva reserva, Servicio servicio, Date fechaConsumicion, Double precio) {
		super();

		this.reserva = reserva;
		this.servicio = servicio;
		this.fechaConsumicion = fechaConsumicion;
		this.precio = precio;
	}

	public int getIdConsumicion() {
		return idConsumicion;
	}

	public void setIdConsumicion(int idConsumicion) {
		this.idConsumicion = idConsumicion;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	public Date getFechaConsumicion() {
		return fechaConsumicion;
	}

	public void setFechaConsumicion(Date fechaConsumicion) {
		this.fechaConsumicion = fechaConsumicion;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idConsumicion;
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
		Consumicion other = (Consumicion) obj;
		if (idConsumicion != other.idConsumicion)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Consumicion [idConsumicion=" + idConsumicion + ", reserva=" + reserva + ", servicio=" + servicio
				+ ", fechaConsumicion=" + fechaConsumicion + ", precio=" + precio + "]";
	}
	
}
