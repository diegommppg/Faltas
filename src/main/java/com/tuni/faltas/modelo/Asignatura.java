package com.tuni.faltas.modelo;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Asignatura {
	String nombre;
	
	int horasTotales;
	
	ObservableList<Alumno> alumnos = FXCollections.observableArrayList();

	//constructor
	public Asignatura(String nombre, int horasTotales) {
		super();
		this.nombre = nombre;
		this.horasTotales = horasTotales;
	}
	
	//getters y setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getHorasTotales() {
		return horasTotales;
	}

	public void setHorasTotales(int horasTotales) {
		this.horasTotales = horasTotales;
	}

	public ObservableList<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(ObservableList<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	@Override
	public String toString() {
		return nombre;
	}
	
	
	
	
}