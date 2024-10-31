package com.tuni.faltas;

import java.util.ArrayList;

public class Asignatura {
	
	// atributos
	private String nombre;
	private String codigo;
	private ArrayList<Alumno> alumnos; // colección de alumnos
	
	// constructor
	public Asignatura(String nombre, String codigo) {
		this.nombre = nombre;
		this.codigo = codigo;
		this.alumnos = new ArrayList<>(); // inicializo el array
	}
	
	// setters y getters
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public ArrayList<Alumno> getAlumnos() {
		return alumnos;
	}
	public void setAlumnos(ArrayList<Alumno> alumnos) {
		this.alumnos = alumnos;
	}
	
	// métodos adicionales (podrían usarse en la app)
	
	// método para añadir un alumno
	public void agregarAlumno(Alumno alumno) {
		alumnos.add(alumno);
	}
	
	// método para eliminar un alumno
	public void eliminarAlumno(Alumno alumno) {
		alumnos.remove(alumno);
	}
	
	// método para contar el número de alumnos
	public int contarAlumnos() {
		return alumnos.size();
	}
}
