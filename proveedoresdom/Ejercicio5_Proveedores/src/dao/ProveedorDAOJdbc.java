package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Transactional;


import dominio.Compra;
import dominio.Producto;
import dominio.Proveedor;


public class ProveedorDAOJdbc implements ProveedorDAOInterface{
	
private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}

	@Override
	public Proveedor alta(Proveedor p) {
		try 
		{
			String SQL = "INSERT INTO tproveedor(Nombre,Telefono,Contacto) VALUES (?,?,?)";
			jdbcTemplate.update(SQL, p.getNombre(), p.getTelefono(), p.getContacto());
			
			SQL = "SELECT * FROM tproveedor ORDER BY IdProveedor DESC LIMIT 1 ";
			Proveedor aux = jdbcTemplate.queryForObject(SQL, new ProveedorMapper() );
			return aux;
			
		} catch ( DataAccessException ex ) {
			return null;
			}
	}

	@Override
	public void baja(int idProveedor) {
		String SQL = "DELETE FROM tcompra where IdProveedor = ?";
		jdbcTemplate.update(SQL, idProveedor);	
		SQL = "DELETE FROM tproveedor where IdProveedor = ?";
		jdbcTemplate.update(SQL, idProveedor);	
	}

	@Override
	public void modificacion(Proveedor p) {
		String SQL = "UPDATE tproveedor SET Nombre = ?, Telefono=?, Contacto= ? WHERE IdProveedor = ?";
		jdbcTemplate.update(SQL, p.getNombre(), p.getTelefono(), p.getContacto(), p.getIdProveedor());
		
	}

	@Override @Transactional (readOnly = true)
	public Proveedor consulta(int idProveedor) {
		String SQL = "SELECT * FROM tproveedor WHERE IdProveedor = ?";
		Proveedor proveedor = jdbcTemplate.queryForObject(SQL,new Object[] { idProveedor }, new ProveedorMapper());
		return proveedor;
	}

	@Override @Transactional (readOnly = true)
	public List<Proveedor> consultaAll() {
		String SQL = "SELECT * FROM tproveedor";
		List<Proveedor> todoslosProveedores = jdbcTemplate.query(SQL, new ProveedorMapper());
		return todoslosProveedores;
	}
	
	class ProveedorMapper implements RowMapper<Proveedor> {

		public Proveedor mapRow(ResultSet rs, int rowNum) throws SQLException {
			Proveedor proveedor = new Proveedor();
			proveedor.setIdProveedor(rs.getInt("IdProveedor"));
			proveedor.setNombre(rs.getString("Nombre"));
			proveedor.setTelefono(rs.getInt("Telefeno"));
			proveedor.setContacto(rs.getString("Contacto"));
			
			String SQL = "SELECT * FROM tcompra WHERE IdProveedor = ?";
			List<Compra> compra = jdbcTemplate.query(SQL, new Object [] {proveedor.getIdProveedor()} , new CompraMapper());
			proveedor.setCompras(compra);
			return proveedor;
		}
	}
	
	class CompraMapper implements RowMapper<Compra> {

		public Compra mapRow(ResultSet rs, int rowNum) throws SQLException {

			Compra compra = new Compra();
			Date fechaDate;
			GregorianCalendar fechaGregorian = new GregorianCalendar();
			Proveedor p = new Proveedor();
			Producto pr = new Producto();
			
			compra.setIdCompra(rs.getInt("IdCompra"));
			compra.setCantidad(rs.getInt("Cantidad"));
			fechaGregorian.setTime(fechaDate = rs.getDate("Fecha"));
			compra.setFecha(fechaGregorian);
			compra.setPrecio(rs.getDouble("Precio"));
			p.setIdProveedor(rs.getInt("IdProveedor"));
			compra.setProveedor(p);
			pr.setIdProducto(rs.getInt("IdProducto"));
			compra.setProducto(pr);

			return compra;
		}
	}

}
