package com.tuni.faltas;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Alumno {

	private String nombre, apellidos;
	private int faltas;
	private Map<String, Integer> faltasAsignaturas;

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	private String curso;

	public Alumno(String nombre, String apellidos, int faltas, String c) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.faltas = faltas;
		curso = c;

		if (curso.equals("1ºDAM")) {
			faltasAsignaturas = new HashMap<>() {
				{
					put("PROG", 0);
					put("LSGMI", 0);
					put("SISIN", 0);
					put("BADAT", 0);
					put("FOL", 0);
					put("ENDES", 0);

				}
			};

		}

		if (curso.equals("2ºDAM")) {

			faltasAsignaturas = new HashMap<>() {
				{

					put("DESIN", 0);
					put("PMDM", 0);
					put("SGEM", 0);
					put("ADT", 0);
					put("EIE", 0);
				}
			};

		}

	}

	public Map<String, Integer> getFaltasAsignaturas() {
		return faltasAsignaturas;
	}

	public void setFaltasAsignaturas(Map<String, Integer> faltasAsignaturas) {
		this.faltasAsignaturas = faltasAsignaturas;
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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;

		Alumno other = (Alumno) obj;
		return nombre.equals(other.nombre) && apellidos.equals(other.apellidos);
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre, apellidos);
	}

}
