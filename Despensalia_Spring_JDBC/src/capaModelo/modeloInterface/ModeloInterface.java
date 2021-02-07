package capaModelo.modeloInterface;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import dominio.Cliente;
import dominio.Pedido;
import dominio.Producto;

public interface ModeloInterface {
	
	public boolean alta(Cliente c); 
	  public void    alta(Pedido p);   
	  
	  public void baja(int idPedido); 
	  
	  public void modificacion(Cliente c);
	  public void modificacion(Pedido p);  
	  
	  public Cliente consulta(String idCliente); 
	  public Pedido  consulta(String idCliente, GregorianCalendar fRecogida);   
	  
	  public ArrayList<Producto> consultaProductos(GregorianCalendar fecha); 
	  public ArrayList<Pedido>   consultaPedidos(GregorianCalendar fecha); 
	  public ArrayList<Pedido>   consultaResumenPedidos(GregorianCalendar fecha);
}
