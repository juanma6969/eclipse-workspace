package com.clase.spring.modelo.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.clase.spring.dominio.Cliente;

@Repository
public interface ClienteRepositorio extends CrudRepository<Cliente,String>{

}
