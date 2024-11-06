package com.tuni.faltas;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
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
	private ComboBox<Alumno> cbAlumnos;

	private ObservableList<Alumno> alumnos = FXCollections.observableArrayList();

	@FXML
	private TextField tfNombre;
	@FXML
	private TextField tfApellidos;
	@FXML
	private TextField tfFaltas;

	private ObservableList<String> asigPrimeroDam = FXCollections.observableArrayList();
	private ObservableList<String> asigSegundoDam = FXCollections.observableArrayList();

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		asigPrimeroDam.add("PROG");
		asigPrimeroDam.add("LSGMI");
		asigPrimeroDam.add("SISIN");
		asigPrimeroDam.add("BADAT");
		asigPrimeroDam.add("FOL");
		asigPrimeroDam.add("ENDES");

		asigSegundoDam.add("DESIN");
		asigSegundoDam.add("PMDM");
		asigSegundoDam.add("SGEM");
		asigSegundoDam.add("ADT");
		asigSegundoDam.add("EIE");

		cbCursos.getItems().addAll("1ºDAM", "2ºDAM");
		cbCursos.setValue(cbCursos.getItems().get(0));
		cbAsignaturas.setItems(asigPrimeroDam);
		cbAsignaturas.setValue(cbAsignaturas.getItems().get(0));

		alumnos.add(new Alumno("Rodrigo", "Cid Colino", 4, "2ºDAM"));
		alumnos.add(new Alumno("Otro", "Alumno Anonimo", 7, "1ºDAM"));

		cbAlumnos.setItems(filtrarAlumno(cbCursos.getValue()));

	}

	public ObservableList<Alumno> filtrarAlumno(String curso) {

		ObservableList<Alumno> alumnosTemporal = FXCollections.observableArrayList();

		for (Alumno a : alumnos) {

			if (a.getCurso().equals(curso)) {

				alumnosTemporal.add(a);
			}

		}

		return alumnosTemporal;
	}

	@FXML
	public void cambiarAlumno() {

		Alumno alumnoSeleccionado = cbAlumnos.getValue();

		if (alumnoSeleccionado != null) {
			Alumno a = buscarAlumno(alumnoSeleccionado.getNombre(), alumnoSeleccionado.getApellidos());

			if (a != null) {

				tfNombre.setText(a.getNombre());
				tfApellidos.setText(a.getApellidos());
				tfFaltas.setText(String.valueOf(a.getFaltasAsignaturas().get(cbAsignaturas.getValue())));

			}
		}
	}

	@FXML
	public void guardar() {

		Alumno a = buscarAlumno(tfNombre.getText(), tfApellidos.getText());
		if (a != null) {

			a.getFaltasAsignaturas().put(cbAsignaturas.getValue(), Integer.parseInt(tfFaltas.getText()));

		}

		else {

			Alumno newAlum = new Alumno(tfNombre.getText(), tfApellidos.getText(), 1, cbCursos.getValue());

			newAlum.getFaltasAsignaturas().put(cbAsignaturas.getValue(), Integer.parseInt(tfFaltas.getText()));
			alumnos.add(newAlum);
			cbAlumnos.setItems(filtrarAlumno(cbCursos.getValue()));

			updatear();
		}

	}

	@FXML
	public void borrar() {

		Alumno a = buscarAlumno(tfNombre.getText(), tfApellidos.getText());
		if (a != null) {

			alumnos.remove(a);

			tfNombre.setText("");
			tfApellidos.setText("");
			tfFaltas.setText("");

			cbAlumnos.setItems(filtrarAlumno(cbCursos.getValue()));
		}
	}

	private boolean checkExiste(Alumno a) {

		return alumnos.contains(a);
	}

	private Alumno buscarAlumno(String nombre, String apellidos) {

		for (Alumno alumno : alumnos) {
			if (alumno.getNombre().equals(nombre) && alumno.getApellidos().equals(apellidos)) {
				return alumno;
			}
		}
		return null;
	}

	@FXML
	private void cambiarCurso() {

		if (cbCursos.getValue().equals("1ºDAM")) {

			cbAsignaturas.setItems(asigPrimeroDam);
			cbAsignaturas.setValue(cbAsignaturas.getItems().get(0));

		}

		if (cbCursos.getValue().equals("2ºDAM")) {

			cbAsignaturas.setItems(asigSegundoDam);
			cbAsignaturas.setValue(cbAsignaturas.getItems().get(0));

		}

		cbAlumnos.setItems(filtrarAlumno(cbCursos.getValue()));

		updatear();
	}

	@FXML
	public void cambiarAsignatura() {

		updatear();

	}

	private void updatear() {

		Alumno a = cbAlumnos.getValue();

		if (a != null) {
			tfNombre.setText(a.getNombre());
			tfApellidos.setText(a.getApellidos());
			tfFaltas.setText(String.valueOf(a.getFaltasAsignaturas().get(cbAsignaturas.getValue())));
		}
		
		else {
			
			tfNombre.setText("");
			tfApellidos.setText("");
			tfFaltas.setText("");
			
		}

	}

}
