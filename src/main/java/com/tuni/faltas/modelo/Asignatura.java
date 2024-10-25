package com.tuni.faltas.modelo;

import java.util.ArrayList;

public class Asignatura {
	String nombre;
	
	int horasTotales;
	
	ArrayList<Alumno> alumnos;

	public Asignatura(String nombre, int horasTotales, ArrayList<Alumno> alumnos) {
		super();
		this.nombre = nombre;
		this.horasTotales = horasTotales;
		this.alumnos = alumnos;
	}

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

	public ArrayList<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(ArrayList<Alumno> alumnos) {
		this.alumnos = alumnos;
	}
	
	

}
