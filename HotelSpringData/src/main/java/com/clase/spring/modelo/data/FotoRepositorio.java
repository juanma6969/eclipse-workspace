package com.clase.spring.modelo.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clase.spring.dominio.Foto;



public interface FotoRepositorio extends JpaRepository<Foto,Integer> {

}
