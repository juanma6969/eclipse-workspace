package com.clase.spring.modelo.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clase.spring.dominio.Temporada;

public interface TemporadaRepositorio  extends JpaRepository<Temporada,Integer> {

}
