package capaModelo.dao;

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

import capaModelo.daoInterface.ProductoDAOInterface;
import dominio.Compra;
import dominio.Producto;
import dominio.Proveedor;


@Repository
@Transactional
public class ProductoDAOSpringJDBC implements ProductoDAOInterface {
	private JdbcTemplate jdbcTemplate;
	
	public ProductoDAOSpringJDBC() {

	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Producto altaPr(Producto p) {
		 try
		 {
			 
			 
			 
			 
			 
		 String SQL = "INSERT INTO tproducto(Nombre,Descripcion) VALUES (?,?);";
		 jdbcTemplate.update(SQL, p.getNombre(),p.getDescripcion());
	
	SQL = "SELECT * FROM tproducto ORDER BY IdProducto DESC LIMIT 1 ";
		Producto aux = jdbcTemplate.queryForObject(SQL, new ProductoMapper() );
			
		
		
		
		
		
		 return aux;
		 }
		 catch ( DataAccessException ex ) {
			
			 return null; }
	}

	@Override
	public boolean bajaPr(int idProducto) {
		 try
		 { 
		String	 SQL = "DELETE FROM tlinea  WHERE IdProductoPr = ?";
			 jdbcTemplate.update(SQL, idProducto); 
			 SQL ="DELETE FROM tproducto WHERE IdProducto=? ";
		 jdbcTemplate.update(SQL,idProducto);
		
		
		 return true; 
		
		 }
		 catch ( DataAccessException ex ) { return false; }
		
	}

	@Override
	public boolean modificacionPr(Producto p) {
		 try
		 {
		 String SQL = "UPDATE tproducto SET  Nombre= ?,Descripcion=?  WHERE IdProducto = ?";
		 jdbcTemplate.update(SQL,p.getNombre(),p.getDescripcion(),p.getIdProducto());
		
		 for(Compra c1 : p.getLineasCompras()) {
			 SQL="UPDATE tlinea SET Cantidad = ?,Fecha = ?, Precio = ? WHERE IdLinea = ? AND IdProducto = ? ";
			 jdbcTemplate.update(SQL,c1.getCantidad(),c1.getFecha(),c1.getPrecio(),c1.getIdLinea(),c1.getProducto().getIdProducto());
		 }
		 
		 
		 
		 return true;
	 }
	 catch ( DataAccessException ex ) { return false; }
		
	}

	@Override
	@Transactional(readOnly=true)
	public Producto consultaPr(int idProducto) {
		String SQL = "SELECT * FROM tproducto WHERE IdProducto = ?";
		
		
		
		Producto producto =
		 jdbcTemplate.queryForObject(SQL, new Object[] {idProducto}, new ProductoMapper());
		SQL="SELECT * FROM tlinea WHERE IdProductoPr= ? ";
		ArrayList<Compra> todasCompras=(ArrayList<Compra>)jdbcTemplate.query(SQL, new Object[] {
				idProducto
		}, new CompraMapper());
		producto.setLineasCompras(todasCompras);
		return producto;
	}

	@Override
	@Transactional(readOnly=true)
	public List<Producto> consultaAllPr() {
		String SQL = "SELECT * FROM tproducto";
		 List<Producto> todoslosProductos = jdbcTemplate.query(SQL,new ProductoMapper());
		for(Producto p1 : todoslosProductos) {
			SQL="SELECT * FROM tlinea WHERE IdProductoPr= ? ";
			ArrayList<Compra> todasCompras=(ArrayList<Compra>)jdbcTemplate.query(SQL, new Object[] {
					p1.getIdProducto()
			}, new CompraMapper());
			p1.setLineasCompras(todasCompras);
		}

		 
		 return todoslosProductos;
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
 



// Compra Mapper
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
