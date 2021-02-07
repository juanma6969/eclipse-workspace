package navegacion;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
@SuppressWarnings("deprecation")
@ManagedBean
@ViewScoped


public class mibean {
	//Propiedades
private String mimensaje;
//Constructor 
public  mibean() {
	
}


//metodo GET para acceder
public String getMensaje() {
	return mimensaje;
	
}
//metodo Set para escribir 
public void setMensaje(String mimensaje) {
	this.mimensaje=mimensaje;
	
}
public String accion() {
	mimensaje="Mensaje nulo";
	return null;
}

}
