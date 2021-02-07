package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tclientes database table.
 * 
 */
@Entity
@Table(name="tclientes")
@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String idCliente;

	private String apellidos;

	private String email;

	private String nombre;

	private String password;

	private String telefono;

	//bi-directional many-to-one association to Pedido
	@OneToMany(mappedBy="tcliente")
	private List<Pedido> tpedidos;

	public Cliente() {
	}

	public String getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
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

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Pedido> getTpedidos() {
		return this.tpedidos;
	}

	public void setTpedidos(List<Pedido> tpedidos) {
		this.tpedidos = tpedidos;
	}

	public Pedido addTpedido(Pedido tpedido) {
		getTpedidos().add(tpedido);
		tpedido.setTcliente(this);

		return tpedido;
	}

	public Pedido removeTpedido(Pedido tpedido) {
		getTpedidos().remove(tpedido);
		tpedido.setTcliente(null);

		return tpedido;
	}

}