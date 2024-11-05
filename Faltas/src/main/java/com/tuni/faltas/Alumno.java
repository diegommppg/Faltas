package com.tuni.faltas;

public class Alumno {
	
	String nombre;
	String apellidos;
	int faltas;
	
	public Alumno(String nombre, String apellidos, int faltas) {
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

	public int getFaltas() {
		return faltas;
	}

	public void setFaltas(int faltas) {
		this.faltas = faltas;
	}

    @Override
    public String toString() {
        return nombre + " " + apellidos;
    }
	
}
