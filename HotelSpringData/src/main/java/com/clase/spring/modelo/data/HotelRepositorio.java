package com.clase.spring.modelo.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clase.spring.dominio.Hotel;

public interface HotelRepositorio extends JpaRepository<Hotel,Integer> {

}
