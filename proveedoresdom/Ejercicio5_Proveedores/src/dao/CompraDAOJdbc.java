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

import dao.ProductoDAOJdbc.CompraMapper;
import dao.ProveedorDAOJdbc.ProveedorMapper;
import dominio.Compra;
import dominio.Producto;
import dominio.Proveedor;

public class CompraDAOJdbc implements CompraDAOInterface{

private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}
	
	@Override
	public Compra alta(Compra c) {
		try 
		{
			String SQL = "INSERT INTO tcompra(Cantidad,Fecha,Precio,IdProveedor,IdProducto) VALUES (?,?,?,?,?)";
			jdbcTemplate.update(SQL, c.getCantidad(), c.getFecha(), c.getPrecio(), c.getProveedor().getIdProveedor(), c.getProducto().getIdProducto());
			
			SQL = "SELECT * FROM tcompra ORDER BY IdCompra DESC LIMIT 1 ";
			Compra aux = jdbcTemplate.queryForObject(SQL, new CompraMapper() );
			return aux;
			
		} catch ( DataAccessException ex ) {
			return null;
			}
	}

	@Override
	public void baja(int idCompra) {
		String SQL = "DELETE FROM tcompra where IdCompra = ?";
		jdbcTemplate.update(SQL, idCompra);	
	}

	@Override
	public void modificacion(Compra c) {
		String SQL = "UPDATE tcompra SET Cantidad = ?, Fecha=?, Precio= ? WHERE IdCompra = ?";
		jdbcTemplate.update(SQL, c.getCantidad(), c.getFecha(), c.getPrecio(), c.getIdCompra());
	}

	@Override @Transactional (readOnly = true)
	public Compra consulta(int idCompra) {
		String SQL = "SELECT * FROM tcompra WHERE IdCompra = ?";
		Compra compra = jdbcTemplate.queryForObject(SQL,new Object[] { idCompra }, new CompraMapper());
		return compra;
	}

	@Override @Transactional (readOnly = true)
	public List<Compra> consultaAll() {
		String SQL = "SELECT * FROM tcompra";
		List<Compra> todaslasCompras = jdbcTemplate.query(SQL, new CompraMapper());
		return todaslasCompras;
	}

	//Debo de hacer 3 rowmapper y en el final debes de utilizar los dos (es la parte final) con 
	//la sentencia SQL correcta para cada uno de ellos
	
	class CompraMapper implements RowMapper<Compra> {

		public Compra mapRow(ResultSet rs, int rowNum) throws SQLException {
			Compra compra = new Compra();
			Date fechaDate;
			GregorianCalendar fechaGregorian = new GregorianCalendar();
			int idProveedor;
			int idProducto;
			
			compra.setIdCompra(rs.getInt("IdCompra"));
			compra.setCantidad(rs.getInt("Cantidad"));
			fechaGregorian.setTime(fechaDate = rs.getDate("Fecha"));
			compra.setFecha(fechaGregorian);
			idProveedor = rs.getInt("IdProveedor");
			idProducto = rs.getInt("IdProducto");
			
			String SQL = "SELECT * FROM tproveedor WHERE IdCompra = ?";
			Proveedor proveedor = jdbcTemplate.queryForObject(SQL, new Object[] { idProveedor }, new ProveedorMapper());
			compra.setProveedor(proveedor);
			
			SQL = "SELECT * FROM tproducto WHERE IdCompra = ?";
			Producto producto = jdbcTemplate.queryForObject(SQL, new Object[] { idProducto }, new ProductoMapper());
			compra.setProducto(producto);
			
			return compra;
		}
	}
	
	class ProveedorMapper implements RowMapper<Proveedor> {

		public Proveedor mapRow(ResultSet rs, int rowNum) throws SQLException {
			Proveedor proveedor = new Proveedor();
			proveedor.setIdProveedor(rs.getInt("IdProveedor"));
			proveedor.setNombre(rs.getString("Nombre"));
			proveedor.setTelefono(rs.getInt("Telefono"));
			proveedor.setContacto(rs.getString("Contacto"));
			
			return proveedor;
		}
	}
	
	class ProductoMapper implements RowMapper<Producto> {

		public Producto mapRow(ResultSet rs, int rowNum) throws SQLException {
			Producto producto = new Producto();
			producto.setIdProducto(rs.getInt("IdProducto"));
			producto.setNombre(rs.getString("Nombre"));
			producto.setDescripcion(rs.getString("Descripccion"));
			
			return producto;
		}
	}
	
	
}
