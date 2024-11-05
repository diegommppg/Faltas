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
	
	//Creo un array al que añadir los alumnos
	
	ArrayList<Alumno> alumnos = new ArrayList<>();

	//Campos vinculados a la interfaz principal a continuación
	
	//Labels
    @FXML
    Label NombreLabel;
    
    @FXML
    Label ApellidosLabel;
    
    @FXML
    Label FaltasLabel;
    
    //Textfields
    @FXML
    TextField NombreTextField;
    
    @FXML
    TextField ApellidosTextField;
    
    @FXML
    TextField FaltasTextField;
    
    //Botones
    @FXML
    Button EliminarAlumnoButton;
	
    @FXML
    Button GuardarCambiosButton;
    
    //Comboboxes
	@FXML
    private ComboBox<String> CursosComboBox;
    
    @FXML
    private ComboBox<String> AsignaturasComboBox;
    
    @FXML
    private ComboBox<String> AlumnosComboBox;
	
    //Método que hace que al iniciar la interfaz, añadiendo valores al combobox y seleccionando por defecto un alumno
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		CursosComboBox.getItems().addAll("1DAM", "2DAM", "1DAW", "2DAW");
		CursosComboBox.getSelectionModel().select("1DAM");
		
		AsignaturasComboBox.getItems().addAll("SGEM", "DESIN", "PMDM", "EIE", "PSPR", "ADT");
		AsignaturasComboBox.getSelectionModel().select("SGEM");
		
		Alumno Rodo = new Alumno("Rodolfo", "Díaz", 6);
		Alumno Luis = new Alumno("Luis", "Iturrioz", 10);
		
		alumnos.add(Rodo);
		alumnos.add(Luis);
		
		AlumnosComboBox.getItems().addAll(Rodo.getNombre() + " " + Rodo.getApellidos());
		AlumnosComboBox.getItems().addAll(Luis.getNombre() + " " + Luis.getApellidos());
		AlumnosComboBox.getSelectionModel().select("Rodolfo Diaz");
		NombreTextField.setText(Rodo.getNombre());
		ApellidosTextField.setText(Rodo.getApellidos());
		FaltasTextField.setText(Integer.toString(Rodo.getFaltas()));
	}

	//Método que se encarga de comprobar si el alumno cuyos datos se quieren guardar ya existe en el programa o si ha de añadirse,
	//en caso de ya existir se actualiza el número de faltas
	@FXML
	public void GuardarCambios() {
		
		String nombre = NombreTextField.getText();
		String apellido = ApellidosTextField.getText();
		int faltas = Integer.parseInt(FaltasTextField.getText());
		Alumno al = new Alumno(nombre, apellido, faltas);
		
		boolean contained = false;
		
		for (Alumno a: alumnos) {
			if ((a.getNombre().equals(nombre)) && (a.getApellidos().equals(apellido))) {
				a.setFaltas(faltas);
				contained = true;
			} 
		}
			
		if (!contained) {
			alumnos.add(al);
			AlumnosComboBox.getItems().addAll(al.getNombre() + " " + al.getApellidos());
		}
	}
	
	//Método que elimina los datos de el alumno seleccionado después de comprobar que efectivamente está presente en la base
	@FXML
	public void eliminar() {
		
		boolean contained = false;
		
		String nombre = NombreTextField.getText();
		String apellido = ApellidosTextField.getText();
		int faltas = Integer.parseInt(FaltasTextField.getText());
		NombreTextField.clear();
		ApellidosTextField.clear();
		FaltasTextField.clear();
		Alumno al = new Alumno(nombre, apellido, faltas);
		
		for (Alumno a: alumnos) {
			if ((a.getNombre().equals(nombre)) && (a.getApellidos().equals(apellido))) {
				contained = true;
			} 
		}
		
		if (contained) {
			alumnos.remove(al);
			AlumnosComboBox.getItems().remove(al.getNombre() + " " + al.getApellidos());
		}
	}
	
	//Se encarga de poner los valores de el alumno seleccionado en el combobox en los respectivos textfields
	@FXML
	public void cambio() {
		for (Alumno a: alumnos) {
			if ((a.getNombre() + " " + a.getApellidos()).equals(AlumnosComboBox.getValue())) {
				NombreTextField.setText(a.getNombre());
				ApellidosTextField.setText(a.getApellidos());
				FaltasTextField.setText(Integer.toString(a.getFaltas()));
			}
		}
	}
	
	
	
	

    
}
