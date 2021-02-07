package pfc.cliente.dao;

import java.util.List;

import pfc.cliente.dominio.Cliente;



public interface ClienteDAOInterface {
	public boolean alta(Cliente c);
	public void baja(String idCliente);
	public void modificacion(Cliente c);
	public Cliente consulta(String idCliente);
	public List<Cliente> consulta();
}
