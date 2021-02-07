package dominio;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ttservicio database table.
 * 
 */
@Entity
@NamedQuery(name="Ttservicio.findAll", query="SELECT t FROM Ttservicio t")
public class Ttservicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String idTServicio;

	private String descripcion;

	//bi-directional many-to-one association to Tservicio
	@OneToMany(mappedBy="ttservicio", fetch=FetchType.EAGER)
	private List<Tservicio> tservicios;

	public Ttservicio() {
	}

	public String getIdTServicio() {
		return this.idTServicio;
	}

	public void setIdTServicio(String idTServicio) {
		this.idTServicio = idTServicio;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Tservicio> getTservicios() {
		return this.tservicios;
	}

	public void setTservicios(List<Tservicio> tservicios) {
		this.tservicios = tservicios;
	}

	public Tservicio addTservicio(Tservicio tservicio) {
		getTservicios().add(tservicio);
		tservicio.setTtservicio(this);

		return tservicio;
	}

	public Tservicio removeTservicio(Tservicio tservicio) {
		getTservicios().remove(tservicio);
		tservicio.setTtservicio(null);

		return tservicio;
	}

}