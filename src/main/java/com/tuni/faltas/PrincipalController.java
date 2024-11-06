package com.tuni.faltas;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;


public class PrincipalController implements Initializable {
	
	@FXML
	Button buttonEliminarCurso;
	
	@FXML
	Button buttonAniadirCurso;
	
	@FXML
	Button buttonGuardarCambios;
	
	@FXML 
	TextField textFieldNombre;
	
	@FXML
	ComboBox<String> comboBoxCursos;
	
	@FXML
	private void buttonAñadir() {
        try {
           MainApp.setRoot("Asignatura");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	@FXML
	private void buttonEliminar() {
		if(comboBoxCursos.getItems().contains(textFieldNombre.getText())) {
			comboBoxCursos.getItems().remove(textFieldNombre.getText());
		}
		textFieldNombre.clear();
	}
	
	@FXML
	private void buttonGuardar() {
		String nombre = textFieldNombre.getText();
		String seleccion = comboBoxCursos.getValue();
		
		if(!nombre.isEmpty()) {
			if(seleccion!=null) {
				int index = comboBoxCursos.getItems().indexOf(seleccion);
				comboBoxCursos.getItems().set(index, nombre);
			}else {
				comboBoxCursos.getItems().add(nombre);
			}
		}
		textFieldNombre.clear();
	}

	
	@FXML
	private void crearCurso() {
		String nombre = textFieldNombre.getText();
		if(nombre!=null) {
			comboBoxCursos.getItems().add(nombre);
			textFieldNombre.clear();
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		comboBoxCursos.getItems().addAll("Curso 1", "Curso 2", "Curso 3");
		
		//añadir botones
		comboBoxCursos.setOnAction(e ->{crearCurso();});
		buttonAniadirCurso.setOnAction(e ->{buttonAñadir();});
		buttonEliminarCurso.setOnAction(e ->{buttonEliminar();});
		buttonGuardarCambios.setOnAction(e ->{buttonGuardar();});
		
		
	}
	
}
