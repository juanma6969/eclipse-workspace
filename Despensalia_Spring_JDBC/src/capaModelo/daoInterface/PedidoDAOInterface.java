package capaModelo.daoInterface;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import dominio.Pedido;

public interface PedidoDAOInterface {
	public void alta(Pedido p);
	public void baja(int idPedido);
	public void modificacion(Pedido p);
//	public Pedido consulta(int idPedido);
//	public ArrayList<Pedido> consulta();
	
	// ...
	
    public Pedido consulta(String idCliente, GregorianCalendar fRecogida);
    public ArrayList<Pedido> consulta(GregorianCalendar fecha);

}
