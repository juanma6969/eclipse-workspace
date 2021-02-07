package com.clase.spring.dominio;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="thabitacion")
public class Habitacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idHabitacion;

	

	private double precio;

	//bi-directional many-to-one association to Foto
	@OneToMany(mappedBy="habitacion", fetch=FetchType.EAGER)
	private List<Foto> fotos;

	//bi-directional many-to-one association to Tipohabitacion
	@ManyToOne
	@JoinColumn(name="IdTHab")
	private TipoHabitacion tipohabitacion;

	//bi-directional many-to-one association to Reserva
	@OneToMany(mappedBy="habitacion", fetch=FetchType.EAGER)
	private List<Reserva> reservas;

	private int numero;
	
	public Habitacion() {
	}

	public Habitacion( double precio, TipoHabitacion tipohabitacion, int numero) {
		super();

		this.precio = precio;
		this.tipohabitacion = tipohabitacion;
		this.numero = numero;
	}

	public int getIdHabitacion() {
		return this.idHabitacion;
	}

	public void setIdHabitacion(int idHabitacion) {
		this.idHabitacion = idHabitacion;
	}

	public int getNumero() {
		return this.numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public double getPrecio() {
		return this.precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public List<Foto> getTfotos() {
		return this.fotos;
	}

	public void setTfotos(List<Foto> tfotos) {
		this.fotos = tfotos;
	}

	
	public TipoHabitacion getTtipohabitacion() {
		return this.tipohabitacion;
	}

	public void setTtipohabitacion(TipoHabitacion ttipohabitacion) {
		this.tipohabitacion = ttipohabitacion;
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
		return "Habitacion [idHabitacion=" + idHabitacion + ", precio=" + precio + ", fotos="
				+ (fotos != null ? fotos.subList(0, Math.min(fotos.size(), maxLen)) : null) + ", tipohabitacion="
				+ tipohabitacion + ", reservas="
				+ (reservas != null ? reservas.subList(0, Math.min(reservas.size(), maxLen)) : null) + ", numero="
				+ numero + "]";
	}



}
