package capaModelo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import capaModelo.dao.ProductoDAOSpringJDBC.CompraMapper;
import capaModelo.dao.ProductoDAOSpringJDBC.ProductoMapper;
import capaModelo.dao.ProveedorDAOSpringJDBC.ProveedorMapper;
import capaModelo.daoInterface.CompraDAOInterface;
import dominio.Compra;
import dominio.Producto;
import dominio.Proveedor;

@Repository
@Transactional
public class CompraDAOSpringJDBC  implements CompraDAOInterface{
 private JdbcTemplate jdbcTemplate;


	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
	this.jdbcTemplate = jdbcTemplate;
}

	@Override
	public Compra altaC(Compra c) {
		try {
		 String SQL = "INSERT INTO tlinea(Cantidad,Fecha,Precio,IdProductoPr,IdProveedorP) VALUES (?,?,?,?,?);";
		jdbcTemplate.update(SQL, c.getCantidad(),c.getFecha(),c.getPrecio(),c.getProducto().getIdProducto(),c.getProveedor().getIdProveedor());
		SQL = "SELECT * FROM tlinea ORDER BY IdLinea DESC LIMIT 1 ";
		Compra aux = jdbcTemplate.queryForObject(SQL, new CompraMapper() );
			return aux;
		}catch(DataAccessException e) {return null;}
	}

	@Override
	public boolean bajaC(int idCompra) {
		 try
		 { 
		
	String SQL = "DELETE FROM tlinea  WHERE IdLinea = ?";
		 jdbcTemplate.update(SQL, idCompra); 
		
		 return true; 
		
		 }
		 catch ( DataAccessException ex ) { 
			 ex.printStackTrace();
			 return false; }
		
	}

	@Override
	public boolean modificacionC(Compra c) {
		try
		 {
		 String SQL = "UPDATE tlinea SET  Cantidad= ?,Fecha=?,Precio=? WHERE IdLinea=? ";
		 jdbcTemplate.update(SQL,c.getCantidad(),c.getFecha(),c.getPrecio(),c.getIdLinea());
		return true;
	 }
	 catch ( DataAccessException ex ) { return false; }
	}

	@Override
	@Transactional(readOnly=true)
	public Compra consultaC(int idCompra) {
		String SQL = "SELECT * FROM tlinea WHERE IdLinea = ?";
		 Compra compra=
		 jdbcTemplate.queryForObject(SQL, new Object[] {idCompra}, new CompraMapper());
		 return compra;
	}

	@Override
	@Transactional(readOnly=true)
	public List<Compra> consultaAllC() {
		String SQL = "SELECT * FROM tlinea";
		 List<Compra> todaslasCompras = jdbcTemplate.query(SQL,new CompraMapper());
		 return todaslasCompras;
	}
	
	
	
	class ProveedorMapper implements RowMapper<Proveedor>{

		@Override
		public Proveedor mapRow(ResultSet rs, int rowNum) throws SQLException {
			Proveedor proveedor=new Proveedor();
			proveedor.setIdProveedor(rs.getInt("IdProveedor"));
			proveedor.setNombre(rs.getNString("Nombre"));
			proveedor.setTelefono(rs.getString("Telefono"));
			proveedor.setContacto(rs.getString("Contacto"));
			
			String SQL="SELECT * FROM tlinea WHERE IdProveedorP=?";
			List<Compra> ListaCompras= jdbcTemplate.query(SQL,new Object [] {proveedor.getIdProveedor()},new CompraMapper());
			proveedor.setLineasCompras(ListaCompras);
			
			return proveedor;
		}
		
	}
	class ProductoMapper implements RowMapper<Producto>{

		@Override
		public Producto mapRow(ResultSet rs, int rowNum) throws SQLException {
			Producto producto=new Producto();
			producto.setIdProducto(rs.getInt("IdProducto"));
			producto.setNombre(rs.getNString("Nombre"));
			producto.setDescripcion(rs.getString("Descripcion"));
			
			String SQL="SELECT * FROM tlinea WHERE IdProductoPr=?";
			List<Compra> Compra= jdbcTemplate.query(SQL,new Object [] {producto.getIdProducto()},new CompraMapper());
			producto.setLineasCompras(Compra);
			
			return producto;
		}
		
	}
	@Override
	public List<Compra> consulta(Calendar cFecha) {
		String SQL ="SELECT * FROM tlinea WHERE  Fecha=?";
		ArrayList<Compra> comprasPorFecha=(ArrayList<Compra>) jdbcTemplate.query(SQL, new Object[] {cFecha.getTime()}, new CompraMapper());
		return comprasPorFecha;
	}
	
	class CompraMapper implements RowMapper<Compra>{

		@Override
		public Compra mapRow(ResultSet rs, int rowNum) throws SQLException {
			Compra lineaCompra=new Compra();
			Producto producto=new Producto();
			Proveedor proveedor=new Proveedor();
		
			lineaCompra.setIdLinea(rs.getInt("IdLinea"));
			lineaCompra.setCantidad(rs.getInt("Cantidad"));
			lineaCompra.setFecha(new GregorianCalendar(rs.getDate("Fecha").getYear(),rs.getDate("Fecha").getMonth(),rs.getDate("Fecha").getDay()));
			lineaCompra.setPrecio(rs.getDouble("Precio"));
			
			producto.setIdProducto(rs.getInt("IdProductoPr"));
			lineaCompra.setProducto(producto);
			
			proveedor.setIdProveedor(rs.getInt("IdProveedorP"));
			lineaCompra.setProveedor(proveedor);
			return lineaCompra;
		}
		
	}

	
}
