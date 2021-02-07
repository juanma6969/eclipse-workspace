package dominio;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the treserva database table.
 * 
 */
@Embeddable
public class TreservaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.DATE)
	private java.util.Date fechaD;

	@Temporal(TemporalType.DATE)
	private java.util.Date fechaH;

	@Column(insertable=false, updatable=false)
	private int idCliente;

	@Column(insertable=false, updatable=false)
	private int idHabitacion;

	public TreservaPK() {
	}
	public java.util.Date getFechaD() {
		return this.fechaD;
	}
	public void setFechaD(java.util.Date fechaD) {
		this.fechaD = fechaD;
	}
	public java.util.Date getFechaH() {
		return this.fechaH;
	}
	public void setFechaH(java.util.Date fechaH) {
		this.fechaH = fechaH;
	}
	public int getIdCliente() {
		return this.idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public int getIdHabitacion() {
		return this.idHabitacion;
	}
	public void setIdHabitacion(int idHabitacion) {
		this.idHabitacion = idHabitacion;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TreservaPK)) {
			return false;
		}
		TreservaPK castOther = (TreservaPK)other;
		return 
			this.fechaD.equals(castOther.fechaD)
			&& this.fechaH.equals(castOther.fechaH)
			&& (this.idCliente == castOther.idCliente)
			&& (this.idHabitacion == castOther.idHabitacion);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.fechaD.hashCode();
		hash = hash * prime + this.fechaH.hashCode();
		hash = hash * prime + this.idCliente;
		hash = hash * prime + this.idHabitacion;
		
		return hash;
	}
}