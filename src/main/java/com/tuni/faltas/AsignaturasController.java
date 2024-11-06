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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AsignaturasController implements Initializable {

    // UI components
    @FXML
    private Button btnAgregarEstudiante, btnQuitarAsignatura, btnGuardarActualizaciones;
    @FXML
    private ComboBox<Asignatura> cmbxAsignaturas;
    @FXML
    private ComboBox<Curso> cmbxCursos;
    @FXML
    private Label lblDuracionHoras, lblNombreCurso;
    @FXML
    private TextField inputNombreCurso, inputDuracionHoras;

    // Data storage
    private ObservableList<Asignatura> asignaturasList = FXCollections.observableArrayList();
    private ObservableList<Curso> cursosList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Setup default data
        inicializarDatos();

        // Link ComboBoxes with data
        cmbxAsignaturas.setItems(asignaturasList);
        cmbxCursos.setItems(cursosList);
    }

    private void inicializarDatos() {
        // Crear asignaturas
    	Asignatura desin = new Asignatura("DESIN", 70);
        Asignatura pmdm = new Asignatura("PMDM", 50);
        Asignatura progr = new Asignatura("PROGR", 10);
        Asignatura badat = new Asignatura("BADAT", 30);

        // Crear cursos y asignarles asignaturas
        Curso primeroDam = new Curso("1DAM", FXCollections.observableArrayList(badat, progr));
        cursosList.add(primeroDam);
        Curso segundoDam = new Curso("2DAM", FXCollections.observableArrayList(pmdm, desin));
        cursosList.add(segundoDam);
    }

    // Método para quitar asignatura
    @FXML
    private void quitarAsignatura() {
        Asignatura seleccionada = cmbxAsignaturas.getSelectionModel().getSelectedItem();
        if (seleccionada != null) {
            asignaturasList.remove(seleccionada);
            Alert alertEliminarAsig = new Alert(Alert.AlertType.INFORMATION);
			alertEliminarAsig.setHeaderText(null);
			alertEliminarAsig.setTitle("Información");
			alertEliminarAsig.setContentText("Asignatura eliminada correctamente");
			alertEliminarAsig.showAndWait();
        } else {
            Alert alertEliminarAsig = new Alert(Alert.AlertType.ERROR);
            alertEliminarAsig.setHeaderText(null);
            alertEliminarAsig.setTitle("Error");
            alertEliminarAsig.setContentText("Debes seleccionar una asignatura");
            alertEliminarAsig.showAndWait();
        }
    }

    // Método para agregar un nuevo alumno
    @FXML
    private void agregarAlumno() {
        try {
            MainApp.setRoot("interfazAlumno");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Guardar cambios (añadir o actualizar asignatura)
    @FXML
    private void guardarCambios() {
        String nombre = inputNombreCurso.getText();
        String horas = inputDuracionHoras.getText();

        if (nombre.isEmpty()) {
			Alert alertActualizarAsig = new Alert(Alert.AlertType.INFORMATION);
			alertActualizarAsig.setHeaderText(null);
			alertActualizarAsig.setTitle("Información");
			alertActualizarAsig.setContentText("Debes introducir el nombre de la asignatura");
			alertActualizarAsig.showAndWait();
        	return;
        }
        
        if (horas.isEmpty()) {
			Alert alertActualizarAsig = new Alert(Alert.AlertType.INFORMATION);
			alertActualizarAsig.setHeaderText(null);
			alertActualizarAsig.setTitle("Información");
			alertActualizarAsig.setContentText("Debes introducir la duración de la asignatura");
			alertActualizarAsig.showAndWait();
			return;
		}

        boolean existe = asignaturasList.stream().anyMatch(a -> a.getNombre().equals(nombre));

        if (existe) {
            actualizarAsignatura(nombre, horas);
        } else {
            agregarNuevaAsignatura(nombre, horas);
        }
    }

    private void actualizarAsignatura(String nombre, String horas) {
        Asignatura seleccionada = cmbxAsignaturas.getSelectionModel().getSelectedItem();
        if (seleccionada != null) {
            seleccionada.setHorasTotales(Integer.parseInt(horas));

			Alert alertActualizarAsig = new Alert(Alert.AlertType.INFORMATION);
			alertActualizarAsig.setHeaderText(null);
			alertActualizarAsig.setTitle("Información");
			alertActualizarAsig.setContentText("Asignatura actualizada correctamente");
			alertActualizarAsig.showAndWait();
		} else {
			Alert alertActualizarAsig = new Alert(Alert.AlertType.ERROR);
			alertActualizarAsig.setHeaderText(null);
			alertActualizarAsig.setTitle("Error");
			alertActualizarAsig.setContentText("Debes seleccionar una asignatura");
			alertActualizarAsig.showAndWait();
        }
    }

    private void agregarNuevaAsignatura(String nombre, String horas) {
        Asignatura nueva = new Asignatura(nombre, Integer.parseInt(horas));
        asignaturasList.add(nueva);

		inputNombreCurso.clear();
		inputDuracionHoras.clear();
		cmbxAsignaturas.getSelectionModel().clearSelection();
		
		Alert alertNuevaAsig = new Alert(Alert.AlertType.INFORMATION);
		alertNuevaAsig.setHeaderText(null);
		alertNuevaAsig.setTitle("Información");
		alertNuevaAsig.setContentText("Nueva asignatura guardada correctamente");
		alertNuevaAsig.showAndWait();
    }

    // Manejo de selección de asignatura en ComboBox
    @FXML
    private void seleccionAsignatura() {
        Asignatura seleccionada = cmbxAsignaturas.getSelectionModel().getSelectedItem();
        if (seleccionada != null) {
            inputNombreCurso.setText(seleccionada.getNombre());
            inputDuracionHoras.setText(String.valueOf(seleccionada.getHorasTotales()));
        } else {
            inputNombreCurso.clear();
            inputDuracionHoras.clear();
        }
    }

    // Manejo de selección de curso en ComboBox
    @FXML
    private void seleccionCurso() {
        Curso cursoSeleccionado = cmbxCursos.getSelectionModel().getSelectedItem();
        if (cursoSeleccionado != null) {
            asignaturasList = cursoSeleccionado.getListAsignatura();
            cmbxAsignaturas.setItems(asignaturasList);
        }
    }
}
