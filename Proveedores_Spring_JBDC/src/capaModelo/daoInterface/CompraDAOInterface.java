package capaModelo.daoInterface;

import java.util.Calendar;
import java.util.List;

import dominio.Compra;

public interface CompraDAOInterface {
	public Compra altaC (Compra c);
	public boolean bajaC (int  idCompra);
	public boolean modificacionC(Compra c);
	public Compra consultaC(int idCompra);
	public List<Compra> consulta (Calendar cFecha);
	public List<Compra> consultaAllC();
}
