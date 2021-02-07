package com.clase.spring.modelo.modeloDAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.clase.spring.dominio.Cliente;
import com.clase.spring.dominio.Pedido;
import com.clase.spring.modelo.data.ClienteRepositorio;
import com.clase.spring.modelo.data.PedidoRepositorio;
import com.clase.spring.modelo.data.ProductoRepositorio;
import com.clase.spring.modelo.modeloInterface.ModeloInterface;

@Service
public class ModeloDao implements ModeloInterface {

	//@Autowired
	private ClienteRepositorio clienteRepositorio;
	//@Autowired
	private PedidoRepositorio pedidoRepositorio;
	//@Autowired
	private ProductoRepositorio productoRepositorio;

	


	public ClienteRepositorio getClienteRepositorio() {
		return clienteRepositorio;
	}



	public void setClienteRepositorio(ClienteRepositorio clienteRepositorio) {
		this.clienteRepositorio = clienteRepositorio;
	}



	public PedidoRepositorio getPedidoRepositorio() {
		return pedidoRepositorio;
	}



	public void setPedidoRepositorio(PedidoRepositorio pedidoRepositorio) {
		this.pedidoRepositorio = pedidoRepositorio;
	}



	public ProductoRepositorio getProductoRepositorio() {
		return productoRepositorio;
	}



	public void setProductoRepositorio(ProductoRepositorio productoRepositorio) {
		this.productoRepositorio = productoRepositorio;
	}



	@Override
	public boolean alta(Cliente c) {
		
		return this.clienteRepositorio.save(c)!=null;
	}

	

	@Override
	public void modificacion(Cliente c) {
		this.clienteRepositorio.save(c);		
	}

	@Override
	public Cliente consulta(String idCliente) {
		return this.clienteRepositorio.findOne(idCliente);
		
	}

	
	@Override
	public boolean alta(Pedido p) {
		return this.pedidoRepositorio.save(p) !=null;
		
	}

	

	@Override
	public void modificacion(Pedido p) {
		this.pedidoRepositorio.save(p);
		
	}

	
/*
	@Override
	public Pedido consulta(String idCliente, GregorianCalendar fRecogida) {
		Cliente cliente=this.consulta(idCliente);
		return this.pedidoRepositorio.findBytclienteAndfHRecogida(cliente, fRecogida);
	}

	@Override
	public ArrayList<Pedido> consultaPedidos(GregorianCalendar fecha) {
		return this.pedidoRepositorio.findByfHRecogida(fecha);
	}

	@Override
	public ArrayList<Pedido> consultaResumenPedidos(GregorianCalendar fecha) {
		ArrayList<Pedido> todosPedidos=this.pedidoRepositorio.findByfHRecogida(fecha);
		for(Pedido p: todosPedidos) {
			ArrayList<PedidoLinea> lineasConCantidad=new ArrayList<PedidoLinea>();
			for(PedidoLinea l:p.getLineasPedido()) {
				if(l.getCantidad()>0)lineasConCantidad.add(l);
			}p.setLineasPedido(lineasConCantidad);
		}
		return todosPedidos;
	}

	*/


/*	@Override
	public ArrayList<Producto> consultaProductos(GregorianCalendar fecha) {
	
		return this.productoRepositorio.findBydisponible(ProductoRepositorio.ALL,fecha.get(GregorianCalendar.DAY_OF_WEEK));
	}
*/

	@Override
	public void baja(int idPedido) {
		this.pedidoRepositorio.delete(idPedido);
		
	}


	@Override
	public Pedido consulta(int idPedido) {
		return this.pedidoRepositorio.findOne(idPedido);
	}



	@Override
	public List<Cliente> clientesAll() {
		// TODO Auto-generated method stub
		return (List<Cliente>)clienteRepositorio.findAll();
	}



	@Override
	public List<Pedido> pedidosAll() {
		// TODO Auto-generated method stub
		return (List<Pedido>)pedidoRepositorio.findAll();
	}


	
}
