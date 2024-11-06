package com.tuni.faltas.modelo;

import java.util.ArrayList;
import java.util.List;

public class Asignatura {
	private String nombre;
	private List<Alumno> alumnos;

	public Asignatura(String nombre) {
		this.nombre = nombre;
		this.alumnos = new ArrayList<>();
	}

	// Métodos getters y setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	// Método para agregar alumnos
	public void agregarAlumno(Alumno alumno) {
		if (!alumnos.contains(alumno)) {
			alumnos.add(alumno);
		}
	}

	// Método para buscar un alumno por nombre
	public Alumno buscarAlumno(String nombre) {
		for (Alumno alumno : alumnos) {
			if (alumno.getNombre().equalsIgnoreCase(nombre)) {
				return alumno;
			}
		}
		return null; // No se encontró el alumno
	}
}
