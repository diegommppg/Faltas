package com.tuni.faltas;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
	private ComboBox<Alumno> cbAlumnos;

	private ObservableList<Alumno> alumnos = FXCollections.observableArrayList();

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

		cbAlumnos.setItems(alumnos);

	}

	@FXML
	public void cambiarAlumno() {

		Alumno alumnoSeleccionado = cbAlumnos.getValue();

		for (Alumno alu : alumnos) {

			if (alu.equals(alumnoSeleccionado)) {

				tfNombre.setText(alu.getNombre());
				tfApellidos.setText(alu.getApellidos());
				tfFaltas.setText(String.valueOf(alu.getFaltas()));
			}
		}

	}

	@FXML
	public void guardar() {

		// String nombreSeleccionado = cbAlumnos.getValue();

		Alumno a = new Alumno(tfNombre.getText(), tfApellidos.getText(), Integer.parseInt(tfFaltas.getText()));
		if (checkExiste(a)) {

			for (Alumno alu : alumnos) {

				if (alu.getNombre().equals(a.getNombre())) {

					alu.setFaltas(Integer.parseInt(tfFaltas.getText()));

				}
			}

		}

		else {

			Alumno nuevoAlumno = new Alumno(tfNombre.getText(), tfApellidos.getText(),
					Integer.parseInt(tfFaltas.getText()));
			alumnos.add(nuevoAlumno);

		}

	}

	@FXML
	public void borrar() {

		Alumno a = new Alumno(tfNombre.getText(), tfApellidos.getText(), Integer.parseInt(tfFaltas.getText()));
		if (checkExiste(a)) {

			for (Alumno alu : alumnos) {

				if (alu.getNombre().equals(a.getNombre())) {

					alumnos.remove(alu);

					if (!alumnos.isEmpty()) {
						tfNombre.setText(alumnos.get(0).getNombre());
						tfApellidos.setText(alumnos.get(0).getApellidos());
						tfFaltas.setText(String.valueOf(alumnos.get(0).getFaltas()));
					} else {

						tfNombre.setText("");
						tfApellidos.setText("");
						tfFaltas.setText("");

					}

				}
			}

		}

		else {

			tfNombre.setText("");
			tfApellidos.setText("");
			tfFaltas.setText("");

		}

	}

	private boolean checkExiste(Alumno a) {

		boolean existe = false;

		for (Alumno alu : alumnos) {

			if ((a.getNombre().equals(alu.getNombre())) && (a.getApellidos().equals(alu.getApellidos()))) {

				existe = true;
			}
		}

		return existe;
	}

}
