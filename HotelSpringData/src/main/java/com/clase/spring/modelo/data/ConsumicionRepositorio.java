package com.clase.spring.modelo.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clase.spring.dominio.Consumicion;

public interface ConsumicionRepositorio extends JpaRepository<Consumicion,Integer> {

}
