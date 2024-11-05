package com.tuni.faltas;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class PrincipalController {

    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtApellidos;
    @FXML
    private TextField txtFaltas;
    @FXML
    private ComboBox<String> comboBoxCursos;
    @FXML
    private ComboBox<String> comboBoxAsignaturas;
    @FXML
    private ComboBox<String> comboBoxAlumnos;
    @FXML
    private Button btnEliminarAlumno;
    @FXML
    private Button btnGuardarCambios;

    private ObservableList<String> listaAlumnos = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Configurar ComboBox de Cursos
        ObservableList<String> cursos = FXCollections.observableArrayList("1DAM", "2DAM");
        comboBoxCursos.setItems(cursos);

        // Configurar ComboBox de Asignaturas
        ObservableList<String> asignaturas = FXCollections.observableArrayList("DESIN", "PSPR", "PMDM");
        comboBoxAsignaturas.setItems(asignaturas);

        // Configurar ComboBox de Alumnos con una lista vacía al inicio
        comboBoxAlumnos.setItems(listaAlumnos);

        // Configurar acciones de los botones
        btnGuardarCambios.setOnAction(event -> guardarCambios());
        btnEliminarAlumno.setOnAction(event -> eliminarAlumno());
    }

    private void guardarCambios() {
        // Obtener valores de los campos de texto
        String nombre = txtNombre.getText();
        String apellidos = txtApellidos.getText();
        String faltas = txtFaltas.getText();

        // Validar que todos los campos están llenos
        if (nombre.isEmpty() || apellidos.isEmpty() || faltas.isEmpty() || comboBoxCursos.getValue() == null || comboBoxAsignaturas.getValue() == null) {
            System.out.println("Complete todos los campos");
            return;
        }

        // Concatenar nombre completo y agregarlo a la lista de alumnos
        String nombreCompleto = nombre + " " + apellidos;
        listaAlumnos.add(nombreCompleto);

        // Mostrar mensaje en consola con los datos guardados
        System.out.println("Guardando cambios para el alumno: " + nombreCompleto);
        System.out.println("Curso: " + comboBoxCursos.getValue());
        System.out.println("Asignatura: " + comboBoxAsignaturas.getValue());
        System.out.println("Faltas: " + faltas);

        // Limpiar campos después de guardar
        limpiarCampos();
    }

    private void eliminarAlumno() {
        // Eliminar el alumno seleccionado en el ComboBox de Alumnos
        String alumnoSeleccionado = comboBoxAlumnos.getValue();
        if (alumnoSeleccionado != null) {
            listaAlumnos.remove(alumnoSeleccionado);
            System.out.println("Alumno eliminado: " + alumnoSeleccionado);
        } else {
            System.out.println("Seleccione un alumno para eliminar");
        }
        limpiarCampos();
    }

    private void limpiarCampos() {
        // Limpiar los campos de texto
        txtNombre.clear();
        txtApellidos.clear();
        txtFaltas.clear();

        // Limpiar la selección de los ComboBox
        comboBoxCursos.getSelectionModel().clearSelection();
        comboBoxAsignaturas.getSelectionModel().clearSelection();
        comboBoxAlumnos.getSelectionModel().clearSelection();
    }
}