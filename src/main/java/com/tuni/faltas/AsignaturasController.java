package com.tuni.faltas;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.tuni.faltas.modelo.Alumno;
import com.tuni.faltas.modelo.Asignatura;
import com.tuni.faltas.modelo.Curso;
import com.tuni.faltas.modelo.Falta;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class AsignaturasController implements Initializable{

    @FXML
    private Label labelNombre;

    @FXML
    private TextField textEditNombre;

    @FXML
    private Label labelHoras;

    @FXML
    private TextField textEditHoras;

    @FXML
    private ComboBox<Curso> comboBoxCursos;

    @FXML
    private ComboBox<Asignatura> comboBoxAsignaturas;

    @FXML
    private Button buttonEliminarAsignatura;

    @FXML
    private Button buttonAñadirAlumno;

    @FXML
    private Button buttonGuardarCambios;

    private ObservableList<Curso> cursos = FXCollections.observableArrayList();
    public ObservableList<Asignatura> asignaturas = FXCollections.observableArrayList();

    public void initialize(URL location, ResourceBundle resources) {
    	inicializarDatos();
        comboBoxCursos.setItems(cursos);
        comboBoxAsignaturas.setItems(asignaturas);
    }

    private void inicializarDatos() {
    	Asignatura desin = new Asignatura("DESIN", 70);
        Asignatura pmdm = new Asignatura("PMDM", 50);
        Asignatura progr = new Asignatura("PROGR", 10);
        Asignatura badat = new Asignatura("BADAT", 30);
 
        // Crear cursos y asignarles asignaturas
        Curso DAM1 = new Curso("1DAM", FXCollections.observableArrayList(badat, progr));
        
        Curso DAM2 = new Curso("2DAM", FXCollections.observableArrayList(pmdm, desin));
        

        cursos.addAll(DAM1, DAM2);
    }

    @FXML
    private void comboBoxCurso(ActionEvent event) {
        Curso cursoSeleccionado = comboBoxCursos.getSelectionModel().getSelectedItem();
        if (cursoSeleccionado != null) {
            comboBoxAsignaturas.setItems(cursoSeleccionado.getAsignaturas());
        }
    }

    @FXML
    private void comboBoxAsignaturas(ActionEvent event) {
        Asignatura asignaturaSeleccionada = comboBoxAsignaturas.getSelectionModel().getSelectedItem();

        if (asignaturaSeleccionada != null) {
        	
            textEditNombre.setText(asignaturaSeleccionada.getNombre());
            textEditHoras.setText(String.valueOf(asignaturaSeleccionada.getHorasTotales()));
        } else {
            textEditNombre.clear();
            textEditHoras.clear();
        }
    }


    @FXML
    private void botonEliminarAsignatura(ActionEvent event) {
        Asignatura asignaturaSeleccionada = comboBoxAsignaturas.getSelectionModel().getSelectedItem();
        Curso cursoSeleccionado = comboBoxCursos.getSelectionModel().getSelectedItem();

        if (cursoSeleccionado != null && asignaturaSeleccionada != null) {
            cursoSeleccionado.getAsignaturas().remove(asignaturaSeleccionada);
            comboBoxAsignaturas.getItems().remove(asignaturaSeleccionada);

            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Asignatura eliminada");
            alert.setHeaderText(null);
            alert.setContentText("La asignatura " + asignaturaSeleccionada.getNombre() + " ha sido eliminada del curso " + cursoSeleccionado.getNombre());
            alert.showAndWait();
        }
    }

    @FXML
    private void botonAnadirAlumno(ActionEvent event) {
       try {
			MainApp.setRoot("AlumnosInterfaz");
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    private void botonGuardarCambios(ActionEvent event) {
        String nombreAsignatura = textEditNombre.getText().trim();
        String horasAsignaturaStr = textEditHoras.getText().trim();
        Curso cursoSeleccionado = comboBoxCursos.getSelectionModel().getSelectedItem();

        if (nombreAsignatura.isEmpty() || horasAsignaturaStr.isEmpty() || cursoSeleccionado == null) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, complete todos los campos y seleccione un curso.");
            alert.showAndWait();
            return;
        }
        try {
            int horasAsignatura = Integer.parseInt(horasAsignaturaStr);

            boolean asignaturaExiste = cursoSeleccionado.getAsignaturas().stream()
                    .anyMatch(asignatura -> asignatura.getNombre().equalsIgnoreCase(nombreAsignatura));

            if (asignaturaExiste) {
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Asignatura existente");
                alert.setHeaderText(null);
                alert.setContentText("La asignatura con el nombre \"" + nombreAsignatura + "\" ya existe en el curso.");
                alert.showAndWait();
            } else {
            	
                Asignatura nuevaAsignatura = new Asignatura(nombreAsignatura, horasAsignatura);
                cursoSeleccionado.getAsignaturas().add(nuevaAsignatura);

               
                comboBoxAsignaturas.setItems(cursoSeleccionado.getAsignaturas());

                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Asignatura añadida");
                alert.setHeaderText(null);
                alert.setContentText("La asignatura \"" + nombreAsignatura + "\" ha sido añadida al curso.");
                alert.showAndWait();
            }
        } catch (NumberFormatException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error en el formato");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, ingrese un número válido para las horas.");
            alert.showAndWait();
        }
    }

}
