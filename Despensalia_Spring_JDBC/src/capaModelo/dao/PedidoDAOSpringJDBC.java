package capaModelo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import capaModelo.daoInterface.PedidoDAOInterface;
import dominio.Cliente;
import dominio.LineaPedido;
import dominio.Pedido;
import dominio.Producto;

public class PedidoDAOSpringJDBC implements PedidoDAOInterface {

private	JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}

	@Override
	public void alta(Pedido p) {
		Date fRecogidaDate=new Date(p.getfHRecogida().getTimeInMillis());
		Timestamp fhPedidoTs=new Timestamp(p.getfHPedido().getTimeInMillis());
	
		String SQL = "INSERT INTO TPedidos (IdCliente,FHPedido,FRecogida,Importe,Observaciones) VALUES (?,?,?,?,?)";
		jdbcTemplate.update(SQL, p.getCliente().getIdCliente(), fhPedidoTs, fRecogidaDate, p.getImporte(), p.getObservaciones());
		
		SQL = "SELECT MAX(IdPedido) FROM TPedidos";
		int idPedido = jdbcTemplate.queryForObject(SQL, Integer.class);
	
		for (LineaPedido pl : p.getLineasPedido()) {
			SQL = "INSERT INTO TPedidoLineas (IdPedido,IdProducto,Cantidad) values (?,?,?)";
			jdbcTemplate.update(SQL, idPedido, pl.getProducto().getIdProducto(), pl.getCantidad());
		}
	
	}

	@Override
	public void baja(int idPedido) {
		
		String SQL = "DELETE FROM TPedidoLineas where IdPedido = ?";
		jdbcTemplate.update(SQL, idPedido);
		
		SQL = "DELETE FROM TPedidos WHERE IdPedido = ?";
		jdbcTemplate.update(SQL, idPedido);
	}

	@Override
	public void modificacion(Pedido p) {
		String SQL = "UPDATE TPedidos SET Importe=?,Observaciones=? WHERE IdPedido = ?";
		jdbcTemplate.update(SQL, p.getImporte(), p.getObservaciones(),p.getIdPedido());
		
		for (LineaPedido pl : p.getLineasPedido()) {
			SQL = "UPDATE TPedidoLineas SET Cantidad=? where IdPedido=? and IdProducto=?";
			jdbcTemplate.update(SQL,pl.getCantidad(),p.getIdPedido(),pl.getProducto().getIdProducto());
		}

	}

	@Override
	public Pedido consulta(String idCliente, GregorianCalendar fRecogida) {
		try {
			Date fecha = new Date(fRecogida.getTimeInMillis());
			String SQL = "SELECT * FROM TPedidos WHERE IdCliente = ? AND FRecogida = ?";
			Pedido pedido = jdbcTemplate.queryForObject(SQL,new Object[] {idCliente, fecha}, new int[] {java.sql.Types.VARCHAR,java.sql.Types.DATE},new PedidoMapper());

			SQL = "SELECT * FROM TPedidoLineas L,TProductos P WHERE L.IdProducto=P.IdProducto and IdPedido= ?"; 
			ArrayList<LineaPedido> pl = (ArrayList<LineaPedido>) jdbcTemplate.query(SQL, new Object[] {pedido.getIdPedido()}, new LineaMapper());
			pedido.setLineasPedido(pl);		

			return pedido;	
		}
		catch (DataAccessException ex) {return null;}
	}

	@Override
	public ArrayList<Pedido> consulta(GregorianCalendar fecha) {
	    Date fRecogidaDate = new Date(fecha.getTimeInMillis());
				String SQL = "SELECT * FROM TPedidos WHERE FRecogida = ?";
				List<Pedido> pedido = jdbcTemplate.query(SQL, new Object[] {fRecogidaDate}, new PedidoMapper());
				
				for (Pedido p : pedido)
				{
					SQL = "SELECT * FROM TPedidoLineas,TProductos Where TPedidoLineas.IdProducto =TProductos.IdProducto AND IdPedido= ?";
					ArrayList<LineaPedido> pl = (ArrayList<LineaPedido>) jdbcTemplate.query(SQL, new Object[] {p.getIdPedido()},new LineaMapper());
					p.setLineasPedido(pl);				
				}			
				
				return (ArrayList<Pedido>) pedido;
		}
	}
	class PedidoMapper implements RowMapper<Pedido> {
		
		public Pedido mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			Pedido pedido = new Pedido();
			pedido.setIdPedido(rs.getInt("IdPedido"));

			pedido.setImporte(rs.getDouble("Importe"));
			pedido.setObservaciones(rs.getString("Observaciones"));
			
			GregorianCalendar gcP = new GregorianCalendar();
			gcP.setTime(rs.getTimestamp("FHPedido"));
			pedido.setfHPedido(gcP);
			
			GregorianCalendar gcR = new GregorianCalendar();
			gcR.setTime(rs.getDate("FRecogida"));
			pedido.setfHRecogida(gcR);
			
			Cliente cliente =  new Cliente();
			cliente.setIdCliente(rs.getString("IdCliente"));
			pedido.setCliente(cliente);
				
			return pedido;
		}
	}

	class LineaMapper implements RowMapper<LineaPedido> {

		public LineaPedido mapRow(ResultSet rs, int rowNum) throws SQLException {

		LineaPedido pedidoLinea = new LineaPedido();	
			Producto producto = new Producto();
			Pedido pedido = new Pedido();
			
			pedido.setIdPedido(rs.getInt("IdPedido"));
			
			producto.setIdProducto(rs.getInt("IdProducto"));
			producto.setNombre(rs.getString("Nombre"));
			producto.setTipo(rs.getString("Tipo"));
			producto.setDescripcion(rs.getString("Descripcion"));
			producto.setPrecio(rs.getDouble("Precio"));
			producto.setDisponible(rs.getInt("Disponible"));
			
			pedidoLinea.setIdLinea(rs.getInt("IdLinea"));
			pedidoLinea.setProducto(producto);		
			pedidoLinea.setPedido(pedido);
			pedidoLinea.setCantidad(rs.getInt("Cantidad"));

			return pedidoLinea;
		}
	}


