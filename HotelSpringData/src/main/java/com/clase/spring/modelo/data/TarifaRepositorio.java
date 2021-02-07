package com.clase.spring.modelo.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clase.spring.dominio.Tarifa;

public interface TarifaRepositorio  extends JpaRepository<Tarifa,Integer> {

}
