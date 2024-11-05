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

//Implementar la interfaz de inicializacion para poder hacer las acciones
public class InterfazCursosController implements Initializable {
	// Recuperamos los elementos de la vista
	@FXML
	Label lblNombre;

	@FXML
	Button buttonEliminar;

	@FXML
	Button buttonGuardar;

	@FXML
	Button buttonAsignatura;

	@FXML
	TextField editNombre;

	@FXML
	ComboBox comboCursos;

	//Metodo para guardar los cursos
	public void guardarCurso() {
		// Obtenemos el nombre del curso, usando trim para quitar espacios
		String nombre = editNombre.getText().trim();
		// Si el nombre no esta vacio
		if (!nombre.isEmpty()) {
			// Obtenemos el curso seleccionado en el combobox
			String cursoActual = (String) comboCursos.getSelectionModel().getSelectedItem();
			if (cursoActual != null) {
				// Comprobamos que el nombre del curso no sea el mismo que introducimos
				if (!cursoActual.equals(nombre)) {
					if (!comboCursos.getItems().contains(nombre)) {
						// Modificamos con el nuevo nombre
						comboCursos.getItems().set(comboCursos.getItems().indexOf(cursoActual), nombre);
						// Deseleccionamos el combobox
						comboCursos.getSelectionModel().clearSelection();
					}
				}
			} else {
				// Si no tenemos nada seleccionado, añadimos el curso
				if (!comboCursos.getItems().contains(nombre)) {
					comboCursos.getItems().add(nombre);
					// Deseleccionamos el combobox
					comboCursos.getSelectionModel().clearSelection();
				}
			}
			// Limpiamos el campo de texto para ambas acciones
			editNombre.clear();
		}
	}

	// Metodo para borrar un curso
	public void borrarCurso() {
		// Obtenemos el curso seleccionado en el combobox
		String curso = comboCursos.getSelectionModel().getSelectedItem().toString();
		// Lo borramos si existe
		if (curso != null) {
			comboCursos.getItems().remove(curso);
			// Deseeleccionamos el combobox
			comboCursos.getSelectionModel().clearSelection();
		}
	}

	// Metodo para ir a la interfaz de asignatura
	public void irAsignatura() {
		// Abrimos la interfaz de asignatura mediante setRoot
		try {
			MainApp.setRoot("Asignatura");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}
}
