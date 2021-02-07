package com.openwebinars.movieadvisor;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.util.ResourceUtils;

import com.openwebinars.movieadvisor.dominio.Film;


public class UtilFilmReader {

	public static List<Film> readFilm(final String path,final String separator, final String listSeparator){
		List<Film> result=new ArrayList<>();
		//@formatter:off
		try {
			result=Files.lines(Paths.get(ResourceUtils.getFile(path).toURI()))
			.skip(1)
			.map(line -> {
				String[] values= line.split(separator);
				return new Film(Long.parseLong(values[0]),values[1],values[2],
						Arrays.asList(values[3].split(listSeparator)));
			}).collect(Collectors.toList());
		} catch (IOException e) {
			System.err.println("Error al leer el fichero");
			System.exit(-1);
		}
		//@formatter:on
		return result;
	}
}
