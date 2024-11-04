package com.tuni.faltas;

import javafx.event.ActionEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class PrincipalController implements Initializable {

	@FXML
	private ComboBox<String> cbCursos;
	@FXML
	private ComboBox<String> cbAsignaturas;

	@FXML
	private ComboBox<String> cbAlumnos;

	private ArrayList<Alumno> alumnos = new ArrayList<>();

	@FXML
	private TextField tfNombre;
	@FXML
	private TextField tfApellidos;
	@FXML
	private TextField tfFaltas;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		cbCursos.getItems().addAll("1ºDAM", "1ºDAW", "2ºDAM", "2ºDAW");
		cbCursos.setValue(cbCursos.getItems().get(0));
		cbAsignaturas.getItems().addAll("DESIN", "PMDM", "SGEM", "ADT", "EIE", "PDAM");
		cbAsignaturas.setValue(cbAsignaturas.getItems().get(0));

		alumnos.add(new Alumno("Rodrigo", "Cid Colino", 4));
		alumnos.add(new Alumno("Otro", "Alumno Anonimo", 7));
		cbAlumnos.getItems().addAll(alumnos.get(0).getNombre(), alumnos.get(1).getNombre());

	}

	@FXML
	public void cambiarAlumno() {
		
		String nombreSeleccionado = cbAlumnos.getValue();

		for (Alumno alu : alumnos) {
			if (alu.getNombre().equals(nombreSeleccionado)) {
			
				tfNombre.setText(alu.getNombre());
				tfApellidos.setText(alu.getApellidos());
				tfFaltas.setText(String.valueOf(alu.getFaltas()));
				break;
			}
		}

	}
}
