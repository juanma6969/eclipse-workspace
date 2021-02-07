package dominio;

import java.io.Serializable;
import java.util.ArrayList;

public class Componente implements Serializable {

	private static final long serialVersionUID = 1L;
	private int idComponente;
	private String nombre;
	private double peso;
	private ArrayList<Composicion> lComposiciones=new ArrayList<>();
	
	public Componente() {}
	
	public Componente(int idComponente, String nombre, double peso) {
		super();
		this.idComponente = idComponente;
		this.nombre = nombre;
		this.peso = peso;
	}

	public int getIdComponente() {
		return idComponente;
	}

	public void setIdComponente(int idComponente) {
		this.idComponente = idComponente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public ArrayList<Composicion> getlComposiciones() {
		return lComposiciones;
	}

	public void setlComposiciones(ArrayList<Composicion> lComposiciones) {
		this.lComposiciones = lComposiciones;
	}
	
	
	
	
	

}
