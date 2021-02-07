package capaModelo.daoInterface;

import java.util.ArrayList;

import dominio.Cliente;

public interface ClienteDAOInterface {
	
	public boolean alta(Cliente c);
//	public void baja(String idCliente);
	public void modificacion(Cliente c);
	public Cliente consulta(String idCliente);
	public ArrayList<Cliente> consulta();
}
