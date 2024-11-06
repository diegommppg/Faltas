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

	//Declaracion de variables
	@FXML
	Label labelNombre;

	@FXML
	TextField textNombre;

	@FXML
	Button buttonAdd;
	
	@FXML
	Button buttonEliminar;

	@FXML
	Button buttonSave;

	@FXML
	ComboBox<String> comboCurso;

	
	
	@FXML
	//Metodo crear cursos
	  private void crearCurso() {
	        String nombreCurso = textNombre.getText();
	        if (!nombreCurso.isEmpty()) {
	            comboCurso.getItems().add(nombreCurso);
	            textNombre.clear();
	        }
	    }



	@FXML
	//Metodo para eliminar cursos
    private void eliminarCurso() {
        String cursoSeleccionado = comboCurso.getValue();
        if (cursoSeleccionado != null) {
            comboCurso.getItems().remove(cursoSeleccionado);
            textNombre.clear();
            System.out.println("Curso eliminado: " + cursoSeleccionado);
        }
    }
	
	@FXML
	//Metodo para guardar 
	private void guardarCambios() {
        String nombreCurso = textNombre.getText();
        String cursoSeleccionado = comboCurso.getValue();
        if (!nombreCurso.isEmpty()) {
            if (cursoSeleccionado != null) {
                // Actualizar el curso
                int index = comboCurso.getItems().indexOf(cursoSeleccionado);
                comboCurso.getItems().set(index, nombreCurso);
                System.out.println("Curso actualizado a: " + nombreCurso);
            } else {
                // Crear un nuevo curso
                comboCurso.getItems().add(nombreCurso);
                System.out.println("Curso creado: " + nombreCurso);
            }
            textNombre.clear();
        }
    }

	@FXML
    private void windowAsignatura() {
        try {
           MainApp.setRoot("Asignatura");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		
		// Cargar el combo con los nombres de los cursos
		comboCurso.setOnAction(e -> crearCurso());
		buttonSave.setOnAction(e -> guardarCambios());
		buttonEliminar.setOnAction(e -> eliminarCurso());	
		buttonAdd.setOnAction(e -> windowAsignatura());
	}

}