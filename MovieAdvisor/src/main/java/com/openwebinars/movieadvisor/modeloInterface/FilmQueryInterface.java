package com.openwebinars.movieadvisor.modeloInterface;

import java.util.Collection;

import com.openwebinars.movieadvisor.dominio.Film;
import com.openwebinars.movieadvisor.modelo.FilmQueryService;

/**
 * Intefaz del servicio de consulta sobre el repositorio de películas.
 * Está definido de forma que permita encadenar llamadas a métodos
 * haciendo un AND de las diferentes condiciones. Para ejecutar
 * la consulta, se invoca en último lugar el método exec.
 * 
 * ¿Serías capaz de añadir la lógica necesaria para que se pudieran
 * utilizar AND y OR?
 * 
 * 
 * @author OpenWebinars
 *
 */
public interface FilmQueryInterface {

public Collection<Film> exec();
	
	public FilmQueryService anyGenre(String... genres);

	public FilmQueryService allGenres(String... genres);

	public FilmQueryService year(String year);

	public FilmQueryService betweenYears(String from, String to);

	public FilmQueryService titleContains(String title);
}
