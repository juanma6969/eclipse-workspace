package dominio;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tservicio database table.
 * 
 */
@Entity
@NamedQuery(name="Tservicio.findAll", query="SELECT t FROM Tservicio t")
public class Tservicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idServicio;

	@Temporal(TemporalType.DATE)
	private Date fechaServicio;

	private double precio;

	//bi-directional many-to-one association to Tconsumicion
	@OneToMany(mappedBy="tservicio", fetch=FetchType.EAGER)
	private List<Tconsumicion> tconsumicions;

	//bi-directional many-to-one association to Ttservicio
	@ManyToOne
	@JoinColumn(name="IdTServicioT")
	private Ttservicio ttservicio;

	public Tservicio() {
	}

	public int getIdServicio() {
		return this.idServicio;
	}

	public void setIdServicio(int idServicio) {
		this.idServicio = idServicio;
	}

	public Date getFechaServicio() {
		return this.fechaServicio;
	}

	public void setFechaServicio(Date fechaServicio) {
		this.fechaServicio = fechaServicio;
	}

	public double getPrecio() {
		return this.precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public List<Tconsumicion> getTconsumicions() {
		return this.tconsumicions;
	}

	public void setTconsumicions(List<Tconsumicion> tconsumicions) {
		this.tconsumicions = tconsumicions;
	}

	public Tconsumicion addTconsumicion(Tconsumicion tconsumicion) {
		getTconsumicions().add(tconsumicion);
		tconsumicion.setTservicio(this);

		return tconsumicion;
	}

	public Tconsumicion removeTconsumicion(Tconsumicion tconsumicion) {
		getTconsumicions().remove(tconsumicion);
		tconsumicion.setTservicio(null);

		return tconsumicion;
	}

	public Ttservicio getTtservicio() {
		return this.ttservicio;
	}

	public void setTtservicio(Ttservicio ttservicio) {
		this.ttservicio = ttservicio;
	}

}