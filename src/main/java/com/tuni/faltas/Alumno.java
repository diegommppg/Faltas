package com.tuni.faltas;

import java.util.ArrayList;

public class Alumno {
	
	// atributos
	private String nombre;
	private String apellido;
	private String numIdentificacion;
	private ArrayList<Falta> faltas; // colección de faltas
	
	// constructor
	public Alumno(String nombre, String apellido, String numIdentificacion) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.numIdentificacion = numIdentificacion;
		this.faltas = new ArrayList<>(); // inicializo el array
	}
	
	// setters y getters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNumIdentificacion() {
		return numIdentificacion;
	}

	public void setNumIdentificacion(String numIdentificacion) {
		this.numIdentificacion = numIdentificacion;
	}

	public ArrayList<Falta> getFaltas() {
		return faltas;
	}

	public void setFaltas(ArrayList<Falta> faltas) {
		this.faltas = faltas;
	}
	
	// métodos adicionales (podrían usarse en la app)
	
	// método para añadir faltas
	public void agregarFalta(Falta falta) {
		faltas.add(falta);
	}
	
	// método para eliminar faltas
	public void eliminarFalta(Falta falta) {
		faltas.remove(falta);
	}
	
	// método para contar faltas
	public int contarFaltas() {
		return faltas.size();
	}
}
