package com.tuni.faltas;

import javafx.scene.control.Label;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class InterfazCursos implements Initializable {

	// Recuperar las etiquetas
	@FXML
	Label labelNombre;

	@FXML
	TextField textNombre;

	@FXML
	Button buttonAdd;

	@FXML
	Button buttonGuardar;

	@FXML
	ComboBox<String> comboCurso;

	@FXML
	Button buttonEliminar;
	
	@FXML
	//Añadimos un curso
	  private void crearCurso() {
	        String nombreCurso = textNombre.getText();
	        if (!nombreCurso.isEmpty()) {
	            comboCurso.getItems().add(nombreCurso);
	            textNombre.clear();
	            System.out.println("Curso creado: " + nombreCurso);
	        }
	    }

	@FXML
	//Guardamos cambios
	private void guardarCambios() {
        String nombreCurso = textNombre.getText();
        String cursoSeleccionado = comboCurso.getValue();
        if (!nombreCurso.isEmpty()) {
            if (cursoSeleccionado != null) {
                // Actualizar el curso seleccionado
                int index = comboCurso.getItems().indexOf(cursoSeleccionado);
                comboCurso.getItems().set(index, nombreCurso);
                System.out.println("Curso actualizado a: " + nombreCurso);
            } else {
                // Crear un nuevo curso si no está seleccionado
                comboCurso.getItems().add(nombreCurso);
                System.out.println("Curso creado: " + nombreCurso);
            }
            textNombre.clear();
        }
    }

	@FXML
	//Eliminamos un curso
    private void eliminarCurso() {
        String cursoSeleccionado = comboCurso.getValue();
        if (cursoSeleccionado != null) {
            comboCurso.getItems().remove(cursoSeleccionado);
            textNombre.clear();
            System.out.println("Curso eliminado: " + cursoSeleccionado);
        }
    }

	@FXML
    private void abrirVentanaAsignatura() {
        try {
           MainApp.setRoot("Asignatura");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		// Añadir cursos
		comboCurso.getItems().addAll("Primer Curso", "Segundo Curso");
		
		// Anadir botones
		comboCurso.setOnAction(e -> crearCurso());
		buttonGuardar.setOnAction(e -> guardarCambios());
		buttonEliminar.setOnAction(e -> eliminarCurso());	
		buttonAdd.setOnAction(e -> abrirVentanaAsignatura());
	}

}
