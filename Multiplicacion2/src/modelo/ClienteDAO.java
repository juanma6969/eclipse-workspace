package modelo;
import java.util.ArrayList;
import java.util.Arrays;
import Dominio.*;

public class ClienteDAO {
	
	//Crear Arraylist de clientes 
	private ArrayList<Clientes> arrayClientes;
	//Constructor
	//Se crea una  variable ampliable del objetos  clientes 
	public ClienteDAO(Clientes...pclientes) {
		//en el array de clientes que recibe se convierte en una lista con el  metodo asList y se introducen en la entrada arrayClientes
	  this.arrayClientes= new ArrayList<Clientes>(Arrays.asList(pclientes));
	  
	}
	//Metodo
	
	public Clientes consulta(int pidCliente) {
		//Aqui con un for each recorre todo el arraylist de arrayClientes
		for( Clientes c : arrayClientes) {
			//solicita su id y lo compara con el que sera introducido en el parametro idcliente y si 
			if(c.getIdCliente()==pidCliente) {
				return c;
			}
		}
		return null;
		
	}
	
	
	
	//Cliente
	
	//ID
	//NOMBRE
	//Direccion
	
}
