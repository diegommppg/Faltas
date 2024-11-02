package com.tuni.faltas;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.dmm.primer_javafx.App;

import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class PrincipalController {

	//Metodo para cambiar la vista a la interfaz cursos
	@FXML
    private void switchToCursos() throws IOException {
        App.setRoot("Cursos");
    }
	
	//Metodo para cambiar la vista a la interfaz asignaturas
	@FXML
    private void switchToAsignaturas() throws IOException {
        App.setRoot("Asignaturas");
    }
	
	//Metodo para cambiar la vista a la interfaz alumnos
	@FXML
    private void switchToAlumnos() throws IOException {
        App.setRoot("Alumnos");
    }
}
