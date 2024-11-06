package com.tuni.faltas;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.tuni.faltas.modelo.Alumno;
import com.tuni.faltas.modelo.Asignatura;
import com.tuni.faltas.modelo.Curso;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class AsignaturasController implements Initializable {

	@FXML
	private Button anadirAlumnoBoton;

	@FXML
	private ComboBox<Asignatura> asignaturaasComboBox;

	@FXML
	private ComboBox<Curso> cursosComboBox;

	@FXML
	private Button eliminarBoton;

	@FXML
	private Button guardarCambiosBoton;

	@FXML
	private TextField horasTexto;

	@FXML
	private TextField nombreTexto;

	ObservableList<Asignatura> asignaturas = FXCollections.observableArrayList();
	ObservableList<Curso> cursos = FXCollections.observableArrayList();

	public void initialize(URL location, ResourceBundle resources) {
		// Para comprobar el funcionamiento
		/*
		 * // crear objeto de tipo asignatura Asignatura pmdm = new Asignatura("PMDM",
		 * 30); Asignatura desin = new Asignatura("DESIN", 50); Asignatura badat = new
		 * Asignatura("BADAT", 10); Asignatura progr = new Asignatura("PROGR", 20);
		 * 
		 * // Crear curso y asignarle asignaturas Curso primeroDam = new Curso("1DAM",
		 * FXCollections.observableArrayList(badat, progr)); cursos.add(primeroDam);
		 * Curso segundoDam = new Curso("2DAM", FXCollections.observableArrayList(pmdm,
		 * desin)); cursos.add(segundoDam); //Bindear los combobox con sus listas
		 * asignaturaasComboBox.setItems(asignaturas); cursosComboBox.setItems(cursos);
		 */
	}

	// Añadir escuchador al boton eliminar asignatura
	@FXML
	private void eliminarBoton() {
		// obtener la asignatura seleccionada del comboBoxAsignatura
		Asignatura asignaturaSeleccionada = asignaturaasComboBox.getSelectionModel().getSelectedItem();

		// Borrar la asignatura del comboBoxAsignatura
		if (asignaturaSeleccionada != null) {
			asignaturas.remove(asignaturaSeleccionada);
		} else {
			Alert a = new Alert(AlertType.WARNING);
			a.setTitle("Ehhh!");
			a.setHeaderText("Cuidadin");
			a.setContentText("Hay que selccionar una asignatura");
			a.show();
		}

	}

	// Añadir escuchador al boton añadir alumno
	@FXML
	private void anadirAlumnoBoton() {

		try {
			MainApp.setRoot("interfazAlumno");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// añadir escuchador al boton guardar cambios
	@FXML
	private void guardarCambiosBoton() {
		// Obtener el nombre de la asignatura del TextField
		String nuevoNombreAsignatura = nombreTexto.getText();
		String nuevasHoras = horasTexto.getText();
		boolean encontrado = false;
		Asignatura asignaturaSeleccionada = asignaturaasComboBox.getSelectionModel().getSelectedItem();

		if (!horasTexto.getText().isEmpty()) {

			if (cursosComboBox.getSelectionModel().getSelectedItem() == null) {
				Alert a = new Alert(AlertType.WARNING);
				a.setTitle("Ehhh!");
				a.setHeaderText("Cuidadin");
				a.setContentText("Hay que selccionar un curso");
				a.show();
			}

			if (!nuevoNombreAsignatura.isEmpty()) {
				// recorrer la lista de asignaturas para ver si ya existe
				for (Asignatura asignatura : asignaturas) {

					if (asignatura.getNombre().equals(nuevoNombreAsignatura)) {
						encontrado = true;
						break;
					}
				}

				if (!encontrado) {
					// Añadir asignatura
					Asignatura nuevaAsignatura = new Asignatura(nuevoNombreAsignatura,
							Integer.parseInt(horasTexto.getText()));
					asignaturas.add(nuevaAsignatura);
				} else {
					// Actualizar horas
					asignaturaSeleccionada.setHorasTotales(Integer.parseInt(nuevasHoras));

				}

			} else {
				// Warning
				Alert a = new Alert(AlertType.WARNING);
				a.setTitle("Ehhh!");
				a.setHeaderText("Cuidadin");
				a.setContentText("Hay que escribir el nombre");
				a.show();
			} // Warning
			if (Integer.parseInt(nuevasHoras) < 1) {
				Alert a = new Alert(AlertType.WARNING);
				a.setTitle("Ehhh!");
				a.setHeaderText("Vamos a ver ho");
				a.setContentText("Parezte normal esi numeru de horas??");
				a.show();
			}
		} else {
			// Warning
			Alert a = new Alert(AlertType.WARNING);
			a.setTitle("Ehhh!");
			a.setHeaderText("Cuidadin");
			a.setContentText("Habra que poner horas, no?");
			a.show();
		}

	}

	// añadir escuchador al combobox de asignaturas
	@FXML
	private void asignaturaasComboBox() {

		// Obtener la asignatura seleccionada
		Asignatura asignaturaSeleccionada = asignaturaasComboBox.getSelectionModel().getSelectedItem();

		if (asignaturaSeleccionada != null) {
			nombreTexto.setText(asignaturaSeleccionada.getNombre());
			horasTexto.setText(asignaturaSeleccionada.getHorasTotales() + "");
		} else {
			nombreTexto.clear();
			horasTexto.clear();
		}
	}

	@FXML
	private void cursosComboBox() {

		ObservableList<Asignatura> asignaturass = cursosComboBox.getSelectionModel().getSelectedItem()
				.getListAsignatura();
		if (asignaturass != null) {
			asignaturas = cursosComboBox.getSelectionModel().getSelectedItem().getListAsignatura();
			asignaturaasComboBox.setItems(asignaturas);
		}
	}

}
