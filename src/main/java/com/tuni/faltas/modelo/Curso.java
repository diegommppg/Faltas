package com.tuni.faltas.modelo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Curso {
    private String nombre;
    private ObservableList<Asignatura> asignaturas; // Cambiado a ObservableList

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

    public ObservableList<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(ObservableList<Asignatura> asignaturas) {
        this.asignaturas = asignaturas;
    }
}
