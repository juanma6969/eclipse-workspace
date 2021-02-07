package capaModelo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import capaModelo.daoInterface.ClienteDAOInterface;
import dominio.Cliente;
import dominio.Pedido;

@Repository
@Transactional
public class ClienteDAOSpringJDBC implements ClienteDAOInterface {


 private JdbcTemplate jdbcTemplate;
	
 
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
	this.jdbcTemplate = jdbcTemplate;
}

	@Override
	public boolean alta(Cliente u) {
		try {
			String SQL = "INSERT INTO TClientes (IdCliente,Password,Nombre,Apellidos,Telefono,Email) values (?,?,?,?,?,?)";
			jdbcTemplate.update(SQL, u.getIdCliente(), u.getPassword(),u.getNombre(), u.getApellidos(), u.getTelefono(),u.getEmail());			
		}
		catch ( DataAccessException ex ) { return false; }
		
		return true;
	}

	@Override
	public void modificacion(Cliente u) {
		String SQL = "update TClientes set Password = ?,Nombre=?,Apellidos=?,Telefono=?,Email=? where IdCliente = ?";
		jdbcTemplate.update(SQL, u.getPassword(),	u.getNombre(), u.getApellidos(), u.getTelefono(), u.getEmail(), u.getIdCliente());	
	}

	@Override
	public Cliente consulta(String idCliente) {
		try {
			String SQL = "select * from TClientes where IdCliente = ?";
			Cliente cliente = jdbcTemplate.queryForObject(SQL, new Object[] {idCliente}, new ClienteMapper());
			return cliente;			

		}
		catch (DataAccessException ex) {return null;}
	}

	@Override
	public ArrayList<Cliente> consulta() {
		// TODO Auto-generated method stub
		return null;
	}
	class ClienteMapper implements RowMapper<Cliente>{

		@Override
		public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
			Cliente cliente= new Cliente();
			cliente.setIdCliente(rs.getString("IdCliente"));
			cliente.setPassword(rs.getString("Password"));
			cliente.setNombre(rs.getString("Nombre"));
			cliente.setApellidos(rs.getString("Apellidos"));
			cliente.setTelefono(rs.getString("Telefono"));
			cliente.setEmail(rs.getString("Email"));
		
			String SQL = "SELECT * FROM TPedidos WHERE IdCliente = ?";

		ArrayList<Pedido> lP=(ArrayList<Pedido>)jdbcTemplate.query(SQL,new Object [] {cliente.getIdCliente()},new PedidoMapper());
		cliente.setlPedidos(lP);
			return cliente;
		}
		
	}
	
	class PedidoMapper implements RowMapper<Pedido>{

		@Override
		public Pedido mapRow(ResultSet rs, int rowNum) throws SQLException {
			Pedido pedido=new Pedido();
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
	
	
	
	
}

