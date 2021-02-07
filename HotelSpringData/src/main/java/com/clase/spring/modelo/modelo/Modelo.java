package com.clase.spring.modelo.modelo;

import org.springframework.beans.factory.annotation.Autowired;

import com.clase.spring.modelo.data.ClienteRepositorio;
import com.clase.spring.modelo.data.ConsumicionRepositorio;
import com.clase.spring.modelo.data.FacturaRepositorio;
import com.clase.spring.modelo.data.FotoRepositorio;
import com.clase.spring.modelo.data.HabitacionRepositorio;
import com.clase.spring.modelo.data.HotelRepositorio;
import com.clase.spring.modelo.data.LineaFacturaRepositorio;
import com.clase.spring.modelo.data.ReservaRepositorio;
import com.clase.spring.modelo.data.ServicioRepositorio;
import com.clase.spring.modelo.data.TarifaRepositorio;
import com.clase.spring.modelo.data.TemporadaRepositorio;
import com.clase.spring.modelo.data.TipoHabitacionRepositorio;
import com.clase.spring.modelo.data.TipoServicioRepositorio;
import com.clase.spring.modelo.modeloInterface.ModeloInterface;

public class Modelo implements ModeloInterface{

	@Autowired
	private ClienteRepositorio clienteRepositorio;
	@Autowired
	private ConsumicionRepositorio consumicionRepositorio;
	@Autowired
	private FacturaRepositorio facturaRepositorio;
	@Autowired
	private FotoRepositorio fotoRepositorio;
	@Autowired
	private HabitacionRepositorio habitacionRepositorio;
	@Autowired
	private HotelRepositorio hotelRepositorio;
	@Autowired
	private LineaFacturaRepositorio lineaFacturaRepositorio;
	@Autowired
	private ReservaRepositorio reservaRepositorio;
	@Autowired
	private ServicioRepositorio servicioRepositorio;
	@Autowired
	private TarifaRepositorio tarifaRepositorio;
	@Autowired
	private TemporadaRepositorio temporadaRepositorio;
	@Autowired
	private TipoHabitacionRepositorio tipoHabitacionRepositorio;
	@Autowired
	private TipoServicioRepositorio tipoServicioRepositorio;
	public ClienteRepositorio getClienteRepositorio() {
		return clienteRepositorio;
	}
	public void setClienteRepositorio(ClienteRepositorio clienteRepositorio) {
		this.clienteRepositorio = clienteRepositorio;
	}
	public ConsumicionRepositorio getConsumicionRepositorio() {
		return consumicionRepositorio;
	}
	public void setConsumicionRepositorio(ConsumicionRepositorio consumicionRepositorio) {
		this.consumicionRepositorio = consumicionRepositorio;
	}
	public FacturaRepositorio getFacturaRepositorio() {
		return facturaRepositorio;
	}
	public void setFacturaRepositorio(FacturaRepositorio facturaRepositorio) {
		this.facturaRepositorio = facturaRepositorio;
	}
	public FotoRepositorio getFotoRepositorio() {
		return fotoRepositorio;
	}
	public void setFotoRepositorio(FotoRepositorio fotoRepositorio) {
		this.fotoRepositorio = fotoRepositorio;
	}
	public HabitacionRepositorio getHabitacionRepositorio() {
		return habitacionRepositorio;
	}
	public void setHabitacionRepositorio(HabitacionRepositorio habitacionRepositorio) {
		this.habitacionRepositorio = habitacionRepositorio;
	}
	public HotelRepositorio getHotelRepositorio() {
		return hotelRepositorio;
	}
	public void setHotelRepositorio(HotelRepositorio hotelRepositorio) {
		this.hotelRepositorio = hotelRepositorio;
	}
	public LineaFacturaRepositorio getLineaFacturaRepositorio() {
		return lineaFacturaRepositorio;
	}
	public void setLineaFacturaRepositorio(LineaFacturaRepositorio lineaFacturaRepositorio) {
		this.lineaFacturaRepositorio = lineaFacturaRepositorio;
	}
	public ReservaRepositorio getReservaRepositorio() {
		return reservaRepositorio;
	}
	public void setReservaRepositorio(ReservaRepositorio reservaRepositorio) {
		this.reservaRepositorio = reservaRepositorio;
	}
	public ServicioRepositorio getServicioRepositorio() {
		return servicioRepositorio;
	}
	public void setServicioRepositorio(ServicioRepositorio servicioRepositorio) {
		this.servicioRepositorio = servicioRepositorio;
	}
	public TarifaRepositorio getTarifaRepositorio() {
		return tarifaRepositorio;
	}
	public void setTarifaRepositorio(TarifaRepositorio tarifaRepositorio) {
		this.tarifaRepositorio = tarifaRepositorio;
	}
	public TemporadaRepositorio getTemporadaRepositorio() {
		return temporadaRepositorio;
	}
	public void setTemporadaRepositorio(TemporadaRepositorio temporadaRepositorio) {
		this.temporadaRepositorio = temporadaRepositorio;
	}
	public TipoHabitacionRepositorio getTipoHabitacionRepositorio() {
		return tipoHabitacionRepositorio;
	}
	public void setTipoHabitacionRepositorio(TipoHabitacionRepositorio tipoHabitacionRepositorio) {
		this.tipoHabitacionRepositorio = tipoHabitacionRepositorio;
	}
	public TipoServicioRepositorio getTipoServicioRepositorio() {
		return tipoServicioRepositorio;
	}
	public void setTipoServicioRepositorio(TipoServicioRepositorio tipoServicioRepositorio) {
		this.tipoServicioRepositorio = tipoServicioRepositorio;
	}

	
	
	
	
	
}
