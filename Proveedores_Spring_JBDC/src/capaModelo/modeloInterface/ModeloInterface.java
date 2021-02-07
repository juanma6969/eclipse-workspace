package capaModelo.modeloInterface;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import dominio.Compra;
import dominio.Producto;
import dominio.Proveedor;

public interface ModeloInterface {

	public Producto altaPr(Producto pr);
   public Compra altaC(Compra c);
	public Proveedor altaP(Proveedor p);
	
	public boolean bajaPr(int idProducto);
	public boolean bajaC(int idCompra);
	public boolean bajaP(int idProveedor);
	

	
	public boolean modificacionPr(Producto pr );
	public boolean  modificacionC(Compra c);
	public boolean  modificacionP(Proveedor p);
	
	public Producto consultaPr(int idProducto);
	public Compra consultaC(int idLinea);
	public List<Compra> consulta (Calendar cFecha);
	public Proveedor consultaP(int idProveedor);
	
	public List<Producto> consultaAllpR();
   public List<Compra> consultaAllC();
    public List<Proveedor> consultaAllP();
    
    public ArrayList<Compra> consultaResumenCompra(Calendar cFecha);
    
}
