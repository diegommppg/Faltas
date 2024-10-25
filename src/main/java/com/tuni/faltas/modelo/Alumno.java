package com.tuni.faltas.modelo;

import java.util.ArrayList;
 
public class Alumno {
	String nombre;
	String apellidos;

	private ArrayList<Falta> faltas;

	public Alumno(String nombre, String apellidos, ArrayList<Falta> faltas) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.faltas = faltas;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellidos() {
		return apellidos;
	}
	
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	public ArrayList<Falta> getFaltas() {
		return faltas;
	}
}
