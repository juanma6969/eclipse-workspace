package com.clase.spring.modelo.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clase.spring.dominio.Reserva;
import com.clase.spring.dominio.ReservaPK;

public interface ReservaRepositorio  extends JpaRepository<Reserva,ReservaPK> {

}
