package com.clase.spring.modelo.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clase.spring.dominio.Factura;

public interface FacturaRepositorio extends JpaRepository<Factura,Integer> {

}
