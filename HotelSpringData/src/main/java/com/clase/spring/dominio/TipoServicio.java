package com.clase.spring.dominio;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="ttservicio")
@NamedQuery(name="Ttservicio.findAll", query="SELECT t FROM Ttservicio t")
public class TipoServicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String idTServicio;

	private String descripcion;

	//bi-directional many-to-one association to Tservicio
	@OneToMany(mappedBy="tservicio", fetch=FetchType.EAGER)
	private List<Servicio> lservicios;

	public TipoServicio() {
	}

	public String getIdTServicio() {
		return this.idTServicio;
	}

	public void setIdTServicio(String idTServicio) {
		this.idTServicio = idTServicio;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Servicio> getTservicios() {
		return this.lservicios;
	}

	public void setTservicios(List<Servicio> lservicios) {
		this.lservicios = lservicios;
	}
}

	