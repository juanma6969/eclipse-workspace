package com.clase.spring.modelo.data;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.clase.spring.dominio.Producto;

@Repository
public interface ProductoRepositorio extends CrudRepository<Producto,Integer>{
	public static final int DOM = 1; 
	public static final int LUN = 2;
	public static final int MAR = 3;
	public static final int MIE = 4; 
	public static final int JUE = 5; 
	public static final int VIE = 6; 
	public static final int SAB = 7; 
	public static final int ALL = 0; 
	
/*	@Query(value = "SELECT * FROM TProductos WHERE disponible=?1 OR disponible=?2", nativeQuery = true)
	ArrayList<Producto> findBydisponible(int disponible1 , int disponible2);
*/
	}
