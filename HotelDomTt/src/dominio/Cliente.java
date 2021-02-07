package dominio;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tcliente database table.
 * 
 */
@Entity
@Table(name="tcliente")
@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCliente;

	private String direccion;

	private String edad;

	@Temporal(TemporalType.DATE)
	private Date fecha_Nac;

	private String nombre;

	private int tclientescol;

	private String telefono;

	//bi-directional many-to-one association to Treserva
	@OneToMany(mappedBy="tcliente", fetch=FetchType.EAGER)
	private List<Treserva> treservas;

	public Cliente() {
	}

	public int getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEdad() {
		return this.edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public Date getFecha_Nac() {
		return this.fecha_Nac;
	}

	public void setFecha_Nac(Date fecha_Nac) {
		this.fecha_Nac = fecha_Nac;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTclientescol() {
		return this.tclientescol;
	}

	public void setTclientescol(int tclientescol) {
		this.tclientescol = tclientescol;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Treserva> getTreservas() {
		return this.treservas;
	}

	public void setTreservas(List<Treserva> treservas) {
		this.treservas = treservas;
	}

	public Treserva addTreserva(Treserva treserva) {
		getTreservas().add(treserva);
		treserva.setTcliente(this);

		return treserva;
	}

	public Treserva removeTreserva(Treserva treserva) {
		getTreservas().remove(treserva);
		treserva.setTcliente(null);

		return treserva;
	}

}