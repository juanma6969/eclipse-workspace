package capaModelo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import capaModelo.daoInterface.ProductoDAOInterface;
import dominio.Producto;

public class ProductoDAOSpringJDBC  implements ProductoDAOInterface{
	private JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}
	
	public ArrayList<Producto> consulta(GregorianCalendar fecha) {
		int diaS=fecha.get(Calendar.DAY_OF_WEEK);
		String SQL = "SELECT * FROM tproductos WHERE Disponible = ? OR Disponible = ?";
		ArrayList<Producto> todosProductosDispo = (ArrayList<Producto>) jdbcTemplate.query(SQL, new Object[] {diaS, ProductoDAOInterface.ALL}, new ProductoMapper());
	return todosProductosDispo;
	}

}
class ProductoMapper implements RowMapper<Producto> {
	
	public Producto mapRow(ResultSet rs, int rowNum) throws SQLException {
		Producto producto = new Producto();
		producto.setIdProducto(rs.getInt("IdProducto"));
		producto.setNombre(rs.getString("Nombre"));
		producto.setTipo(rs.getString("Tipo"));
		producto.setDescripcion(rs.getString("Descripcion"));
		producto.setPrecio(rs.getDouble("Precio"));
		producto.setDisponible(rs.getInt("Disponible"));
		return producto;
	}
}
