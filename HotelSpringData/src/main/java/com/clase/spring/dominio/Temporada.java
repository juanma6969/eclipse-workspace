package com.clase.spring.dominio;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="ttemporada")
public class Temporada implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTemporada;
private int porcentaje;
	 

    @Temporal(TemporalType.DATE)
	private Date fechaD;

	@Temporal(TemporalType.DATE)
	private Date fechaH;

	

	//bi-directional many-to-one association to Reserva
	@OneToMany(mappedBy="temporada", fetch=FetchType.EAGER)
	private List<Reserva> reservas;

	public Temporada() {
	}

	
	public Temporada( int porcentaje, Date fechaD, Date fechaH) {
		super();

		this.porcentaje = porcentaje;
		this.fechaD = fechaD;
		this.fechaH = fechaH;
	}


	public int getIdTemporada() {
		return this.idTemporada;
	}

	public void setIdTemporada(int idTemporada) {
		this.idTemporada = idTemporada;
	}

	public Date getFechaD() {
		return this.fechaD;
	}

	public void setFechaD(Date fechaD) {
		this.fechaD = fechaD;
	}

	public Date getFechaH() {
		return this.fechaH;
	}

	public void setFechaH(Date fechaH) {
		this.fechaH = fechaH;
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
	public String toString() {
		final int maxLen = 10;
		return "Temporada [idTemporada=" + idTemporada + ", fechaD=" + fechaD + ", fechaH=" + fechaH + ", porcentaje="
				+ porcentaje + ", reservas="
				+ (reservas != null ? reservas.subList(0, Math.min(reservas.size(), maxLen)) : null) + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fechaD == null) ? 0 : fechaD.hashCode());
		result = prime * result + ((fechaH == null) ? 0 : fechaH.hashCode());
		result = prime * result + idTemporada;
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
		Temporada other = (Temporada) obj;
		if (fechaD == null) {
			if (other.fechaD != null)
				return false;
		} else if (!fechaD.equals(other.fechaD))
			return false;
		if (fechaH == null) {
			if (other.fechaH != null)
				return false;
		} else if (!fechaH.equals(other.fechaH))
			return false;
		if (idTemporada != other.idTemporada)
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


}
