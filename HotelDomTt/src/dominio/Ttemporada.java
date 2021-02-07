package dominio;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ttemporada database table.
 * 
 */
@Entity
@NamedQuery(name="Ttemporada.findAll", query="SELECT t FROM Ttemporada t")
public class Ttemporada implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTemporada;

	@Temporal(TemporalType.DATE)
	private Date fechaD;

	@Temporal(TemporalType.DATE)
	private Date fechaH;

	private int porcentaje;

	//bi-directional many-to-one association to Treserva
	@OneToMany(mappedBy="ttemporada", fetch=FetchType.EAGER)
	private List<Treserva> treservas;

	public Ttemporada() {
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

	public List<Treserva> getTreservas() {
		return this.treservas;
	}

	public void setTreservas(List<Treserva> treservas) {
		this.treservas = treservas;
	}

	public Treserva addTreserva(Treserva treserva) {
		getTreservas().add(treserva);
		treserva.setTtemporada(this);

		return treserva;
	}

	public Treserva removeTreserva(Treserva treserva) {
		getTreservas().remove(treserva);
		treserva.setTtemporada(null);

		return treserva;
	}

}