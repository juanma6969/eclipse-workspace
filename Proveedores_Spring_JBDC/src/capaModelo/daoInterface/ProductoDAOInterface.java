package capaModelo.daoInterface;

import java.util.List;

import dominio.Producto;


public interface ProductoDAOInterface {
	public Producto altaPr(Producto p);
	public boolean bajaPr(int idProducto);
	public boolean modificacionPr(Producto p);
	public Producto consultaPr(int idProducto);
	public List<Producto> consultaAllPr();
}
