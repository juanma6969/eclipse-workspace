package com.clase.spring.modelo.modeloInterface;

import java.util.List;

import com.clase.spring.dominio.Cliente;
import com.clase.spring.dominio.Pedido;

public interface ModeloInterface {
	public boolean alta(Cliente c); 
	public boolean  alta(Pedido p); 
	public void baja(int idPedido); 
	public void modificacion(Cliente c); 
	public void modificacion(Pedido p); 
	public Cliente consulta(String idCliente); 
	public Pedido consulta(int idPedido); 
//	public Pedido consulta(String idCliente, GregorianCalendar fRecogida); 
//	public ArrayList<Producto> consultaProductos(GregorianCalendar fecha); 
	//public ArrayList<Pedido> consultaPedidos(GregorianCalendar fecha); 
//	public ArrayList<Pedido> consultaResumenPedidos(GregorianCalendar fecha);

	public List<Cliente> clientesAll();
	public List<Pedido> pedidosAll();
	
}
