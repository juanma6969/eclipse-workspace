package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the tservicios database table.
 * 
 */
@Entity
@Table(name="tservicios")
@NamedQuery(name="Tservicio.findAll", query="SELECT t FROM Tservicio t")
public class Tservicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idServicio;

	private String descripcion;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private double importe;

	//bi-directional many-to-one association to Tclientes2
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IdClienteC")
	private Tclientes2 tclientes2;

	public Tservicio() {
	}

	public int getIdServicio() {
		return this.idServicio;
	}

	public void setIdServicio(int idServicio) {
		this.idServicio = idServicio;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public double getImporte() {
		return this.importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public Tclientes2 getTclientes2() {
		return this.tclientes2;
	}

	public void setTclientes2(Tclientes2 tclientes2) {
		this.tclientes2 = tclientes2;
	}

}