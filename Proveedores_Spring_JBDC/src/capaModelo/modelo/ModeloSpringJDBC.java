package capaModelo.modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import capaModelo.daoInterface.CompraDAOInterface;
import capaModelo.daoInterface.ProductoDAOInterface;
import capaModelo.daoInterface.ProveedorDAOInterface;
import capaModelo.modeloInterface.ModeloInterface;
import dominio.Compra;
import dominio.Producto;
import dominio.Proveedor;

public class ModeloSpringJDBC implements ModeloInterface{
ProductoDAOInterface productos;
ProveedorDAOInterface proveedores;
CompraDAOInterface compras;
	@Override
	public Producto altaPr(Producto pr) {
		
		return productos.altaPr(pr);
	}

	@Override
	public Proveedor altaP(Proveedor p) {
		// TODO Auto-generated method stub
		return proveedores.altaP(p);
	}

	@Override
	public boolean bajaPr(int idProducto) {
		
		return productos.bajaPr(idProducto);
	}

	@Override
	public boolean bajaP(int idProveedor) {
		// TODO Auto-generated method stub
		return proveedores.bajaP(idProveedor);
	}

	@Override
	public boolean modificacionPr(Producto pr) {
		// TODO Auto-generated method stub
		return productos.modificacionPr(pr);
	}

	@Override
	public boolean modificacionP(Proveedor p) {
		// TODO Auto-generated method stub
		return proveedores.modificacionP(p);
	}

	@Override
	public Producto consultaPr(int idProducto) {
		// TODO Aut-generated method stub
		return productos.consultaPr(idProducto);
	}

	@Override
	public Proveedor consultaP(int idProveedor) {
		// TODO Auto-generated method stub
		return proveedores.consultaP(idProveedor);
	}

	@Override
	public List<Producto> consultaAllpR() {
		// TODO Auto-generated method stub
		return productos.consultaAllPr();
	}

	@Override
	public List<Proveedor> consultaAllP() {
		// TODO Auto-generated method stub
		return proveedores.consultaAllP();
	}
	@Override
	public Compra altaC(Compra c) {
		// TODO Auto-generated method stub
		return compras.altaC(c);
	}

	@Override
	public boolean bajaC(int idCompra) {
		// TODO Auto-generated method stub
		return compras.bajaC(idCompra);
	}

	@Override
	public Compra consultaC(int idLinea) {
		// TODO Auto-generated method stub
		return compras.consultaC(idLinea);
	}

	
	
	@Override
	public boolean modificacionC(Compra c) {
		return compras.modificacionC(c);
	}
@Override
	public List<Compra> consultaAllC() {
		return compras.consultaAllC();
	
	}
	
@Override
	public List<Compra> consulta(Calendar cFecha) {
		// TODO Auto-generated method stub
		return compras.consulta(cFecha);
	
	}




public ArrayList<Compra> consultaResumenCompra(Calendar cFecha){
	ArrayList<Compra> todasCompras=(ArrayList<Compra>) this.consulta(cFecha);
	ArrayList<Compra > lineasCompra=new ArrayList<Compra>();
	
	for(Compra c1 : todasCompras) {
		if(c1.getCantidad()!=0) {
		lineasCompra.add(c1);
	}
			
		 }
		return lineasCompra;
	
	
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
