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

public class ProductoDAOJdbc implements ProductoDAOInterface{

private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}
	
	@Override
	public Producto alta(Producto pr) {
		try 
		{
			String SQL = "INSERT INTO tproducto(Nombre,Descripcion) VALUES (?,?)";
			jdbcTemplate.update(SQL, pr.getNombre(), pr.getDescripcion());
			
			SQL = "SELECT * FROM tproducto ORDER BY IdProducto DESC LIMIT 1 ";
			Producto aux = jdbcTemplate.queryForObject(SQL, new ProductoMapper() );
			return aux;
			
		} catch ( DataAccessException ex ) {
			return null;
			}
	}

	@Override
	public void baja(int idProducto) {
		String SQL = "DELETE FROM tcompra where IdProducto = ?";
		jdbcTemplate.update(SQL, idProducto);	
		SQL = "DELETE FROM tproducto where IdProducto = ?";
		jdbcTemplate.update(SQL, idProducto);	
		
	}

	@Override
	public void modificacion(Producto pr) {
		String SQL = "UPDATE tproducto SET Nombre = ?, Descripcion= ? WHERE IdProducto = ?";
		jdbcTemplate.update(SQL, pr.getNombre(), pr.getDescripcion(), pr.getIdProducto());
		
	}

	@Override @Transactional (readOnly = true)
	public Producto consulta(int idProducto) {
		String SQL = "SELECT * FROM tproducto WHERE IdProducto = ?";
		Producto producto = jdbcTemplate.queryForObject(SQL,new Object[] { idProducto }, new ProductoMapper());
		return producto;
	}

	@Override @Transactional (readOnly = true)
	public List<Producto> consultaAll() {
		String SQL = "SELECT * FROM tproducto";
		List<Producto> todoslosProductos = jdbcTemplate.query(SQL, new ProductoMapper());
		return todoslosProductos;
	}

	class ProductoMapper implements RowMapper<Producto> {

		public Producto mapRow(ResultSet rs, int rowNum) throws SQLException {
			Producto producto = new Producto();
			producto.setIdProducto(rs.getInt("IdProducto"));
			producto.setNombre(rs.getString("Nombre"));
			producto.setDescripcion(rs.getString("Descripcion"));
			
			String SQL = "SELECT * FROM tcompra WHERE IdProducto = ?";
			List<Compra> compra = jdbcTemplate.query(SQL, new Object [] {producto.getIdProducto()} , new CompraMapper());
			producto.setCompras(compra);
			return producto;
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
