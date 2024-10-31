package com.tuni.faltas;

import java.util.ArrayList;

public class Curso {
	
	// atributos
	private String nombre;
	private String codigo;
	private ArrayList<Asignatura> asignaturas; // colección de asignaturas
	
	// constructor
	public Curso(String nombre, String codigo) {
		this.nombre = nombre;
		this.codigo = codigo;
		this.asignaturas = new ArrayList<>(); // inicializo el array
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

	public ArrayList<Asignatura> getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(ArrayList<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}

	// métodos adicionales (podrían usarse en la app)
	
	// método para añadir asignaturas
	public void agregarAsignatura(Asignatura asignatura) {
		asignaturas.add(asignatura);
	}
	
	// método para eliminar asignaturas
	public void eliminarAsignatura(Asignatura asignatura) {
		asignaturas.remove(asignatura);
	}
	
	// método para contar asignaturas
	public int contarAsignaturas() {
		return asignaturas.size();
	}
}
