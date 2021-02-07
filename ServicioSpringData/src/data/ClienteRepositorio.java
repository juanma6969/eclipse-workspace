package data;

import org.springframework.data.repository.CrudRepository;

import dominio.Cliente;

public interface ClienteRepositorio extends CrudRepository <Cliente,Integer>  {

}
