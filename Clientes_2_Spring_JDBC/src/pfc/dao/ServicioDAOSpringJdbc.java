package pfc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
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
public class ServicioDAOSpringJdbc implements ServicioDAOInterface {
	private JdbcTemplate jdbcTemplate;
	
	public ServicioDAOSpringJdbc() {

	}

	public JdbcTemplate getJdbcTemplate() {
	return jdbcTemplate;
}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {	this.jdbcTemplate = jdbcTemplate;}
	
	
	@Override
	public Servicio alta(Servicio s) {
		 try
		 {
			 
		 String SQL = "INSERT INTO tservicios(Descripcion,Fecha,Importe,IdClienteC) VALUES (?,?,?,?)";
		 jdbcTemplate.update(SQL, s.getDescripcion(),s.getFecha(), s.getImporte(),s.getCliente().getIdCliente());
		 SQL ="SELECT * FROM tservicios ORDER BY IdServicio DESC LIMIT 1";
		Servicio aux= jdbcTemplate.queryForObject(SQL, new ServicioMapper());
		
		return aux;
		 }
		 catch ( DataAccessException ex ) {
			 
			 return null; }

	
	}

	@Override
	public boolean baja(int idServicio) {
		 try
		 {
		 String SQL = "DELETE FROM tservicios WHERE IdServicio = ?";
		 jdbcTemplate.update(SQL, idServicio);
		
		
			return true;
		 }
		 catch ( DataAccessException ex ) {return false; }
	}

	@Override
	public boolean modificacion(Servicio s) {
		 try
		 {
		 String SQL = "UPDATE tservicios SET Descripcion = ?,Fecha=?, Importe= ? WHERE IdServicio = ?";
		 jdbcTemplate.update(SQL, s.getDescripcion(),s.getFecha(), s.getImporte(), s.getIdServicio());
		 return true;
		 }
		 catch ( DataAccessException ex ) {return false; }
		 }

	@Override
	public Servicio consulta(int idServicio) {
		
		String SQL = "SELECT * FROM tservicios WHERE IdServicio = ?";
		 Servicio servicio =
		 jdbcTemplate.queryForObject(SQL, new Object[] { idServicio }, new ServicioMapper());
		 return servicio;
	}

	class ServicioMapper implements RowMapper<Servicio>
	{
	 public Servicio mapRow(ResultSet rs, int rowNum) throws SQLException
	 {
		 int idCliente;
	 Servicio servicio = new Servicio();
	servicio.setIdServicio(rs.getInt("IdServicio"));
	servicio.setDescripcion(rs.getString("Descripcion"));
	servicio.setFecha(new GregorianCalendar(rs.getDate("Fecha").getYear(),rs.getDate("Fecha").getMonth(),rs.getDate("Fecha").getDay()));
	servicio.setImporte(rs.getDouble("Importe"));

	idCliente=rs.getInt("IdClienteC");
	String SQL="SELECT * FROM tclientes2 WHERE IdCliente=?";
	
	Cliente c = jdbcTemplate.queryForObject(SQL, new Object[] { idCliente }, new ClienteMapper());
	servicio.setCliente(c);
	
	return servicio;
	 }
	}
	
	
	class ClienteMapper implements RowMapper<Cliente>  {  
		public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException    
		{         
			Cliente cliente = new Cliente();  
			cliente.setIdCliente(rs.getInt("IdCliente"));
			cliente.setProvincia(rs.getString("Provincia"));
			cliente.setEmail(rs.getString("Email"));
			cliente.setNombre(rs.getString("Nombre"));
			return cliente;   
			} 
		} 

	@Override
	public List<Servicio> consultaAll() {
		String sql="SELECT * FROM  tservicios";
		List<Servicio> AllServicios= jdbcTemplate.query(sql, new ServicioMapper());
		return AllServicios;
	}

}
