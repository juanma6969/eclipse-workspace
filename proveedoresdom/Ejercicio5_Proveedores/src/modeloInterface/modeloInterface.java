package modeloInterface;

import java.util.List;

import dominio.Compra;
import dominio.Producto;
import dominio.Proveedor;

public interface modeloInterface {

	public Compra alta(Compra c);
	public Producto alta(Producto pr);
	public Proveedor alta(Proveedor p);
	
	public void bajaC(int idCompra);
	public void bajaPr(int idProducto);
	public void bajaP(int idProveedor);
	
	public void modificacion(Compra c);
	public void modificacion(Producto pr);
	public void modificacion(Proveedor p);
	
	public Compra consultaC(int idCompra);
	public Producto consultaPr(int idProducto);
	public Proveedor consultaP(int idProveedor);
	
	public List<Compra> consultaAllC();
	public List<Producto> consultaAllPr();
	public List<Proveedor> consultaAllP();
	
}
