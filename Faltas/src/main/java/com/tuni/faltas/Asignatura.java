package com.tuni.faltas;

import java.util.ArrayList;

public class Asignatura {
	
	String nombre;
	ArrayList<Alumno> alumnos;
	
	public Asignatura(String nombre, ArrayList<Alumno> alumnos) {
		this.nombre = nombre;
		this.alumnos = alumnos;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public ArrayList<Alumno> getAlumnos() {
		return alumnos;
	}
	
	public void setAlumnos(ArrayList<Alumno> alumnos) {
		this.alumnos = alumnos;
	}
	
	@Override
	public String toString() {
		return nombre;
	}
	
	

}
