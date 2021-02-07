package dao;

import java.util.List;

import dominio.Proveedor;

public interface ProveedorDAOInterface {

	public Proveedor alta(Proveedor p);
	public void baja(int idProveedor);
	public void modificacion(Proveedor p);
	public Proveedor consulta(int idProveedor);
	public List<Proveedor> consultaAll();
	
}
