package com.tuni.faltas.modelo;

import javafx.collections.ObservableList;

public class Curso {
    private String nombre;
    private ObservableList<Asignatura> asignaturas;

    public Curso(String nombre, ObservableList<Asignatura> asignaturas) {
        this.nombre = nombre;
        this.asignaturas = asignaturas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ObservableList<Asignatura> getAsignatura() {
        return asignaturas;
    }

    public void setAsignatura(ObservableList<Asignatura> asignaturas) {
        this.asignaturas = asignaturas;
    }
    
    @Override
    public String toString() {
        return nombre; 
    }
}
