package com.clase.spring.modelo.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clase.spring.dominio.Habitacion;

public interface HabitacionRepositorio extends JpaRepository<Habitacion,Integer>{

}
