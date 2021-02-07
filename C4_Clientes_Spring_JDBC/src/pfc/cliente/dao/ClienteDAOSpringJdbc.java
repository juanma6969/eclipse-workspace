package pfc.cliente.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pfc.cliente.dominio.Cliente;

@Repository
@Transactional
public class ClienteDAOSpringJdbc implements ClienteDAOInterface {
private JdbcTemplate jdbcTemplate;


	public JdbcTemplate getJdbcTemplate() {
	return jdbcTemplate;
}

public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {	this.jdbcTemplate = jdbcTemplate;}

	@Override
	public boolean alta(Cliente c) {
		 try
		 {
		 String SQL = "INSERT INTO TClientes VALUES (?,?,?)";
		 jdbcTemplate.update(SQL, c.getIdCliente(), c.getPassword(), c.getNombre());
		 }
		 catch ( DataAccessException ex ) { return false; }

		 return true;
	}

	@Override
	public void baja(String idCliente) {
		
		 String SQL = "DELETE FROM TClientes where IdCliente = ?";
		 jdbcTemplate.update(SQL, idCliente); 
	}

	@Override
	public void modificacion(Cliente c) {
		 String SQL = "UPDATE TClientes SET Password = ?, Nombre= ? WHERE IdCliente = ?";
		 jdbcTemplate.update(SQL, c.getPassword(), c.getNombre(), c.getIdCliente());
	}

	@Override
	@Transactional(readOnly=true)
	public Cliente consulta(String idCliente) {
		String SQL = "SELECT * FROM TClientes WHERE IdCliente = ?";
		 Cliente cliente =
		 jdbcTemplate.queryForObject(SQL, new Object[] {idCliente}, new ClienteMapper());
		 return cliente;

	}
	class ClienteMapper implements RowMapper<Cliente>
	{
	 public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException
	 {
	 Cliente cliente = new Cliente();
	cliente.setIdCliente(rs.getString("IdCliente"));
	cliente.setPassword(rs.getString("Password"));
	cliente.setNombre(rs.getString("Nombre"));
	return cliente;
	 }
	}


	@Override
	@Transactional(readOnly=true)
	public List<Cliente> consulta() {
		 String SQL = "SELECT * FROM TClientes";
		 List<Cliente> todoslosClientes = jdbcTemplate.query(SQL,new ClienteMapper());
		 return todoslosClientes;

	}

}
