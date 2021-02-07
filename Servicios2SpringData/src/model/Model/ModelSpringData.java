package model.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Data.ServicioSpringData;
import model.DataInterface.ClienteRepositorio;
import model.DataInterface.ServicioRepositorio;

@Service
public class ModelSpringData {
	
	ClienteRepositorio clientes;
	@Autowired
	ServicioSpringData servicios;
	
	public void setClientes(ClienteRepositorio clientes) {
		this.clientes = clientes;
	}

	public void setServicios(ServicioSpringData servicios) {
		this.servicios = servicios;
	}
	public ClienteRepositorio getClientes() {
		return clientes;
	}
	public ServicioRepositorio getServicios() {
		return servicios;
	}
	

}
