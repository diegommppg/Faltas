package com.tuni.faltas.modelo;

import java.time.LocalDate;

public class Falta {
	private LocalDate fecha;
	private String motivo;

	public Falta(LocalDate fecha, String motivo) {
		this.fecha = fecha;
		this.motivo = motivo;
	}

	// Métodos getters y setters
	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	// Método para representar la falta en un formato de texto
	@Override
	public String toString() {
		return "Fecha: " + fecha + ", Motivo: " + motivo;
	}
}
