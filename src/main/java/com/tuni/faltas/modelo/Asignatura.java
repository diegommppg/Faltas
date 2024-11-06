package com.tuni.faltas.modelo;

public class Asignatura {
    private String nombre;
    private int horasTotales;

    public Asignatura(String nombre, int horasTotales) {
        this.nombre = nombre;
        this.horasTotales = horasTotales;
    }

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
    
    @Override
    public String toString() {
        return nombre; 
    }
}
