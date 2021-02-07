package capaModelo.modelo;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import org.springframework.dao.DataAccessException;

import capaModelo.daoInterface.ClienteDAOInterface;
import capaModelo.daoInterface.PedidoDAOInterface;
import capaModelo.daoInterface.ProductoDAOInterface;
import capaModelo.modeloInterface.ModeloInterface;
import dominio.Cliente;
import dominio.LineaPedido;
import dominio.Pedido;
import dominio.Producto;

public class ModeloSpringJDBC implements ModeloInterface{

	ClienteDAOInterface clientes;
	PedidoDAOInterface pedidos;
	ProductoDAOInterface productos;
	
	@Override
	public boolean alta(Cliente c) {
		try { clientes.alta(c);
		return true;
			}catch (DataAccessException e) {
			return false;	
		}
		
	
	}

	@Override
	public void alta(Pedido p) {
		try { pedidos.alta(p);
		
			}catch (DataAccessException e) {
				
		}
	}

	@Override
	public void baja(int idPedido) {
		pedidos.baja(idPedido);
	}

	@Override
	public void modificacion(Cliente c) {
		clientes.modificacion(c);
	}

	@Override
	public void modificacion(Pedido p) {
		pedidos.modificacion(p);
	}

	@Override
	public Cliente consulta(String idCliente) {
		return clientes.consulta(idCliente);
	}

	@Override
	public Pedido consulta(String idCliente, GregorianCalendar fRecogida) {
		return pedidos.consulta(idCliente, fRecogida);
	}

	@Override
	public ArrayList<Producto> consultaProductos(GregorianCalendar fecha) {
	
		// TODO Auto-generated method stub
return productos.consulta(fecha);
  
	}

	@Override
	public ArrayList<Pedido> consultaPedidos(GregorianCalendar fecha) {
		return pedidos.consulta(fecha);
	}

	@Override
	public ArrayList<Pedido> consultaResumenPedidos(GregorianCalendar fecha) {
	ArrayList<Pedido> allPedidos=this.consultaPedidos(fecha);
	for(Pedido p: allPedidos) {
ArrayList<LineaPedido> pedidosConcantidad=new ArrayList<>();
for(LineaPedido lp : p.getLineasPedido()) {
	if(lp.getCantidad()!=0) {
		pedidosConcantidad.add(lp);
		p.setLineasPedido(pedidosConcantidad);
	}
}
	}
	return allPedidos;
	}

	
	
	
	
	public void setClientes(ClienteDAOInterface clientes) {
		this.clientes = clientes;
	}

	public void setPedidos(PedidoDAOInterface pedidos) {
		this.pedidos = pedidos;
	}

	public void setProductos(ProductoDAOInterface productos) {
		this.productos = productos;
	}
	

}
