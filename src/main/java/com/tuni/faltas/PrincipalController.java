package com.tuni.faltas;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;



public class PrincipalController implements Initializable {

    
	@FXML TextField textNombre; @FXML TextField textApellidos; @FXML TextField textFaltas;
	
	@FXML Label labelNombre; @FXML Label labelApellidos; @FXML Label labelFaltas;
	
	@FXML Button buttonGuardarCambios; @FXML Button buttonEliminarAlumno;
	
	@FXML private ComboBox<String> boxCursos;
	@FXML private ComboBox<String> boxAsignaturas;
	@FXML private ComboBox<String> boxAlumnos;


	@FXML
	public void asignaturas() {
		if(boxCursos.getValue().contains("1ºDAM")) {
			boxAsignaturas.getItems().clear();
			boxAsignaturas.getItems().addAll("BADAT","PROGR","LMGSI","FOL","LEUP","ENDES");	
			
		} else if(boxCursos.getValue().contains("2ºDAM")) {
			boxAsignaturas.getItems().clear();
			boxAsignaturas.getItems().addAll("ADT","DESIN","PSPR","EIE","SGEM","PMDM");	
	
		}
	}
	
	
	@FXML
	public void eliminarAlumno() {
	    // Obtener el índice del alumno seleccionado en el ComboBox
	    int selectedIndex = boxAlumnos.getSelectionModel().getSelectedIndex();
	    
	    // Verificar si hay un alumno seleccionado
	    if (selectedIndex != -1) {
	        // Eliminar el alumno seleccionado
	        boxAlumnos.getItems().remove(selectedIndex);
	        
	        // Limpiar los TextField después de eliminar
	        textNombre.clear();
	        textApellidos.clear();
	        textFaltas.clear();
	        
	        // Limpiar la selección del ComboBox
	        boxAlumnos.getSelectionModel().clearSelection();
	     
	    }
	}
	
	@FXML
	public void guardarAlumno() {
	    String nombre = textNombre.getText();
	    String apellidos = textApellidos.getText();
	    String faltas = textFaltas.getText();
	    String asignatura = boxAsignaturas.getValue();
	    
	    if (asignatura == null || asignatura.isEmpty()) {
	        // Mostrar alerta si no hay asignatura seleccionada
	        Alert alert = new Alert(AlertType.WARNING);
	        alert.setTitle("Advertencia");
	        alert.setHeaderText("Asignatura no seleccionada");
	        alert.setContentText("Por favor, selecciona una asignatura antes de guardar.");
	        alert.showAndWait();
	        return; // Salir del método si no hay asignatura
	    }
	    
	    if (!nombre.isEmpty() && !apellidos.isEmpty() && !faltas.isEmpty()) {
	        String alumnoInfo = nombre + " " + apellidos + " " + faltas + " faltas en " + asignatura;
	        
	        // Si hay un elemento seleccionado en el ComboBox, actualizarlo
	        int selectedIndex = boxAlumnos.getSelectionModel().getSelectedIndex();
	        if (selectedIndex != -1) {
	            boxAlumnos.getItems().set(selectedIndex, alumnoInfo);
	        } else {
	            // Si no hay selección previa, agregar un nuevo elemento
	            boxAlumnos.getItems().add(alumnoInfo);
	        }
	        
	        // Limpiar los campos después de guardar
	        textNombre.clear();
	        textApellidos.clear();
	        textFaltas.clear();
	        
	        // Limpiar la selección del ComboBox
	        boxAlumnos.getSelectionModel().clearSelection();
	    }
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		boxCursos.getItems().addAll("1ºDAM","2ºDAM");

		boxAlumnos.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
	        if (newValue != null) {
	        	
	            // Separar el texto seleccionado en nombre, apellidos y faltas
	            String[] parts = newValue.split(" ");
	            if (parts.length >= 3) {
	                String nombre = parts[0];
	                String apellidos = parts[1];
	                String faltas = parts[2];
	                
	                // Rellenar los TextField con los valores extraídos
	                textNombre.setText(nombre);
	                textApellidos.setText(apellidos);
	                textFaltas.setText(faltas.replace("faltas", "").trim());
	            }
	        }
	    });
		
		
		
	}
	
	
}
