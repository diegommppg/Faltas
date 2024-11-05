package com.tuni.faltas;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PrincipalController implements Initializable {

	@FXML
	private Label labelNombre;

	@FXML
	private Label labelApellidos;

	@FXML
	private Label labelFaltas;

	@FXML
	private TextField textFieldNombre;

	@FXML
	private TextField textFieldApellidos;

	@FXML
	private TextField textFieldFaltas;

	@FXML
	private Button buttonEliminar;

	@FXML
	private Button buttonGuardar;
	@FXML
	private ComboBox<String> boxCursos;
	@FXML
	private ComboBox<String> boxAsignaturas;
	@FXML
	private ComboBox<String> boxAlumnos;

	@FXML
	private ArrayList<String> alumnos = new ArrayList<String>();

	public void eliminarAlumno() {
		 // Obtener el alumno seleccionado en el ComboBox
	    String alumnoSeleccionado = boxAlumnos.getValue();

	    // Verificar que haya un alumno seleccionado
	    if (alumnoSeleccionado != null) {
	        // Eliminar el alumno del ComboBox
	        boxAlumnos.getItems().remove(alumnoSeleccionado);

	        // Eliminar el alumno del ArrayList
	        alumnos.remove(alumnoSeleccionado);

	        // Limpiar los campos de texto y restablecer los ComboBox
	        textFieldNombre.clear();
	        textFieldApellidos.clear();
	        textFieldFaltas.clear();
	        boxCursos.setValue(null);
	        boxAsignaturas.setValue(null);
	        boxAlumnos.setValue(null);
	    }
	}



	

	public void guardarAlumno() {
		

		String nombre = textFieldNombre.getText();
		String apellidos = textFieldApellidos.getText();
		String faltas = textFieldFaltas.getText();

		if (!nombre.isEmpty() && !apellidos.isEmpty() && !faltas.isEmpty()) {

			String alumnoNuevo = nombre + " " + apellidos + " " + faltas;
			
			// Añadir el nuevo alumno al ComboBox de alumnos
	        boxAlumnos.getItems().add(alumnoNuevo);
	        // Añadir el alumno también al ArrayList para mantener un registro
	        alumnos.add(alumnoNuevo);

			// Limpiar los campos luego de guardar
			textFieldNombre.clear();
			textFieldApellidos.clear();
			textFieldFaltas.clear();
		}
	}

			
	

	@Override
    
    public void initialize(URL location, ResourceBundle resources) {
        // Añadir opciones al ComboBox de cursos
        boxCursos.getItems().addAll("1º DAM", "2º DAM");

        // Configurar el evento para actualizar el ComboBox de asignaturas según el curso seleccionado
        boxCursos.setOnAction(event -> {
            // Limpiar el ComboBox de asignaturas para evitar opciones acumuladas
            boxAsignaturas.getItems().clear();

            // Verificar el curso seleccionado y actualizar las asignaturas
            String cursoSeleccionado = boxCursos.getValue();
            if (cursoSeleccionado.equals("1º DAM")) {
                boxAsignaturas.getItems().addAll("PROG", "BADAT", "ENDES", "LEUP", "LGMSI", "STI");
            } else if (cursoSeleccionado.equals("2º DAM")) {
                boxAsignaturas.getItems().addAll("DESIN", "ADT", "PSPR", "PMDM", "EIE", "SGEM");
            }
        });
    }	
	
	public void cambiarAlumno() {
		

		}

}
