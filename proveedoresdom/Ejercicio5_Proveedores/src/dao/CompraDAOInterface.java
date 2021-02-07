package dao;

import java.util.List;

import dominio.Compra;

public interface CompraDAOInterface {

	public Compra alta(Compra c);
	public void baja(int idCompra);
	public void modificacion(Compra c);
	public Compra consulta(int idCompra);
	public List<Compra> consultaAll();
	
}
