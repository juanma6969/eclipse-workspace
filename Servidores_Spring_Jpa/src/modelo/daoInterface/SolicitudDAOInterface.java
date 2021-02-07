package modelo.daoInterface;

import java.util.List;

import dominio.Solicitud;

public interface SolicitudDAOInterface {
	public Solicitud altaSo(Solicitud so);
	public boolean bajaSo(int idSolicitud);
	public boolean modificacionSo(Solicitud so);
	public Solicitud consultaSo(int idSolicitud);
	public List<Solicitud> consultaAllSo();

}
