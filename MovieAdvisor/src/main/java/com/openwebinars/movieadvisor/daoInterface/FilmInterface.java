package com.openwebinars.movieadvisor.daoInterface;

import java.util.Collection;

import com.openwebinars.movieadvisor.dominio.Film;

public interface FilmInterface {

public Film filmById(long id);
public Collection<Film> findAll();
public void insert(Film f);
public void edit(Film f);
public void delete(long id);
}
