package com.tuni.faltas.modelo;

public class Asignatura {
	String nombre;
	
	int horasTotales;
	

	//constructor
	public Asignatura(String nombre, int horasTotales) {
		super();
		this.nombre = nombre;
		this.horasTotales = horasTotales;
	}
	
	//getters y setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getHorasTotales() {
		return horasTotales;
	}

	public void setHorasTotales(int horasTotales) {
		this.horasTotales = horasTotales;
	}


	@Override
	public String toString() {
		return nombre;
	}
	
}