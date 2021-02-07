package com.openwebinars.movieadvisor.dominio;

import java.util.List;

public class Film {
	private long id;
	private String title;
	private String year;
	private List<String> generos;
	public Film() {
		super();
	}
	public Film(long id, String title, String year, List<String> generos) {
		super();
		this.id = id;
		this.title = title;
		this.year = year;
		this.generos = generos;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public List<String> getGeneros() {
		return generos;
	}
	public void setGeneros(List<String> generos) {
		this.generos = generos;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((generos == null) ? 0 : generos.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((year == null) ? 0 : year.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		if (generos == null) {
			if (other.generos != null)
				return false;
		} else if (!generos.equals(other.generos))
			return false;
		if (id != other.id)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (year == null) {
			if (other.year != null)
				return false;
		} else if (!year.equals(other.year))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Film [id=" + id + ", title=" + title + ", year=" + year + ", generos=" + generos + "]";
	}
	
	
	

}
