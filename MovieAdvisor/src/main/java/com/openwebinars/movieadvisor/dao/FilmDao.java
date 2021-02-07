package com.openwebinars.movieadvisor.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.openwebinars.movieadvisor.UtilFilmReader;
import com.openwebinars.movieadvisor.config.AppConfig;
import com.openwebinars.movieadvisor.daoInterface.FilmInterface;
import com.openwebinars.movieadvisor.dominio.Film;

@Repository
public class FilmDao implements FilmInterface {
public List<Film> peliculas= new ArrayList<>();
/**
 * Implementación en memoria de la interfaz FilmDao.
 * Además, incluye la lectura de los datos, a través de un método estático,
 * desde un fichero CSV.
 * 
 * 
 * @author OpenWebinars
 *
 */
@Autowired
private AppConfig appConfig;
@PostConstruct
public void init() {
	peliculas=UtilFilmReader.readFilm(appConfig.getFile(), appConfig.getSeparator(), appConfig.getListSeparator());
	
}
	@Override
	public Film filmById(long id) {
		
		Optional<Film> result = peliculas
				.stream()
				.filter(f -> f.getId() == id)
				.findFirst();
return result.orElse(null);
	}

	@Override
	public Collection<Film> findAll() {
		// TODO Auto-generated method stub
		return peliculas;
	}

	@Override
	public void insert(Film f) {
		peliculas.add(f);
	}

	@Override
	public void edit(Film f) {
		int index = getIndexOf(f.getId());
		if (index != -1)
			peliculas.set(index, f);
	}

	@Override
	public void delete(long id) {
		int index = getIndexOf(id);
		if (index != -1)
			peliculas.remove(index);
	}
	private int getIndexOf(long id) {
		boolean encontrado = false;
		int index = 0;
		
		while (!encontrado && index < peliculas.size()) {
			if (peliculas.get(index).getId() == id)
				encontrado = true;
			else
				index++;
		}
		
		return (encontrado) ? index : -1;
	}

}
