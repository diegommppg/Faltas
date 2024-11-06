package com.tuni.faltas;
 
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
 
import com.tuni.faltas.modelo.Asignatura;
import com.tuni.faltas.modelo.Curso;
 
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
 
public class AsignaturasController implements Initializable {
	// recuperar los elementos añadidos a la interfaz
	@FXML
	private Button buttonAñadirAlumno;
 
	@FXML
	private Button buttonEliminarAsignatura;
 
	@FXML
	private Button buttonGuardarCambios;
 
	@FXML
	private ComboBox<Asignatura> comboBoxAsignaturas;
 
	@FXML
	private ComboBox<Curso> comboBoxCursos;
 
	@FXML
	private Label labelHoras;
 
	@FXML
	private Label labelNombre;
 
	@FXML
	private TextField textEditNombre;
 
	@FXML
	private TextField textEditHoras;
 
	@FXML
	private Label labelAsignatura;
 
	@FXML
	private Label labelCurso;
 
	// crear coleccion de asignaturas y cursos
	ObservableList<Asignatura> listAsignatura = FXCollections.observableArrayList();
	ObservableList<Curso> listCursos = FXCollections.observableArrayList();
 
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// crear objeto de tipo asignatura
		Asignatura pmdm = new Asignatura("PMDM", 30);
		Asignatura desin = new Asignatura("DESIN", 50);
		Asignatura badat = new Asignatura("BADAT", 10);
		Asignatura progr = new Asignatura("PROGR", 20);
 
		// Crear curso y asignarle asignaturas
		Curso primeroDam = new Curso("1DAM", FXCollections.observableArrayList(badat, progr));
		listCursos.add(primeroDam);
		Curso segundoDam = new Curso("2DAM", FXCollections.observableArrayList(pmdm, desin));
		listCursos.add(segundoDam);
		// bindear los combobox con sus listas
		comboBoxAsignaturas.setItems(listAsignatura);
		comboBoxCursos.setItems(listCursos);
 
	}
 
	// añadir escuchador al boton eliminar asignatura
	@FXML
	private void botonEliminarAsignatura() {
		// obtener la asignatura seleccionada del comboBoxAsignatura
		Asignatura asignaturaSeleccionada = comboBoxAsignaturas.getSelectionModel().getSelectedItem();
 
		// borrar la asignatura introducida del comboBoxAsignatura
		if (asignaturaSeleccionada != null) {
			listAsignatura.remove(asignaturaSeleccionada);
		} else {
			System.out.println("Debe seleccionar una asignatura para borrar");
		}
 
	}
 
	// añadir escuchador al boton añadir alumno para que vaya a la interfaz alumno
	// cuando se clique
	@FXML
	private void botonAnadirAlumno() {
		try {
			MainApp.setRoot("interfazAlumno");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
	}
 
	// añadir escuchador al boton guardar cambios
	@FXML
	private void botonGuardarCambios() {
		// Obtener el nombre de la asignatura del TextField
		String nuevoNombreAsignatura = textEditNombre.getText();
		String nuevasHoras = textEditHoras.getText();
		boolean encontrado = false;
		Asignatura asignaturaSeleccionada = comboBoxAsignaturas.getSelectionModel().getSelectedItem();
		// Verificar que el campo no esté vacío
		if (!nuevoNombreAsignatura.isEmpty()) {
			// recorrer la lista de asignaturas para ver si ya existe
 
			for (Asignatura asignatura : listAsignatura) {
 
				if (asignatura.getNombre().equals(nuevoNombreAsignatura)) {
					encontrado = true;
					break;
				}
 
			}
 
			if (!encontrado) {
				// Añadir la asignatura si no existe
				Asignatura nuevaAsignatura = new Asignatura(nuevoNombreAsignatura,
						Integer.parseInt(textEditHoras.getText()));
				listAsignatura.add(nuevaAsignatura);
			}else {
				//si la asignatura ya existe, actualizar sus horas
				asignaturaSeleccionada.setHorasTotales(Integer.parseInt(nuevasHoras));
			}
 
		} else {
			// Mensaje de advertencia si el campo está vacío
			System.out.println("Introduce el nombre de una asignatura");
		}
 
	}
 
	// añadir escuchador al combobox de asignaturas
	@FXML
	private void comboBoxAsignatura() {
 
		// Obtener la asignatura seleccionada
		Asignatura asignaturaSeleccionada = comboBoxAsignaturas.getSelectionModel().getSelectedItem();
 
		if (asignaturaSeleccionada != null) {
			textEditNombre.setText(asignaturaSeleccionada.getNombre());
			textEditHoras.setText(asignaturaSeleccionada.getHorasTotales() + "");
		} else {
			textEditNombre.clear();
			textEditHoras.clear();
		}
	}
 
	@FXML
	private void comboBoxCurso() {
		// comprobar que la asignatura seleccionada no sea null
		ObservableList<Asignatura> asignaturas = comboBoxCursos.getSelectionModel().getSelectedItem()
				.getAsignatura();
		if (asignaturas != null) {
 
			listAsignatura = comboBoxCursos.getSelectionModel().getSelectedItem().getAsignatura();
			comboBoxAsignaturas.setItems(comboBoxCursos.getSelectionModel().getSelectedItem().getAsignatura());
		}
	}
 
}