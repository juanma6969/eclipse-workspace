package dominio;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the thabitacion database table.
 * 
 */
@Entity
@NamedQuery(name="Thabitacion.findAll", query="SELECT t FROM Thabitacion t")
public class Thabitacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idHabitacion;

	private int numero;

	private double precio;

	//bi-directional many-to-one association to Tfoto
	@OneToMany(mappedBy="thabitacion", fetch=FetchType.EAGER)
	private List<Tfoto> tfotos;

	//bi-directional many-to-one association to Ttipohabitacion
	@ManyToOne
	@JoinColumn(name="IdTHab")
	private Ttipohabitacion ttipohabitacion;

	//bi-directional many-to-one association to Treserva
	@OneToMany(mappedBy="thabitacion", fetch=FetchType.EAGER)
	private List<Treserva> treservas;

	public Thabitacion() {
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

	public List<Tfoto> getTfotos() {
		return this.tfotos;
	}

	public void setTfotos(List<Tfoto> tfotos) {
		this.tfotos = tfotos;
	}

	public Tfoto addTfoto(Tfoto tfoto) {
		getTfotos().add(tfoto);
		tfoto.setThabitacion(this);

		return tfoto;
	}

	public Tfoto removeTfoto(Tfoto tfoto) {
		getTfotos().remove(tfoto);
		tfoto.setThabitacion(null);

		return tfoto;
	}

	public Ttipohabitacion getTtipohabitacion() {
		return this.ttipohabitacion;
	}

	public void setTtipohabitacion(Ttipohabitacion ttipohabitacion) {
		this.ttipohabitacion = ttipohabitacion;
	}

	public List<Treserva> getTreservas() {
		return this.treservas;
	}

	public void setTreservas(List<Treserva> treservas) {
		this.treservas = treservas;
	}

	public Treserva addTreserva(Treserva treserva) {
		getTreservas().add(treserva);
		treserva.setThabitacion(this);

		return treserva;
	}

	public Treserva removeTreserva(Treserva treserva) {
		getTreservas().remove(treserva);
		treserva.setThabitacion(null);

		return treserva;
	}

}