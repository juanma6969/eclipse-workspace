package capaModelo.daoInterface;

import java.util.List;


import dominio.Proveedor;

public interface ProveedorDAOInterface {
	
	public Proveedor altaP(Proveedor p);
	public boolean bajaP(int idProveedor);
	public boolean modificacionP(Proveedor p);
	public Proveedor consultaP(int idProveedor);
	public List<Proveedor> consultaAllP();
}
