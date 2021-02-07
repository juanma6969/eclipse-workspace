package com.clase.spring.modelo.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clase.spring.dominio.TipoServicio;

public interface TipoServicioRepositorio  extends JpaRepository<TipoServicio,String> {

}
