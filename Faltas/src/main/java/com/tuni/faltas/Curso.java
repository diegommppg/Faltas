package com.tuni.faltas;

import java.util.ArrayList;

public class Curso {

	String nombre;
	ArrayList<Asignatura> Asignaturas;
	
	public Curso(String nombre, ArrayList<Asignatura> asignaturas) {
		this.nombre = nombre;
		Asignaturas = asignaturas;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public ArrayList<Asignatura> getAsignaturas() {
		return Asignaturas;
	}
	public void setAsignaturas(ArrayList<Asignatura> asignaturas) {
		Asignaturas = asignaturas;
	}
	
    @Override
    public String toString() {
        return nombre;
    }
	
	
}
