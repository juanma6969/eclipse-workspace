package pfc.dao;

import java.util.List;

import pfc.dominio.Servicio;

public interface ServicioDAOInterface {
	
		public Servicio alta(Servicio s);
		public boolean baja(int idServicio);
		public boolean  modificacion(Servicio s);
		public Servicio consulta(int idServicio);
		public List<Servicio> consultaAll();
	

}
