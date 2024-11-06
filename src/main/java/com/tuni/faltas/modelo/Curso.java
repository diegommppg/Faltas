package com.tuni.faltas.modelo;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Curso {
	String nombre;
	
	ObservableList<Asignatura> listAsignatura = FXCollections.observableArrayList();
	//constructor
	public Curso(String nombre, ObservableList<Asignatura> listAsignatura) {
		super();
		this.nombre = nombre;
		this.listAsignatura = listAsignatura;
	}
	
	//getters y setters
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public ObservableList<Asignatura> getListAsignatura() {
		return listAsignatura;
	}
	public void setListAsignatura(ObservableList<Asignatura> listAsignatura) {
		this.listAsignatura = listAsignatura;
	}

	@Override
	public String toString() {
		return nombre ;
	}
	
	
	
	
	
	
	
	
}