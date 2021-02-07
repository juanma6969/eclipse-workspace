package pfc.modelo;

import java.util.List;


import pfc.dominio.Clientes;



public interface ClienteDAOInterface {
	public boolean alta(Clientes c);
	public  void baja(String idCliente);
	public void modificacion(Clientes c);
	public Clientes consulta(String idCliente);
	public List<Clientes> consulta();
}
