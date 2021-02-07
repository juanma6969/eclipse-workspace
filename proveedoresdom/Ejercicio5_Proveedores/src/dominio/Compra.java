package dominio;

import java.util.GregorianCalendar;

public class Compra {

	private int idCompra;
	private int cantidad;
	private GregorianCalendar fecha;
	private double precio;
	private Proveedor proveedor;
	private Producto producto;
	
	public Compra(int cantidad, GregorianCalendar fecha, double precio, Proveedor proveedor,
			Producto producto) {
		this.cantidad = cantidad;
		this.fecha = fecha;
		this.precio = precio;
		this.proveedor = proveedor;
		this.producto = producto;
	}
	
	public Compra() {
		
	}
	
	public int getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(int idCompra) {
		this.idCompra = idCompra;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public GregorianCalendar getFecha() {
		return fecha;
	}

	public void setFecha(GregorianCalendar fecha) {
		this.fecha = fecha;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	@Override
	public String toString() {
		return "Compra [idCompra=" + idCompra + ", cantidad=" + cantidad + ", fecha=" + fecha + ", precio=" + precio
				+ ", proveedor=" + proveedor + ", producto=" + producto + "]";
	}
	
	
}
