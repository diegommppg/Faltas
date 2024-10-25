package com.tuni.faltas.modelo;

import java.util.ArrayList;

public class Curso {
	String nombre;
	
	ArrayList<Asignatura> asignaturas;
	
	public Curso(String nombre, ArrayList<Asignatura> asignaturas) {
		super();
		this.nombre = nombre;
		this.asignaturas = asignaturas;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public ArrayList<Asignatura> getAsignaturas() {
		return asignaturas;
	}
	public void setAsignaturas(ArrayList<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}
	
}
