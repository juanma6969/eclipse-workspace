package dao;

import java.util.List;

import dominio.Producto;

public interface ProductoDAOInterface {

	public Producto alta(Producto pr);
	public void baja(int idProducto);
	public void modificacion(Producto pr);
	public Producto consulta(int idProducto);
	public List<Producto> consultaAll();
	
}
