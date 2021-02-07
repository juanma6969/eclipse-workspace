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
@Table(name="ttipohabitacion")
@NamedQuery(name="Tipohabitacion.findAll", query="SELECT t FROM Tipohabitacion t")
public class TipoHabitacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String idTHab;

	private String descripcion;

	
	public TipoHabitacion(String idTHab, String descripcion) {
		super();
		this.idTHab = idTHab;
		this.descripcion = descripcion;
	}

	//bi-directional many-to-one association to Habitacion
	@OneToMany(mappedBy="tipohabitacion", fetch=FetchType.EAGER)
	private List<Habitacion> habitaciones;

	public TipoHabitacion() {
	}

	public String getIdTHab() {
		return this.idTHab;
	}

	public void setIdTHab(String idTHab) {
		this.idTHab = idTHab;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Habitacion> getThabitacions() {
		return this.habitaciones;
	}

	public void setThabitacions(List<Habitacion> thabitacions) {
		this.habitaciones = thabitacions;
	}

	@Override
	public String toString() {
		final int maxLen = 10;
		return "TipoHabitacion [idTHab=" + idTHab + ", descripcion=" + descripcion + ", habitaciones="
				+ (habitaciones != null ? habitaciones.subList(0, Math.min(habitaciones.size(), maxLen)) : null) + "]";
	}

	

}

