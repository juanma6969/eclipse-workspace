package com.clase.spring.dominio;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="thotel")
public class Hotel implements Serializable {
		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int idHotel;

		private String descripcion;

		private String email;

		private String gerente;

		private String nombre;

		private String provincia;

		private String telefono;

		public Hotel( String descripcion, String email, String gerente, String nombre, String provincia,
				String telefono) {
			super();
		
			this.descripcion = descripcion;
			this.email = email;
			this.gerente = gerente;
			this.nombre = nombre;
			this.provincia = provincia;
			this.telefono = telefono;
		}

		public int getIdHotel() {
			return idHotel;
		}

		public void setIdHotel(int idHotel) {
			this.idHotel = idHotel;
		}

		public String getDescripcion() {
			return descripcion;
		}

		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getGerente() {
			return gerente;
		}

		public void setGerente(String gerente) {
			this.gerente = gerente;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getProvincia() {
			return provincia;
		}

		public void setProvincia(String provincia) {
			this.provincia = provincia;
		}

		public String getTelefono() {
			return telefono;
		}

		public void setTelefono(String telefono) {
			this.telefono = telefono;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		@Override
		public String toString() {
			return "Hotel [idHotel=" + idHotel + ", descripcion=" + descripcion + ", email=" + email + ", gerente="
					+ gerente + ", nombre=" + nombre + ", provincia=" + provincia + ", telefono=" + telefono + "]";
		}
		
		

}
