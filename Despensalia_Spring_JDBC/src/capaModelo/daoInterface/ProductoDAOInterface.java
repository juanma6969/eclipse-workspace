package capaModelo.daoInterface;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import dominio.Producto;

public interface ProductoDAOInterface {
	public static final int DOM = 1;
	public static final int LUN = 2;
	public static final int MAR = 3;
	public static final int MIE = 4;
	public static final int JUE = 5;
	public static final int VIE = 6;
	public static final int SAB = 7;
	public static final int ALL = 0;
	
	
	public ArrayList<Producto> consulta(GregorianCalendar fecha);
    
}
