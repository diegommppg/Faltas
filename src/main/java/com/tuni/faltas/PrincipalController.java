package com.tuni.faltas;

import java.io.IOException;
import javafx.fxml.FXML;

public class PrincipalController {

	// Cambiar a la interfaz cursos
	@FXML
	private void switchToCursos() throws IOException {
		MainApp.setRoot("cursos");
	}

	// Cambiar a la interfaz asignaturas
	@FXML
	private void switchToAsignaturas() throws IOException {
		MainApp.setRoot("asignaturas");
	}

	// Cambiar a la interfaz alumnos
	@FXML
	private void switchToAlumnos() throws IOException {
		MainApp.setRoot("alumnos");
	}
}
