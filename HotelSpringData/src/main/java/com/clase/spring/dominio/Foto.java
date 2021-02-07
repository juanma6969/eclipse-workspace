package com.clase.spring.dominio;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="tfoto")
public class Foto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idFotos;

	private String descripcion;

	@Lob
	private byte[] imagen;

	//bi-directional many-to-one association to Habitacion
	@ManyToOne
	@JoinColumn(name="IdHab")
	private Habitacion habitacion;

	public Foto() {
	}

	public Foto(String descripcion, byte[] imagen, Habitacion habitacion) {
		super();
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.habitacion = habitacion;
	}

	public int getIdFotos() {
		return this.idFotos;
	}

	public void setIdFotos(int idFotos) {
		this.idFotos = idFotos;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public byte[] getImagen() {
		return this.imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}

	public Habitacion getThabitacion() {
		return this.habitacion;
	}

	public void setThabitacion(Habitacion thabitacion) {
		this.habitacion = thabitacion;
	}

	@Override
	public String toString() {
		return "Foto [idFotos=" + idFotos + ", descripcion=" + descripcion + ", habitacion=" + habitacion + "]";
	}

}

