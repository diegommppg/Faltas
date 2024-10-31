package com.tuni.faltas;

import java.time.LocalDate;

public class Falta {
	
	// atributos
	private LocalDate fecha;
	private String descripcion;
	private boolean justificada;
	
	// constructor
	public Falta(LocalDate fecha, String descripcion, boolean justificada) {
		this.fecha = fecha;
		this.descripcion = descripcion;
		this.justificada = justificada;
	}
	
	// setters y getters
	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isJustificada() {
		return justificada;
	}

	public void setJustificada(boolean justificada) {
		this.justificada = justificada;
	}
	
	// método adicional (podría usarse en la app)
	
	// método para obtener el estado de la falta
	public String obtenerEstadoFalta() {
		return justificada ? "Justificada" : "No justificada";
	}

}
