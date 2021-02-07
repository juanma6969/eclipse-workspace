package capaModelo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import capaModelo.dao.ProductoDAOSpringJDBC.ProductoMapper;
import capaModelo.daoInterface.ProveedorDAOInterface;
import dominio.Compra;
import dominio.Producto;
import dominio.Proveedor;

@Repository
@Transactional
public class ProveedorDAOSpringJDBC implements ProveedorDAOInterface{
	private JdbcTemplate jdbcTemplate;
	

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	@Override
	public Proveedor altaP(Proveedor p) {
		 try
		 {
		 String SQL = "INSERT INTO tproveedor(Nombre,Telefono,Contacto) VALUES (?,?,?)";
		 jdbcTemplate.update(SQL, p.getNombre(),p.getTelefono(),p.getContacto());
	
	SQL = "SELECT * FROM tproveedor ORDER BY IdProveedor DESC LIMIT 1 ";
		Proveedor aux = jdbcTemplate.queryForObject(SQL, new ProveedorMapper() );
		
		
		
		
		
		return aux;
		 }
		 catch ( DataAccessException ex ) {
			
			 return null; }
	}


	@Override
	public boolean bajaP(int idProveedor) {
		 try
		 { 
			 String	 SQL = "DELETE FROM tlinea  WHERE IdProveedorP = ?";
		 jdbcTemplate.update(SQL, idProveedor); 
	 	 SQL ="DELETE FROM tproveedor WHERE IdProveedor=? ";
		 jdbcTemplate.update(SQL,idProveedor);
		
		
		 return true; 
		
		 }
		 catch ( DataAccessException ex ) { return false; }
		
	}


	@Override
	public boolean modificacionP(Proveedor p) {
		try { 
		String SQL = "UPDATE tproveedor SET  Nombre= ?,Telefono=?,Contacto=?  WHERE IdProveedor = ?";
		 jdbcTemplate.update(SQL,p.getNombre(),p.getTelefono(),p.getContacto(),p.getIdProveedor());
		
		 for(Compra c1 : p.getLineasCompras()) {
			 SQL="UPDATE tlinea SET Cantidad = ?,Fecha = ?, Precio = ? WHERE IdLinea = ? AND IdProveedor = ? ";
			 jdbcTemplate.update(SQL,c1.getCantidad(),c1.getFecha(),c1.getPrecio(),c1.getIdLinea(),c1.getProducto().getIdProducto());
		 }
		 
		 return true;
	 }
	 catch ( DataAccessException ex ) { return false; }
		
	}


	@Override
	public Proveedor consultaP(int idProveedor) {
		String SQL = "SELECT * FROM tproveedor WHERE IdProveedor = ?";
		 Proveedor proveedor =
		 jdbcTemplate.queryForObject(SQL, new Object[] {idProveedor}, new ProveedorMapper());
		 return proveedor;
	}


	@Override
	public List<Proveedor> consultaAllP() {
		String SQL = "SELECT * FROM tproveedor";
		 List<Proveedor> todoslosProveedores = jdbcTemplate.query(SQL,new ProveedorMapper());
		 return todoslosProveedores;
	}
	
	
	class ProveedorMapper implements RowMapper<Proveedor>{

		@Override
		public Proveedor mapRow(ResultSet rs, int rowNum) throws SQLException {
			Proveedor proveedor=new Proveedor();
			proveedor.setIdProveedor(rs.getInt("IdProveedor"));
			proveedor.setNombre(rs.getString("Nombre"));
			proveedor.setTelefono(rs.getString("Telefono"));
			proveedor.setContacto(rs.getString("Contacto"));
			
			String SQL="SELECT * FROM tlinea  WHERE IdProveedorP=?";
			List<Compra> ListaCompras= jdbcTemplate.query(SQL,new Object [] {proveedor.getIdProveedor()},new CompraMapper());
			proveedor.setLineasCompras(ListaCompras);
			
			return proveedor;
		}
		
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
