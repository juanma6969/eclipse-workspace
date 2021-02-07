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
@Table(name="tservicio")
public class Servicio {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private int idServicio;
	
	@Temporal(TemporalType.DATE)
	private Date fechaServicio;
	
	private double precio;

	@ManyToOne
	@JoinColumn(name="IdTServicioT")
	private TipoServicio tservicio;

	public Servicio( Date fechaServicio, double precio, TipoServicio tservicio) {
		super();
		this.fechaServicio = fechaServicio;
		this.precio = precio;
		this.tservicio = tservicio;
	}

	public int getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(int idServicio) {
		this.idServicio = idServicio;
	}

	public Date getFechaServicio() {
		return fechaServicio;
	}

	public void setFechaServicio(Date fechaServicio) {
		this.fechaServicio = fechaServicio;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public TipoServicio getTservicio() {
		return tservicio;
	}

	public void setTservicio(TipoServicio tservicio) {
		this.tservicio = tservicio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idServicio;
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
		Servicio other = (Servicio) obj;
		if (idServicio != other.idServicio)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Servicio [idServicio=" + idServicio + ", fechaServicio=" + fechaServicio + ", precio=" + precio
				+ ", tservicio=" + tservicio + "]";
	}

	


}
