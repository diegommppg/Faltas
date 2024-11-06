package com.tuni.faltas.modelo;

public class Falta {
	boolean justificada;
	
	int horas;
	
	String asignatura;
	
	public Falta(boolean justificada, int horas, String asignatura) {
		super();
		this.justificada = justificada;
		this.horas = horas;
		this.asignatura = asignatura;
	}
	
	public String getAsignatura() {
		return asignatura;
	}
	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
	}
	
	public boolean isJustificada() {
		return justificada;
	}
	public void setJustificada(boolean justificada) {
		this.justificada = justificada;
	}
	public int getHoras() {
		return horas;
	}
	public void setHoras(int horas) {
		this.horas = horas;
	}
}