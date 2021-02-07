package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tclientes2 database table.
 * 
 */
@Entity
@NamedQuery(name="Tclientes2.findAll", query="SELECT t FROM Tclientes2 t")
public class Tclientes2 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCliente;

	private String email;

	private String nombre;

	private String provincia;

	//bi-directional many-to-one association to Tservicio
	@OneToMany(mappedBy="tclientes2")
	private List<Tservicio> tservicios;

	public Tclientes2() {
	}

	public int getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getProvincia() {
		return this.provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public List<Tservicio> getTservicios() {
		return this.tservicios;
	}

	public void setTservicios(List<Tservicio> tservicios) {
		this.tservicios = tservicios;
	}

	public Tservicio addTservicio(Tservicio tservicio) {
		getTservicios().add(tservicio);
		tservicio.setTclientes2(this);

		return tservicio;
	}

	public Tservicio removeTservicio(Tservicio tservicio) {
		getTservicios().remove(tservicio);
		tservicio.setTclientes2(null);

		return tservicio;
	}

}