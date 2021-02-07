package com.openwebinars.spring.modelo.modelo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openwebinars.spring.modelo.data.CategoriaRepository;
import com.openwebinars.spring.modelo.modeloInterface.ModeloInterface;
/**
 * Esta clase se encargara de la los metodos que no son perteneciente al 
 * Crud ,ademas tendra un dos anotaciones reconocidas por Spring Core 
 * que auto inyectaran los repositorios para que sean utilizado por el controlador
 * @author JuanManuel
 *
 */
@Service
public class Modelo implements ModeloInterface{
	
	@Autowired
	private CategoriaRepository repositorioCategoria;

}
