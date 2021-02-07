package com.openwebinars.spring.modelo.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.openwebinars.spring.dominio.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria,Long> {

	@Query("select c from Categoria c where c.destacada = true")
	public List<Categoria> findDestacadas();
}
