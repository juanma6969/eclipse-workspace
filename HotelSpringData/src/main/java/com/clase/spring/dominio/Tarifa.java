package com.clase.spring.dominio;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ttarifa")
public class Tarifa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTarifa;

	private String nombre;

	private int porcentaje;

	//bi-directional many-to-one association to Reserva
	@OneToMany(mappedBy="tarifa", fetch=FetchType.EAGER)
	private List<Reserva> reservas;

	public Tarifa() {
	}

	public Tarifa( String nombre, int porcentaje) {
		super();
		
		this.nombre = nombre;
		this.porcentaje = porcentaje;
	}

	public int getIdTarifa() {
		return this.idTarifa;
	}

	public void setIdTarifa(int idTarifa) {
		this.idTarifa = idTarifa;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPorcentaje() {
		return this.porcentaje;
	}

	public void setPorcentaje(int porcentaje) {
		this.porcentaje = porcentaje;
	}

	public List<Reserva> getTreservas() {
		return this.reservas;
	}

	public void setTreservas(List<Reserva> treservas) {
		this.reservas = treservas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idTarifa;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + porcentaje;
		result = prime * result + ((reservas == null) ? 0 : reservas.hashCode());
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
		Tarifa other = (Tarifa) obj;
		if (idTarifa != other.idTarifa)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (porcentaje != other.porcentaje)
			return false;
		if (reservas == null) {
			if (other.reservas != null)
				return false;
		} else if (!reservas.equals(other.reservas))
			return false;
		return true;
	}

	@Override
	public String toString() {
		final int maxLen = 10;
		return "Tarifa [idTarifa=" + idTarifa + ", nombre=" + nombre + ", porcentaje=" + porcentaje + ", treservas="
				+ (reservas != null ? reservas.subList(0, Math.min(reservas.size(), maxLen)) : null) + "]";
	}

	

}