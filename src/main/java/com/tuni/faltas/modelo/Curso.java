package com.tuni.faltas.modelo;

import com.tuni.faltas.modelo.Asignatura;

import java.util.ArrayList;
import java.util.List;

public class Curso {
	private String nombre;
	private List<Asignatura> asignaturas;

	public Curso(String nombre) {
		this.nombre = nombre;
		this.asignaturas = new ArrayList<>();
	}

	// Métodos getters y setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Asignatura> getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(List<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}

	// Método para agregar asignaturas
	public void agregarAsignatura(Asignatura asignatura) {
		if (!asignaturas.contains(asignatura)) {
			asignaturas.add(asignatura);
		}
	}

	// Método para buscar una asignatura por nombre
	public Asignatura buscarAsignatura(String nombre) {
		for (Asignatura asignatura : asignaturas) {
			if (asignatura.getNombre().equalsIgnoreCase(nombre)) {
				return asignatura;
			}
		}
		return null; // No se encontró la asignatura
	}
}
