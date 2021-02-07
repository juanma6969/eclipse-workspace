package com.clase.spring.modelo.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clase.spring.dominio.LineaFactura;
import com.clase.spring.dominio.LineaFacturaPK;

public interface LineaFacturaRepositorio  extends JpaRepository<LineaFactura,LineaFacturaPK>{

}
