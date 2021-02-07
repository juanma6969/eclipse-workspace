package dominio;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ttarifa database table.
 * 
 */
@Entity
@NamedQuery(name="Ttarifa.findAll", query="SELECT t FROM Ttarifa t")
public class Ttarifa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTarifa;

	private String nombre;

	private int porcentaje;

	//bi-directional many-to-one association to Treserva
	@OneToMany(mappedBy="ttarifa", fetch=FetchType.EAGER)
	private List<Treserva> treservas;

	public Ttarifa() {
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

	public List<Treserva> getTreservas() {
		return this.treservas;
	}

	public void setTreservas(List<Treserva> treservas) {
		this.treservas = treservas;
	}

	public Treserva addTreserva(Treserva treserva) {
		getTreservas().add(treserva);
		treserva.setTtarifa(this);

		return treserva;
	}

	public Treserva removeTreserva(Treserva treserva) {
		getTreservas().remove(treserva);
		treserva.setTtarifa(null);

		return treserva;
	}

}