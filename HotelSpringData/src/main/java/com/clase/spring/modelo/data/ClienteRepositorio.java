package com.clase.spring.modelo.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clase.spring.dominio.Cliente;

public interface ClienteRepositorio extends JpaRepository<Cliente,Integer> {

}
