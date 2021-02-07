package model.DataInterface;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dominio.Cliente;


public interface ClienteRepositorio extends CrudRepository<Cliente,Integer> {



}
