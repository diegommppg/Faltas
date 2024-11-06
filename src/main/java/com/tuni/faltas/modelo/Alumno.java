package com.tuni.faltas.modelo;

import java.util.ArrayList;
import java.util.List;

public class Alumno {
	private String nombre;
	private List<Object> faltas;

	public Alumno(String nombre) {
		this.nombre = nombre;
		this.faltas = new ArrayList<>().reversed();
	}

	// Métodos getters y setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Object> getFaltas() {
		return faltas;
	}

	public void setFaltas(List<Object> faltas) {
		this.faltas = faltas;
	}

	// Método para agregar una falta
	public void agregarFalta(Object falta) {
		faltas.add(falta);
	}

	// Método para contar el total de faltas
	public int contarFaltas() {
		return faltas.size();
	}
}
