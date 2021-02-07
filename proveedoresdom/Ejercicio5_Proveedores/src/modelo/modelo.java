package modelo;

import java.util.List;

import dao.CompraDAOInterface;
import dao.ProductoDAOInterface;
import dao.ProveedorDAOInterface;
import dominio.Compra;
import dominio.Producto;
import dominio.Proveedor;
import modeloInterface.modeloInterface;

public class modelo implements modeloInterface{

	CompraDAOInterface compras;
	ProductoDAOInterface productos;
	ProveedorDAOInterface proveedores;
	
	@Override
	public Compra alta(Compra c) {
		// TODO Auto-generated method stub
		return compras.alta(c);
	}

	@Override
	public Producto alta(Producto pr) {
		// TODO Auto-generated method stub
		return productos.alta(pr);
	}

	@Override
	public Proveedor alta(Proveedor p) {
		// TODO Auto-generated method stub
		return proveedores.alta(p);
	}

	@Override
	public void bajaC(int idCompra) {
		// TODO Auto-generated method stub
		compras.baja(idCompra);
	}

	@Override
	public void bajaPr(int idProducto) {
		// TODO Auto-generated method stub
		productos.baja(idProducto);
	}

	@Override
	public void bajaP(int idProveedor) {
		// TODO Auto-generated method stub
		proveedores.baja(idProveedor);
	}

	@Override
	public void modificacion(Compra c) {
		// TODO Auto-generated method stub
		compras.modificacion(c);
	}

	@Override
	public void modificacion(Producto pr) {
		// TODO Auto-generated method stub
		productos.modificacion(pr);
	}

	@Override
	public void modificacion(Proveedor p) {
		// TODO Auto-generated method stub
		proveedores.modificacion(p);
	}

	@Override
	public Compra consultaC(int idCompra) {
		// TODO Auto-generated method stub
		return compras.consulta(idCompra);
	}

	@Override
	public Producto consultaPr(int idProducto) {
		// TODO Auto-generated method stub
		return productos.consulta(idProducto);
	}

	@Override
	public Proveedor consultaP(int idProveedor) {
		// TODO Auto-generated method stub
		return proveedores.consulta(idProveedor);
	}

	@Override
	public List<Compra> consultaAllC() {
		// TODO Auto-generated method stub
		return compras.consultaAll();
	}

	@Override
	public List<Producto> consultaAllPr() {
		// TODO Auto-generated method stub
		return productos.consultaAll();
	}

	@Override
	public List<Proveedor> consultaAllP() {
		// TODO Auto-generated method stub
		return proveedores.consultaAll();
	}

	public void setCompras(CompraDAOInterface compras) {
		this.compras = compras;
	}

	public void setProductos(ProductoDAOInterface productos) {
		this.productos = productos;
	}

	public void setProveedores(ProveedorDAOInterface proveedores) {
		this.proveedores = proveedores;
	}
	
}
