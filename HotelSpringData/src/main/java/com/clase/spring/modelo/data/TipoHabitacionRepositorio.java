package com.clase.spring.modelo.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clase.spring.dominio.TipoHabitacion;

public interface TipoHabitacionRepositorio  extends JpaRepository<TipoHabitacion,String> {

}
