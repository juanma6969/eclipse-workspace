package pfc.dao;

import pfc.dominio.Cliente;
import pfc.dominio.Servicio;

import java.util.List;



public interface ClienteDAOInterface {
	public Cliente alta(Cliente c);
	public boolean baja(int idCliente);
	public boolean modificacion(Cliente c);
	public Cliente consulta(int idCliente);
	public List<Cliente> consultaAllC();
	
	
}
