package pfc.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import pfc.dominio.Cliente;
import pfc.dominio.Servicio;

@Repository
@Transactional
public class ClienteDAOSpringJdbc implements ClienteDAOInterface {
	private JdbcTemplate jdbcTemplate;



	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {	
		this.jdbcTemplate = jdbcTemplate;}
	
	public ClienteDAOSpringJdbc() {}
	
	
	
	@Override
	public Cliente alta(Cliente c) {
	
		
			 try
			 {
			 String SQL = "INSERT INTO tclientes2(Provincia,Email,Nombre) VALUES (?,?,?);";
			 jdbcTemplate.update(SQL, c.getProvincia(),c.getEmail(), c.getNombre());
		
		SQL = "SELECT * FROM tclientes2 ORDER BY IdCliente DESC LIMIT 1 ";
			Cliente aux = jdbcTemplate.queryForObject(SQL, new ClienteMapper() );
				
			 return aux;
			 }
			 catch ( DataAccessException ex ) {
				 System.out.println("Error acceso");
				 return null; }

			
	}

	@Override
	public boolean baja(int idCliente) {

		 try
		 { 
		 String 	 SQL ="DELETE FROM tservicios WHERE IdClienteC=? ";
		 jdbcTemplate.update(SQL,idCliente);
		SQL = "DELETE FROM tclientes2  WHERE IdCliente = ?";
		 jdbcTemplate.update(SQL, idCliente); 
		
		 return true; 
		
		 }
		 catch ( DataAccessException ex ) { return false; }
		
		
	}

	@Override
	public boolean modificacion(Cliente c) {
		 try
		 {
		 String SQL = "UPDATE TClientes2 SET Provincia = ?,Email=?, Nombre= ? WHERE IdCliente = ?";
		 jdbcTemplate.update(SQL, c.getProvincia(),c.getEmail(), c.getNombre(), c.getIdCliente());
		return true;
	 }
	 catch ( DataAccessException ex ) { return false; }
		
	}

	@Override
	public Cliente consulta(int idCliente) {
		
		String SQL = "SELECT * FROM tclientes2 WHERE IdCliente = ?";
		 Cliente cliente =
		 jdbcTemplate.queryForObject(SQL, new Object[] {idCliente}, new ClienteMapper());
		 return cliente;
	}
	
	class ClienteMapper implements RowMapper<Cliente>
	{
	 public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException
	 {
	 Cliente cliente = new Cliente();
	cliente.setIdCliente(rs.getInt("IdCliente"));
	cliente.setProvincia(rs.getString("Provincia"));
	cliente.setEmail(rs.getString("Email"));
	cliente.setNombre(rs.getString("Nombre"));
	
	
	String SQL="SELECT * FROM  tservicios WHERE IdClienteC=?";
	List<Servicio> Servicio=
		 jdbcTemplate.query(SQL, new Object[]{ cliente.getIdCliente()},new ServicioMapper());
	
	cliente.setServicios(Servicio);
	return cliente;
	 }
	}
	
	class ServicioMapper implements RowMapper<Servicio>
	{
	 public Servicio mapRow(ResultSet rs, int rowNum) throws SQLException
	 {
		 Servicio servicio = new Servicio();
			Date fechaDate;
			GregorianCalendar fechaGregorian = new GregorianCalendar();
			Cliente c = new Cliente();
			
			servicio.setIdServicio(rs.getInt("IdServicio"));
			servicio.setDescripcion(rs.getString("Descripcion"));
			fechaGregorian.setTime(fechaDate = rs.getDate("Fecha"));
			servicio.setFecha(fechaGregorian);
			servicio.setImporte(rs.getDouble("Importe"));
			c.setIdCliente(rs.getInt("IdClienteC"));
			servicio.setCliente(c);

			return servicio;
	 }
	}
	
	

	@Override
	public List<Cliente> consultaAllC() {
		 String SQL = "SELECT * FROM TClientes2";
		 List<Cliente> todoslosClientes = jdbcTemplate.query(SQL,new ClienteMapper());
		 return todoslosClientes;

	}

	

}
